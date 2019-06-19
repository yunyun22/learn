package demo.wangjq.net.netty.handler;

import java.util.Objects;

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

    ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();

        for (Channel ch : channels) {
            if (!Objects.equals(ch, channel)) {
                ch.writeAndFlush(msg);
            }
        }
        channels.add(channel);
    }
}
