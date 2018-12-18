package com.luchao.lambda;

public class LambdaTest2 {
	
	public static void main(String[] args) {
		//获取随机数
		Random grandom = () -> Math.random()*100;
		//返回个固定的数
		Random gg = () -> 12.3;
		
		System.out.println(getnum(grandom));
		System.out.println(getnum(gg));
		
	}

	interface Random{
		double getrandom();
	};
	
	private static double getnum(Random r) {
		return r.getrandom();
	}
}
