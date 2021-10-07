package nio.chat;

import util.IOUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Set;

/**
 * @author chenkaixin
 * @description
 * @since 2021/10/1
 */
public class ChatServer {

    private ServerSocketChannel server;

    private Selector selector;

    private final ByteBuffer rByteBuffer = ByteBuffer.allocate(IOUtil.BUFFER);

    private final ByteBuffer wByteBuffer = ByteBuffer.allocate(IOUtil.BUFFER);

    private final int port;

    public ChatServer() {
        this(IOUtil.DEFAULT_PORT);
    }

    public ChatServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        chatServer.start();
    }

    private String receive(SocketChannel socketChannel) throws IOException {
        rByteBuffer.clear();
        while (socketChannel.read(rByteBuffer) > 0) {
        }
        rByteBuffer.flip();
        return String.valueOf(StandardCharsets.UTF_8.decode(rByteBuffer));
    }

    private void handlers(SelectionKey selectionKey) throws IOException {
        if (selectionKey.isAcceptable()) {
            // ACCEPT 事件：和客户端建立了连接
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
            SocketChannel client = serverSocketChannel.accept();
            client.configureBlocking(false);
            client.register(selector, SelectionKey.OP_READ);
            System.out.println(IOUtil.getClientName(client) + "已连接");
        } else if (selectionKey.isReadable()) {
            // READ 事件：客户端发送了消息
            SocketChannel client = (SocketChannel) selectionKey.channel();
            String forwardMsg = receive(client);
            System.out.println(IOUtil.getClientName(client) + "：" + forwardMsg);
            if (forwardMsg.isEmpty()) {
                // 客户端异常
                selectionKey.cancel();
                selector.wakeup();
            } else {
                forwardMessage(client, forwardMsg);
                // 检查用户是否退出
                if (IOUtil.readyToQuit(forwardMsg)) {
                    selectionKey.cancel();
                    selector.wakeup();
                }
            }
        }
    }

    private void forwardMessage(SocketChannel socketChannel, String msg) throws IOException {
        for (SelectionKey selectionKey : selector.keys()) {
            Channel channel = selectionKey.channel();
            if (channel instanceof ServerSocketChannel) {
                continue;
            }
            if (selectionKey.isValid() && !socketChannel.equals(channel)) {
                wByteBuffer.clear();
                wByteBuffer.put(StandardCharsets.UTF_8.encode(IOUtil.getClientName(socketChannel) + "：" + msg));
                wByteBuffer.flip();
                while (wByteBuffer.hasRemaining()) {
                    ((SocketChannel) channel).write(wByteBuffer);
                }
            }
        }
    }

    public void start() {
        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.socket().bind(new InetSocketAddress(port));

            selector = Selector.open();
            server.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("启动服务成功，监听端口：" + port);

            while (true) {
                selector.select();
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                for (SelectionKey selectionKey : selectionKeySet) {
                    // 处理被触发的事件
                    handlers(selectionKey);
                }
                selectionKeySet.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtil.close(selector);
        }
    }
}