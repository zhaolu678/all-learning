package com.itstyle.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itstyle.jpa.model.User;
import org.springframework.stereotype.Repository;

/**
 * 数据操作层
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);
	
	User findByAge(Integer age);

	User findByNameAndAge(String name, Integer age);
	
	List<User> findByNameLike(String name);

	@Query("from User u where u.name=:name")
	User findUser(@Param("name") String name);
	
	//wehre age>?
	List<User> findByAgeGreaterThan(Integer age);
	
	//where age=? and name=?
	@Query("Select u from User u where u.age = ? and u.name = ?")
	User testQueryInfo(Integer age,String name);
	
	//使用nativeQuery=true，可以使用原生的SQL
	@Query(value="select count(id) from sys_user",nativeQuery=true)
	long getTotalCount();
	
	//需要加事务才能执行，在Service上添加事务，并在Spring配置文件中添加扫描包的注解
	@Modifying
	@Query("Update User u set u.name = :name where u.id = :id")
	void updateUserName(@Param("id") Long id,@Param("name")String name);
}
