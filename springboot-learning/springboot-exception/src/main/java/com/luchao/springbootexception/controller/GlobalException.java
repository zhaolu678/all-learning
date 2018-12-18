package com.luchao.springbootexception.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

/**
 * 通过SimpleMappingExceptionResolver做全局异常处理
 */
@Configuration
public class GlobalException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if(e instanceof ArithmeticException){
            modelAndView.setViewName("error1");
        }else if (e instanceof NullPointerException){
            modelAndView.setViewName("error2");
        }
        modelAndView.addObject("error",e.toString());
        return modelAndView;
    }
//    /**
//     * 单独配置某种错误,只拦截ArithmeticException错误
//     *
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
//    public ModelAndView arithmeticExceptionHandler(Exception e) {
//        ModelAndView m = new ModelAndView();
//        m.addObject("error", e.toString());
//        m.setViewName("error1");
//        return m;
//    }
//
//    /**
//     * 单独配置某种错误,只拦截空指针错误
//     *
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(value = {java.lang.NullPointerException.class})
//    public ModelAndView nullPointerExceptionHandel(Exception e) {
//        ModelAndView m = new ModelAndView();
//        m.addObject("error", e.toString());
//        m.setViewName("error1");
//        return m;
//    }

//    /**
//     * 该方法必须要有返回值。返回值类型必须是：SimpleMappingExceptionResolver
//     * @return
//     */
//    @Bean
//    public SimpleMappingExceptionResolver getsimpleMappingExceptionResolver(){
//        SimpleMappingExceptionResolver ss = new SimpleMappingExceptionResolver();
//        Properties properties = new Properties();
//        /**
//         * 参数一：异常的类型
//         * 参数二：跳转的视图
//         */
//        properties.put("java.lang.ArithmeticException","error1");
//        properties.put("java.lang.NullPointerException","error2");
//        //设置异常与视图的映射关系
//        ss.setExceptionMappings(properties);
//        return  ss;
//    }

}
