package org.practice.netty4.book02.ch02;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        System.out.println("EchoClientHandler.channelRead0: " + byteBuf.toString(CharsetUtil.UTF_8));
    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("EchoClientHandler.channelActive");
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("EchoClientHandler.exceptionCaught");
        cause.printStackTrace();
        ctx.close();
    }
}
