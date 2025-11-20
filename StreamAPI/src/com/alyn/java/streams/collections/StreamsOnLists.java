package com.alyn.java.streams.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsOnLists {
	
	String dataSource[] = {"mike","tyson", "alex", "tiger", "farhan", "mull"};
	Integer numberList[] = {2,4,6,8,99,10,22,30199,109,98};
	
	public boolean isNameExsits(String name){
		
		//letters = letters.toLowerCase();
		List<String> listDataSource = Arrays.asList(dataSource);
		return listDataSource.stream().anyMatch(names -> names.equals(name));
	}
	
	public List<Integer> numbersDividedByProvdedNum(int num) {
		
		List<Integer> numberDataSource = Arrays.asList(numberList);
		return numberDataSource.stream().filter(x -> x % num == 0).collect(Collectors.toList());
	}
	
	public List<String> convertLettersToUpperCase(String letter){
		
		List<String> names = Arrays.asList(dataSource);
		
		return null;
		
	}
}
