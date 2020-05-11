package testservernetty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

/**
 * @Description: TODO
 * @Author duanliping
 * @Date 2020/5/11
 **/
public class MyClientHandler extends SimpleChannelInboundHandler<String> {
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
//        System.out.println(ctx.channel().remoteAddress());
        System.out.println("client output: "+ msg);
        ctx.writeAndFlush("from client: "+ LocalDateTime.now());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("来自客户端的问候");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
