package com.alyn.lambda.exprsion;

import java.util.function.Predicate;

public class LambdaExpressions {
	
	public static void main(String []args) {
		System.out.println("Hello");
	}
	
	public boolean predicateDemo(String chars){
		
		Predicate<String> str = c -> c.charAt(0)>=0 && c.charAt(0)<=9;
		
		return str.test(chars);
		
	}
	
	public void consumerDemo() {
		
	}
	
	public void supplierDemo() {
		
	}
	
	public void operatorDemo() {
		
	}
	
	public void functionDemo() {
		
	}
}
