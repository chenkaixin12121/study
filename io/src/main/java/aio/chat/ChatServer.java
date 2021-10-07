package aio.chat;

import util.IOUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenkaixin
 * @description
 * @since 2021/10/6
 */
public class ChatServer {

    private final List<ClientHandler> connectedClientList;
    private final int port;
    private AsynchronousChannelGroup channelGroup;
    private AsynchronousServerSocketChannel serverChannel;

    public ChatServer() {
        this(IOUtil.DEFAULT_PORT);
    }

    public ChatServer(int port) {
        this.port = port;
        connectedClientList = new ArrayList<>();
    }

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        chatServer.start();
    }

    private synchronized void addClient(ClientHandler clientHandler) {
        connectedClientList.add(clientHandler);
        System.out.println(IOUtil.getClientName(clientHandler.getClientChannel()) + "已连接");

    }

    private synchronized void removeClient(ClientHandler clientHandler) {
        connectedClientList.remove(clientHandler);
        AsynchronousSocketChannel clientChannel = clientHandler.getClientChannel();
        System.out.println(IOUtil.getClientName(clientChannel) + "已断开连接");
        IOUtil.close(clientChannel);
    }

    private synchronized String receive(ByteBuffer buffer) {
        return String.valueOf(StandardCharsets.UTF_8.decode(buffer));
    }

    private synchronized void forwardMessage(AsynchronousSocketChannel clientChannel, String fwdMsg) {
        for (ClientHandler connectedHandler : connectedClientList) {
            AsynchronousSocketChannel client = connectedHandler.getClientChannel();
            if (!client.equals(clientChannel)) {
                try {
                    // 将要转发的信息写入到缓冲区中
                    ByteBuffer buffer = StandardCharsets.UTF_8.encode(IOUtil.getClientName(client) + "：" + fwdMsg);
                    // 写给其他客户
                    client.write(buffer, null, connectedHandler);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void start() {
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(IOUtil.THREAD_POOL_SIZE);
            channelGroup = AsynchronousChannelGroup.withThreadPool(executorService);
            serverChannel = AsynchronousServerSocketChannel.open(channelGroup);
            serverChannel.bind(new InetSocketAddress(IOUtil.LOCALHOST, port));
            System.out.println("启动服务器，监听端口：" + port);

            while (true) {
                serverChannel.accept(null, new AcceptHandler());
                System.in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtil.close(serverChannel);
        }
    }

    private class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {

        @Override
        public void completed(AsynchronousSocketChannel result, Object attachment) {
            if (serverChannel.isOpen()) {
                serverChannel.accept(null, this);
            }
            AsynchronousSocketChannel clientChannel = result;
            if (clientChannel != null && clientChannel.isOpen()) {
                ClientHandler handler = new ClientHandler(clientChannel);

                ByteBuffer buffer = ByteBuffer.allocate(IOUtil.BUFFER);
                addClient(handler);
                clientChannel.read(buffer, buffer, handler);
            }
        }

        @Override
        public void failed(Throwable exc, Object attachment) {
            System.err.println("连接失败：" + exc);
        }
    }

    private class ClientHandler implements CompletionHandler<Integer, Object> {

        private final AsynchronousSocketChannel clientChannel;

        public ClientHandler(AsynchronousSocketChannel channel) {
            this.clientChannel = channel;
        }

        public AsynchronousSocketChannel getClientChannel() {
            return clientChannel;
        }

        @Override
        public void completed(Integer result, Object attachment) {
            ByteBuffer buffer = (ByteBuffer) attachment;
            if (buffer != null) {
                if (result <= 0) {
                    // 客户端异常
                    removeClient(this);
                } else {
                    // 写模式变为读模式
                    buffer.flip();
                    String fwdMsg = receive(buffer);
                    System.out.println(IOUtil.getClientName(clientChannel) + ": " + fwdMsg);
                    // 转发消息
                    forwardMessage(clientChannel, fwdMsg);
                    buffer.clear();

                    if (IOUtil.readyToQuit(fwdMsg)) {
                        removeClient(this);
                    } else {
                        clientChannel.read(buffer, buffer, this);
                    }
                }
            }
        }

        @Override
        public void failed(Throwable exc, Object attachment) {
            System.err.println("读写操作失败：" + exc);
        }
    }
}
