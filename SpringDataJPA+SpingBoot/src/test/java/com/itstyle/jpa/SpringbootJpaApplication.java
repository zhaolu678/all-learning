package com.itstyle.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import com.itstyle.jpa.model.User;
import com.itstyle.jpa.repository.UserRepository;


@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		addUser();
		
//		User user = findUser();
//		if(null!=user){
//			System.out.println(user.toString());
//		}
		
//		List<User> list1 = userRepository.findByAgeGreaterThan(25);
//		System.out.println("数量"+list1.size());
//		for (User user : list1) {
//			System.out.println(user.toString());
//		}
		
//		List<User> list2 = userRepository.findByNameLike("张三");
//		for (User user : list2) {
//			System.out.println(user.toString());
//		}
		
//		User user = userRepository.testQueryInfo(26, "用户5");
//		System.out.println("user----"+user.toString());
		
		
//		System.out.println(userRepository.getTotalCount());
		
		userRepository.updateUserName(12L, "用户99");
	}
	
	public List<User> findByNameLike(String str){
		return userRepository.findByNameLike(str);
	}
	
	/**
	 * 添加数据
	 */
	public void addUser(){
		for (int i = 0; i < 10; i++) {
			try {
				User user = new User();
				user.setName("用户"+i);
				user.setAge(21+i);
				userRepository.save(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 查询
	 */
	public User findUser() {
		return userRepository.findByName("张三");
	}
}