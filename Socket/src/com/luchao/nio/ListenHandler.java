package com.luchao.nio;

import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class ListenHandler extends IoFilterAdapter implements IoHandler{

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("-----session创建时调用-----");
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("session打开时调用，实际上是在sessionCreated后立即执行");
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("session关闭时调用");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		System.out.println("session空闲时调用");
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		System.out.println("异常时调用");
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		System.out.println("接收到新的request时调用");
		
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		System.out.println("发送在消息队列中未完成的消息时调用");
	}

}
