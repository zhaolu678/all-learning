swager访问路径：
http://localhost:8080/swagger-ui.html

号称：世界最流行的API框架
官网：http://swagger.io/
解决什么问题：
在前后台分离的开发模式中，减小接口定义沟通成本，方便开发过程中测试，自动生成接口文档

使用方式：
1、通过官网配置文档，一个接口一个接口编写
2、通多注解配置，动态生成json数据，由框架自动生成代码展示


swager集成
pom文件
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.7.0</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.7.0</version>
</dependency>
增加swagger启动类
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.luchao.springbootswager.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //标题
                .title("测试API接口")
                //创建人
                .contact(new Contact("Luchao","https://gitee.com/zhaolu666/AllDemo/tree/master/springbootdemo/springboot-swager",""))
                .version("1.0")
                .description("toindex|获取accesstoken接口|获取userinfo接口")
                .build();
    }

}
controller添加注解
@RestController
@RequestMapping("/test")
@Api("testController API TEST")
方法添加注解
@ApiOperation("获取用户信息")
@ApiImplicitParams({
        @ApiImplicitParam(paramType="query",name="username",dataType="String",required=true,value="用户姓名"),
        @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户密码"),
        @ApiImplicitParam(paramType="query",name="age",dataType="String",required=true,value="年龄",defaultValue="10")
})
@ApiResponses({
        @ApiResponse(code=400,message="请求参数没填好"),
        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
})
@RequestMapping(value="/getUser",method=RequestMethod.GET)
public User getStudent(String username,String password,Integer age) {
    User us= new User();
    us.setUserName(username);
    us.setPassword(password);
    us.setAge(age);
    return us;
}
swager访问路径：http://localhost:8080/swagger-ui.html

注释说明
详细解释：https://blog.csdn.net/java_yes/article/details/79183804
 @Api()用于类；
表示标识这个类是swagger的资源
 @ApiOperation()用于方法；
表示一个http请求的操作
 @ApiParam()用于方法，参数，字段说明；
表示对参数的添加元数据（说明或是否必填等）
 @ApiModel()用于类
表示对类进行说明，用于参数用实体类接收
 @ApiModelProperty()用于方法，字段
表示对model属性的说明或者数据操作更改
 @ApiIgnore()用于类，方法，方法参数
表示这个方法或者类被忽略
 @ApiImplicitParam() 用于方法
表示单独的请求参数
 @ApiImplicitParams() 用于方法，包含多个 @ApiImplicitParam
1. name ：参数名。
2. value ： 参数的具体意义，作用。
3. required ： 参数是否必填。
4. dataType ：参数的数据类型。
5. paramType ：查询参数类型，这里有几种形式：

@ApiResponse
返回参数

2、具体使用
@Api()用于类；
参数：
tags:表示说明，tags如果有多个值，会生成多个list
value:已废用
hidde:无效果
description:接口说明
