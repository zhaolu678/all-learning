package com.luchao.lambda;

import com.sun.javafx.text.TextRun;

/*
 * Lambda表达式就是 匿名内部类的另一种更加简洁的语法表达。
 * 
 * Lambda 表达式的基础语法：java8中引入了新的操作符“->” 该操作符称为剪头操作符或 Lambda操作符
 *                        箭头操作符将Lamdba表达式拆分成两部分：
 *                        
 * 左侧：Lambda 表达式的参数列表
 * 右侧：Lambda 表达式中所需要执行的功能，即Lambda体。
 * 
 */
public class LambdaTest3 {

	//接口
	interface jisuan{
		int twonum(int a,int b);
	}
	
	//方法中传递了接口
	public static int yunsuan(int a,int b,jisuan js) {
		return js.twonum(a, b);
	}
	
	public static void main(String[] args) {
		//接口实现类
		//类型声明
		jisuan js_jia = (int a,int b) ->a+b;
		//不声明类型
		jisuan js_jian = (a,b) ->a-b;
		//大括号
		jisuan js_cheng = (a,b) ->{return a*b ;};
		jisuan js_chu = (a,b)->a/b;
		
		int aa=10,bb=5;
		System.out.println(yunsuan(aa, bb, js_jia));
		System.out.println(yunsuan(aa, bb, js_jian));
		System.out.println(yunsuan(aa, bb, js_cheng));
		System.out.println(yunsuan(aa, bb, js_chu));
		
	}
}
