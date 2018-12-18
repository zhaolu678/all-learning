SpringDataJPA Demo
参考：https://www.cnblogs.com/weilunhui/p/5025383.html

1.集成配置
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:jpa="http://www.springframework.org/schema/data/jpa"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context-4.3.xsd
        http://www.springframework.org/schema/data/jpa
        http://www.springframework.org/schema/data/jpa/spring-jpa.xsd
        http://www.springframework.org/schema/tx
        http://www.springframework.org/schema/tx/spring-tx.xsd">


    <!-- 1.引入属性文件，在配置中占位使用:db.properties -->
    <context:property-placeholder location="classpath:db.properties"></context:property-placeholder>
    <!-- 2.配置数据源 -->
    <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
        <property name="driverClassName" value="${mysql.driver}"/>
        <property name="url" value="${mysql.url}"/>
        <property name="username" value="${mysql.username}"/>
        <property name="password" value="${mysql.password}"/>
        <!-- 其他配置 -->
    </bean>
    <!--3.jpa包 -->
    <jpa:repositories base-package="com.luchao"/>
    <!--4.创建entity工厂 -->
    <bean id="entityManagerFactory" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="packagesToScan" value="com.luchao.entity"/>
        <property name="jpaVendorAdapter">
            <bean class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter"></bean>
        </property>
        <property name="jpaProperties">
            <props>
                <prop key="hibernate.ejb.naming_strategy">org.hibernate.cfg.ImprovedNamingStrategy</prop>
                <prop key="hibernate.hbm2ddl.auto">update</prop>
                <prop key="hibernate.show_sql">true</prop>
                <prop key="hibernate.format_sql">true</prop>
                <prop key="hibernate.dialect">org.hibernate.dialect.MySQL5InnoDBDialect</prop>
            </props>
        </property>
    </bean>

    <!--配置针对JPA的局部事务管理器-->
    <bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
        <property name="entityManagerFactory" ref="entityManagerFactory"/>
    </bean>
    <!--根据事务注解来生成事务代理-->
    <tx:annotation-driven transaction-manager="transactionManager"/>

</beans>
2.实体类上使用注解：
@Table(name = "goods")
@Entity
id自增
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
3,继承JpaRepostitory类
@Repository
public interface GoodsRepository extends JpaRepository<Goods,Long> {
4.自定义SQL查询：（from后边要跟实体名Goods）
@Query("SELECT good FROM Goods as good where price>:price")
List<Goods> findzdy(@Param("price") double price);
5.删除和修改自定义SQL
删除和修改需要事务支持，只使用简单的@Query将报错，还需要标注@Modifying和@Transactional
@Modifying
@Transactional
@Query("DELETE FROM Goods where id = :id")
void delzdy(@Param("id") int id);
6.自定义原生SQL： nativeQuery = true
@Query(value = "SELECT good.* FROM goods as good where price>:price", nativeQuery = true)
List<Goods> finddzyys(@Param("price") double price);

