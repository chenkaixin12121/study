package bio.chat;

import util.IOUtil;

import java.io.*;
import java.net.Socket;

/**
 * @author chenkaixin
 * @description
 * @since 2021/10/1
 */
public class ChatClient {

    private Socket socket;

    private BufferedReader bufferedReader;

    private BufferedWriter bufferedWriter;

    public ChatClient() {
    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        chatClient.start();
    }

    public void send(String msg) throws IOException {
        // 发送消息给服务器
        if (!socket.isOutputShutdown()) {
            bufferedWriter.write(msg + "\n");
            bufferedWriter.flush();
        }
    }

    public String receive() throws IOException {
        // 从服务器接收消息
        String msg = null;
        if (!socket.isInputShutdown()) {
            msg = bufferedReader.readLine();
        }
        return msg;
    }

    public void start() {
        // 创建 Socket
        try {
            socket = new Socket(IOUtil.LOCALHOST, IOUtil.DEFAULT_PORT);
            // 创建 IO 流
            bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())
            );
            // 输入信息
            new Thread(new UserInputHandler(this)).start();
            // 处理信息
            String msg;
            while ((msg = receive()) != null) {
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtil.close(bufferedWriter);
        }
    }
}