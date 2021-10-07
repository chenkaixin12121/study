package bio.chat;

import util.IOUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenkaixin
 * @description
 * @since 2021/10/1
 */
public class ChatServer {

    private final Map<Integer, Writer> connectedClientMap;

    private final ExecutorService executorService;

    public ChatServer() {
        this.connectedClientMap = new HashMap<>();
        this.executorService = Executors.newFixedThreadPool(IOUtil.THREAD_POOL_SIZE);
    }

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        chatServer.start();
    }

    public synchronized void addClient(Socket socket) throws IOException {
        if (socket != null) {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())
            );
            connectedClientMap.put(socket.getPort(), bufferedWriter);
            System.out.println(IOUtil.getClientName(socket) + "已连接");
        }
    }

    public synchronized void removeClient(Socket socket) throws IOException {
        if (socket != null && connectedClientMap.containsKey(socket.getPort())) {
            connectedClientMap.get(socket.getPort()).close();
            connectedClientMap.remove(socket.getPort());
            System.out.println(IOUtil.getClientName(socket) + "已退出");
        }
    }

    public synchronized void forwardMessage(Socket socket, String msg) throws IOException {
        for (Map.Entry<Integer, Writer> entry : connectedClientMap.entrySet()) {
            if (!entry.getKey().equals(socket.getPort())) {
                Writer writer = entry.getValue();
                writer.write(msg);
                writer.flush();
            }
        }
    }

    public void start() {
        // 绑定监听端口
        try (ServerSocket serverSocket = new ServerSocket(IOUtil.DEFAULT_PORT)) {
            System.out.printf("启动服务成功，监听端口：" + IOUtil.DEFAULT_PORT);

            while (true) {
                // 等待客户端连接
                Socket socket = serverSocket.accept();
                // 创建 ChatHandler 线程
                executorService.execute(new ChatHandler(this, socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭服务成功");
        }
    }
}