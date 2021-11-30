package ink.ckx.netty.codec.protobuf.transfer;

import ink.ckx.netty.codec.protobuf.RequestModule;
import ink.ckx.netty.codec.protobuf.ResponseModule;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * @author chenkaixin
 * @description
 * @since 2021/11/30
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * Creates a client-side handler.
     */
    public ClientHandler() {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.err.println("客户端通道激活");
        for (int i = 0; i < 100; i++) {
            ctx.writeAndFlush(createRequest(i));
        }
    }

    private RequestModule.Request createRequest(int i) {
        return RequestModule.Request.newBuilder().setId("主键" + i)
                .setSequence(i)
                .setData("数据内容" + i)
                .build();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            ResponseModule.Response response = (ResponseModule.Response) msg;
            System.err.println("客户端：" + response.getId() + "," + response.getCode() + "," + response.getDesc());
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
