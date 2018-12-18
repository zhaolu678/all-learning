高可用EureKa注册中心
2个eureka服务端使用命令启动，
java -jar eurekaserver-0.0.1-SNAPSHOT.jar --spring.profiles.active=eureka1
java -jar eurekaserver-0.0.1-SNAPSHOT.jar --spring.profiles.active=eureka2
在启动provider和consumer端


2个注册中心：使用jar包启动部署起来
http://localhost:9090/
http://localhost:9091/
2个provider
http://localhost:9092/getuser
http://localhost:9094/getuser
1个consumer
http://localhost:9093/user 访问时,回到注册中心获取eurekaprovider的节点，获取相关地址和端口。然后进行远程调用。
