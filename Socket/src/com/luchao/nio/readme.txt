public void exceptionCaught(IoSession session, Throwable cause)    当接口中其他方法抛出异常未被捕获时触发此方法。
public void messageReceived(IoSession session, Object message)    当接收到客户端的请求信息后触发此方法。
public void messageSent(IoSession session, Object message)    当信息已经发送至客户端后触发此方法。
public void inputClosed(IoSession session)    当信息接收被关闭输入时触发次方法。
public void sessionClosed(IoSession session)    当连接被关闭时触发，例如客户端程序意外退出等。
public void sessionCreated(IoSession session)    当一个新客户端连接后触发此方法。
public void sessionIdle(IoSession session, IdleStatus status)    当连接空闲时触发此方法。
public void sessionOpened(IoSession session)    当连接后打开时触发此方法，一般此方法与 sessionCreated 会被同时触发。



参考：
http://blog.csdn.net/yoara/article/details/37597141
