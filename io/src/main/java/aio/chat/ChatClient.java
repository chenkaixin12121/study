package aio.chat;

import util.IOUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author chenkaixin
 * @description
 * @since 2021/10/7
 */
public class ChatClient {

    private AsynchronousSocketChannel clientChannel;

    public static void main(String[] args) {
        ChatClient client = new ChatClient();
        client.start();
    }

    public void send(String msg) throws ExecutionException, InterruptedException {
        if (msg.isEmpty()) {
            return;
        }
        ByteBuffer buffer = StandardCharsets.UTF_8.encode(msg);
        Future<Integer> writeResult = clientChannel.write(buffer);
        writeResult.get();
    }

    private void start() {
        try {
            // 创建异步通道 channel，并发起连接请求
            clientChannel = AsynchronousSocketChannel.open();
            Future<Void> future = clientChannel.connect(new InetSocketAddress(IOUtil.LOCALHOST, IOUtil.DEFAULT_PORT));
            // 阻塞式调用，直到建立连接再进行下一步操作
            future.get();
            System.out.println("已连接到服务器");
            // 创建线程处理用户输入
            new Thread(new UserInputHandler(this)).start();
            // 主线程中循环读取服务器转发过来的其他客户的消息
            ByteBuffer buffer = ByteBuffer.allocate(IOUtil.BUFFER);
            while (true) {
                Future<Integer> readResult = clientChannel.read(buffer);
                // 阻塞式读取数据
                int result = readResult.get();
                if (result <= 0) {
                    // 发生异常，没有读取到数据
                    IOUtil.close(clientChannel);
                    break;
                } else {
                    // 正常打印消息
                    buffer.flip();
                    String msg = String.valueOf(StandardCharsets.UTF_8.decode(buffer));
                    buffer.clear();
                    System.out.println(msg);
                }
            }
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            IOUtil.close(clientChannel);
        }
    }
}