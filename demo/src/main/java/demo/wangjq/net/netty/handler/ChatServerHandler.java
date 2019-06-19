package demo.wangjq.net.netty.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author:wangjq
 * @Date: 2019/6/19 09:54
 */
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();

        channels.add(channel);
        for (Channel ch : channels) {
            if (ch != channel) {
                System.out.println("server get msg:" + msg);
                ch.writeAndFlush(msg);
            }
        }
    }
}
