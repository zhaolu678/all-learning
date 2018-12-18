package com.luchao.springbootthymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class DemoController {

    @RequestMapping("/")
    public String totest(Author author){
        System.out.println("======toregistry=======");
        return "registry";
    }
    @RequestMapping("/add")
    public String add(Model model,@Valid Author author, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("author",author);
            return "registry";
        }else {
            System.out.println(author.toString());
            model.addAttribute("msg","添加成功!");
            return "sucess";
        }
    }
    @RequestMapping("/demo")
    public String firstdemo(Model model){
        System.out.println("======");
        model.addAttribute("msg","world!");
        return "login";
    }
    @GetMapping("/index1")
    public String index1(HttpServletRequest request) {
        // TODO 与上面的写法不同，但是结果一致。
        // 设置属性
        request.setAttribute("title", "我的第一个WEB页面");
        request.setAttribute("desc", "欢迎进入XXX 系统");
        Author author = new Author();
        author.setAge(24);
        author.setEmail("XXXXXXXXX@qq.com");
        author.setUsername("xx");
        request.setAttribute("author", author);
        // 返回的 index 默认映射到 src/main/resources/templates/xxxx.html
        return "index";
    }

}
