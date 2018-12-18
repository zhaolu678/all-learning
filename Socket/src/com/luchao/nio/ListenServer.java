package com.luchao.nio;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.concurrent.Executors;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.transport.socket.DatagramSessionConfig;
import org.apache.mina.transport.socket.nio.NioDatagramAcceptor;

public class ListenServer {
	
	public static void main(String[] args) {
		NioDatagramAcceptor acceptor = new NioDatagramAcceptor();
		acceptor.setHandler(new ListenHandler()); // 你的业务处理，最简单的，可以extends
														// IoHandlerAdapter

		DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
		chain.addLast("keep-alive", new HachiKeepAliveFilterInMina()); // 心跳
		chain.addLast("toMessageTyep", new MyMessageEn_Decoder());
		// 将传输的数据转换成你的业务数据格式。比如下面的是将数据转换成一行行的文本
		// acceptor.getFilterChain().addLast("codec",new ProtocolCodecFilter(new
		// TextLineCodecFactory(Charset.forName("UTF-8"))));

		chain.addLast("logger", new LoggingFilter());
		DatagramSessionConfig dcfg = acceptor.getSessionConfig();
		dcfg.setReuseAddress(true);
		acceptor.bind(new InetSocketAddress(ClusterContext.getHeartBeatPort()));
	}

}
