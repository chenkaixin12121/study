package bio.chat;

import util.IOUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author chenkaixin
 * @description
 * @since 2021/10/1
 */
public class ChatHandler implements Runnable {

    private final ChatServer chatServer;

    private final Socket socket;

    public ChatHandler(ChatServer chatServer, Socket socket) {
        this.chatServer = chatServer;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 存储新上线用户
            chatServer.addClient(socket);
            // 读取用户发送的消息
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            // 读取客户端发送的消息
            String msg;
            while ((msg = bufferedReader.readLine()) != null) {
                String forwardMsg = String.format(IOUtil.getClientName(socket) + "：%s%n", msg);
                System.out.print(forwardMsg);
                // 将消息转发给其他用户
                chatServer.forwardMessage(socket, forwardMsg);
                // 是否退出
                if (IOUtil.readyToQuit(msg)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                chatServer.removeClient(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}