package com.luchao.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 *java反射
 * //第一种 Class.forName("包名")
 * //第二种 对象.getClass()
 * //第三种 类.class
 */
public class ClassTest {
    private ClassTest(){}
    public ClassTest(String name){
        System.out.println("这是构造器："+name);
    }
    public void getInfo(){
        System.out.println("这是一个方法");
    }
    public void GetInfo(String str){
        System.out.println("这是个有参方法");
    }
    public static void main(String[] args) throws NoSuchMethodException {
        Class<ClassTest> aClass = ClassTest.class;
        //获取ClassTest类的所有方法
        Method[] methods = aClass.getMethods();
        System.out.println("方法数量："+methods.length);
        for (Method method : methods) {
            System.out.println("方法名："+method.getName());
        }
        System.out.println("父类："+aClass.getSuperclass());

        //获取类的3种方法
        Class<?> demo1 = null,demo2,demo3;

        try {
            //一般尽量采用这种形式
            //第一种 Class.forName("包名")
            demo1 = Class.forName("com.luchao.reflect.ClassTest");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //第二种 对象.getClass()
        demo2 = new ClassTest().getClass();
        //第三种 类.class
        demo3 = ClassTest.class;
        System.out.println("类名称   " + demo1.getName());
        System.out.println("类名称   " + demo2.getName());
        System.out.println("类名称   " + demo3.getName());

        //--------------------
        //获取带有一个String类型的[构造器]，即Person（String str）
        Constructor consParamStr = demo1.getConstructor(String.class);
        System.out.println(consParamStr);
        //一次错误所有构造器
        Constructor[] constructors = demo2.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("构造器名称："+constructor.getName());
        }
    }
}
