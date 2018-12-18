SpringDataJPA_QueryDsl Demo
参考：


1.pom.xml引入相应的包：
   <!--querydsl依赖 query dsl-->
        <dependency>
            <groupId>com.querydsl</groupId>
            <artifactId>querydsl-jpa</artifactId>
            <version>4.1.4</version>
        </dependency>
        <dependency>
            <groupId>com.querydsl</groupId>
            <artifactId>querydsl-apt</artifactId>
            <version>4.1.4</version>
            <scope>provided</scope>
        </dependency>
        <!--query dsl end-->

2.配置maven APT插件，用于生成查询实例。
       <!--该插件可以生成querysdl需要的查询对象，执行mvn compile即可-->
                  <plugin>
                      <groupId>com.mysema.maven</groupId>
                      <artifactId>apt-maven-plugin</artifactId>
                      <version>1.1.3</version>
                      <executions>
                          <execution>
                              <goals>
                                  <goal>process</goal>
                              </goals>
                              <configuration>
                                  <outputDirectory>target/generated-sources/java</outputDirectory>
                                  <processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>
                              </configuration>
                          </execution>
                      </executions>
                  </plugin>
3.


