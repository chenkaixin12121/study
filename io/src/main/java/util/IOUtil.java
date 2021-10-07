package util;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author chenkaixin
 * @description
 * @since 2021/10/7
 */
public class IOUtil {

    public static final String QUIT = "quit";

    public static final String LOCALHOST = "localhost";

    public static final int DEFAULT_PORT = 8888;

    public static final int BUFFER = 1024;

    public static final int THREAD_POOL_SIZE = 8;

    public static boolean readyToQuit(String msg) {
        return QUIT.equals(msg);
    }

    public static String getClientName(AsynchronousSocketChannel clientChannel) {
        int port = -1;
        try {
            InetSocketAddress remoteAddress = (InetSocketAddress) clientChannel.getRemoteAddress();
            port = remoteAddress.getPort();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "客户端[" + port + "]";
    }

    public static String getClientName(Socket socket) {
        return "客户端[" + socket.getPort() + "]";
    }

    public static String getClientName(SocketChannel socketChannel) {
        return "客户端[" + socketChannel.socket().getPort() + "]";
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
