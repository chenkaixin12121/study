package ink.ckx.netty.pkg.delimiter;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author chenkaixin
 * @description
 * @since 2021/11/30
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println(" server channel active... ");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String request = (String) msg;
        System.out.println("Server :" + request);
        String response = "服务器响应：" + request + "$_";
        ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable t) {
        ctx.close();
    }
}