package bio.test;

import util.IOUtil;

import java.io.*;
import java.net.Socket;

/**
 * @author chenkaixin
 * @description
 * @since 2021/10/1
 */
public class Client {

    public static void main(String[] args) {

        // 创建 Socket
        try (Socket socket = new Socket(IOUtil.LOCALHOST, IOUtil.DEFAULT_PORT)) {
            // 创建 IO 流
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())
            );
            // 输入信息
            BufferedReader consoleReader = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            while (true) {
                String input = consoleReader.readLine();
                // 发送消息到服务器
                bufferedWriter.write(input + "\n");
                bufferedWriter.flush();
                // 读取服务器返回的消息
                String msg = bufferedReader.readLine();
                System.out.println("服务器：" + msg);
                // 检查是否退出
                if (IOUtil.readyToQuit(msg)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}