package nio.chat;

import util.IOUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Set;

/**
 * @author chenkaixin
 * @description
 * @since 2021/10/1
 */
public class ChatClient {

    private SocketChannel client;

    private Selector selector;

    private final ByteBuffer rByteBuffer = ByteBuffer.allocate(IOUtil.BUFFER);

    private final ByteBuffer wByteBuffer = ByteBuffer.allocate(IOUtil.BUFFER);

    private final String host;

    private final int port;

    public ChatClient() {
        this(IOUtil.LOCALHOST, IOUtil.DEFAULT_PORT);
    }

    public ChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        chatClient.start();
    }

    private String receive(SocketChannel socketChannel) throws IOException {
        rByteBuffer.clear();
        while (socketChannel.read(rByteBuffer) > 0) {
        }
        rByteBuffer.flip();
        return String.valueOf(StandardCharsets.UTF_8.decode(rByteBuffer));
    }

    private void handlers(SelectionKey selectionKey) throws IOException {
        if (selectionKey.isConnectable()) {
            // CONNECT 事件：连接就绪事件
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            if (socketChannel.isConnectionPending()) {
                socketChannel.finishConnect();
                // 处理用户的输入信息
                new Thread(new UserInputHandler(this)).start();
            }
            socketChannel.register(selector, SelectionKey.OP_READ);
        } else if (selectionKey.isReadable()) {
            // READ 事件：服务器转发消息
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            String msg = receive(socketChannel);
            if (msg.isEmpty()) {
                // 服务器异常
                IOUtil.close(selector);
            } else {
                System.out.println(msg);
            }
        }
    }

    public void send(String msg) throws IOException {
        if (msg.isEmpty()) {
            return;
        }
        wByteBuffer.clear();
        wByteBuffer.put(StandardCharsets.UTF_8.encode(msg));
        wByteBuffer.flip();
        while (wByteBuffer.hasRemaining()) {
            client.write(wByteBuffer);
        }
        // 检查用户是否退出
        if (IOUtil.readyToQuit(msg)) {
            IOUtil.close(selector);
        }
    }

    public void start() {
        try {
            client = SocketChannel.open();
            client.configureBlocking(false);

            selector = Selector.open();
            client.register(selector, SelectionKey.OP_CONNECT);
            client.connect(new InetSocketAddress(host, port));

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
        } catch (ClosedSelectorException ignored) {
        } finally {
            IOUtil.close(selector);
        }
    }
}