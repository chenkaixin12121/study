package aio.chat;

import util.IOUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

/**
 * @author chenkaixin
 * @description
 * @since 2021/10/7
 */
public class UserInputHandler implements Runnable {

    private final ChatClient client;

    public UserInputHandler(ChatClient chatClient) {
        this.client = chatClient;
    }

    @Override
    public void run() {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String msg = consoleReader.readLine();
                client.send(msg);
                if (IOUtil.readyToQuit(msg)) {
                    System.out.println("成功退出聊天室");
                    break;
                }
            } catch (IOException | InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}