package ink.ckx.netty.codec.marshalling;

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
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            ResponseData rd = (ResponseData) msg;
            System.err.println("输出服务器端相应内容: " + rd.getId());
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
