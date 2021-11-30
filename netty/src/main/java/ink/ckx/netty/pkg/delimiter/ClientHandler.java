package ink.ckx.netty.pkg.delimiter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * @author chenkaixin
 * @description
 * @since 2021/11/30
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("client channel active... ");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            String response = (String) msg;
            System.out.println("Client: " + response);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}