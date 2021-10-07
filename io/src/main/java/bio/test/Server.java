package bio.test;

import util.IOUtil;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chenkaixin
 * @description
 * @since 2021/10/1
 */
public class Server {

    public static void main(String[] args) {

        // 绑定监听端口
        try (ServerSocket serverSocket = new ServerSocket(IOUtil.DEFAULT_PORT)) {
            System.out.println("启动服务成功");

            while (true) {
                // 等待客户端连接
                Socket socket = serverSocket.accept();
                System.out.println(IOUtil.getClientName(socket) + "已连接");

                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream())
                );
                // 读取客户端发送的消息
                String msg;
                while ((msg = bufferedReader.readLine()) != null) {
                    System.out.println(IOUtil.getClientName(socket) + "：" + msg);
                    // 服务器回复
                    bufferedWriter.write(msg + "\n");
                    bufferedWriter.flush();
                    // 检查是否退出
                    if (IOUtil.readyToQuit(msg)) {
                        System.out.println(IOUtil.getClientName(socket) + "已退出");
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}