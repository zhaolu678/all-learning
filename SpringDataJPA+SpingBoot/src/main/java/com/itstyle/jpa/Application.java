package com.itstyle.jpa;

import com.itstyle.jpa.model.User;
import com.itstyle.jpa.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * 启动类
 *
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
	private static final Logger logger = Logger.getLogger(Application.class);

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Application.class, args);
		logger.info("项目启动 ");
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setName("aaa");
		user.setAge(12);
		user.setId(1L);
		userRepository.save(user);
		List<User> list  = userRepository.findByNameLike("%a%");
		System.out.println("条数："+list.size());
		User user1 = userRepository.findByName("aaa");
		System.out.println("用户："+user1.toString());

	}
}