package com.alyn.method.ref.app;

public class MethodRefApp {
	
	public static void show() {
		System.out.println("Welcome to Method References");
	}
	
	public static void main(String[] args) {
		
		Runnable run = MethodRefApp::show;
		
		run.run();
	}
	
}
