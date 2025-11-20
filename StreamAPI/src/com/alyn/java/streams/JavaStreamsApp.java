package com.alyn.java.streams;

import java.util.List;

import com.alyn.java.streams.collections.StreamsOnLists;

public class JavaStreamsApp {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Stream API");
		
		StreamsOnLists listStream = new StreamsOnLists();
		
		boolean foundLatters = listStream.isNameExsits("tysons");
		System.out.println(foundLatters);
		
		List<Integer> dividedNumberList = listStream.numbersDividedByProvdedNum(6);
		dividedNumberList.forEach(x -> System.out.println(x));
	}
	
}
