package ink.ckx.netty.codec.protobuf.transfer;

import ink.ckx.netty.codec.protobuf.RequestModule;
import ink.ckx.netty.codec.protobuf.ResponseModule;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author chenkaixin
 * @description
 * @since 2021/11/30
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RequestModule.Request request = (RequestModule.Request) msg;
        System.err.println("服务端：" + request.getId() + "," + request.getSequence() + "," + request.getData());
        ctx.writeAndFlush(createResponse(request.getId(), request.getSequence()));
    }

    private ResponseModule.Response createResponse(String id, int seq) {
        return ResponseModule.Response.newBuilder()
                .setId(id)
                .setCode(seq)
                .setDesc("响应报文")
                .build();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}