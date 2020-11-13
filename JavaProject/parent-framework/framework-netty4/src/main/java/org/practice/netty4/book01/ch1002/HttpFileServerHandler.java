package org.practice.netty4.book01.ch1002;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;

public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

	//@Override
	//protected void messageReceived(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
	//	// TODO Auto-generated method stub
	//
	//}

	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) throws Exception {

	}
}
