import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.luchao")
@EnableAutoConfiguration
public class APP implements EmbeddedServletContainerCustomizer {

	@Value(value = "${service.prot:8080}")
	private int prot;
	// 启动
	public static void main(String[] args) {
		SpringApplication.run(APP.class, args);
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		// 修改默认端口
		container.setPort(prot);
	}
}
