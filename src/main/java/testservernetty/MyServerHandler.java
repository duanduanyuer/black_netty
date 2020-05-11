package testservernetty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * @Description: TODO
 * @Author duanliping
 * @Date 2020/5/11
 **/
public class MyServerHandler extends SimpleChannelInboundHandler<String> {
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
//        System.out.println(ctx.channel().remoteAddress() + ", "+msg);
        ctx.channel().writeAndFlush("from server: "+ UUID.randomUUID());

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("来自服务端的问候");
    }

    /**
     * 出现异常 关闭资源
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
