package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
	
	
	public static void main(String[] args){
	
		//Stream of values
		Stream<Integer> stream = Stream.of(1,2,3,4,5,6);
		stream.forEach(i -> System.out.print(i+" "));
		
		//Stream of array
		System.out.println();
		Integer[] array= {1,2,4,6,7,0};
		Stream<Integer> stream1 = Stream.of(array);
		stream1.forEach(i -> System.out.print(i+" "));
		
		//Stream from list
		System.out.println();
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
		list.stream().forEach(i -> System.out.print(i+" "));
		
		//Using stream generate
		//Using Supplier
		//Supplier<Date> supplier = () -> {return new Date();};
		//Stream<Date> stream2 = Stream.generate(supplier);
		//stream2.forEach(i -> System.out.println(i+" "));
		
		//Using string and char tokens
		System.out.println();
		IntStream stream3 = "a".chars();
		stream3.forEach(i -> System.out.print(i+" "));
		
		
		//Using Collector.toList()
		list.clear();
		System.out.println();
		for(int i=0;i<20;i++){
			list.add(i);
		}
		List<Integer> duplicateList =  list.stream().map(i->i).collect(Collectors.toList());
		duplicateList =  list.stream().filter(i -> i%2==0).map(i->i).collect(Collectors.toList());
		//Convert to array
		Integer[] array1 = list.stream().filter(i -> i%2==0).map(i->i).toArray(Integer[]::new);
		System.out.println(duplicateList);
		
		//Filter
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Shekhar");
		memberNames.add("Aman");
		memberNames.add("Rahul");
		memberNames.add("Shahrukh");
		memberNames.add("Salman");
		memberNames.add("Yana");
		memberNames.add("Lokesh");
		
		List<String>  result1 = memberNames.stream().filter(i -> !i.equals("Shekhar")).collect(Collectors.toList());
		System.out.println(result1);
		
		//Using map Functions
		List<String>  result2 = memberNames.stream().map(i-> i.toUpperCase()).collect(Collectors.toList());
		System.out.println(result2);
		
		//Using sorted
		List<String>  result3 = memberNames.stream().sorted().collect(Collectors.toList());
		System.out.println(result3);
		
		memberNames.forEach(System.out::print);
		
		//AnyMatch and AllMatch 
		boolean result = memberNames.stream().anyMatch(i -> i.startsWith("A"));
		System.out.println();
		System.out.println(result);
		
		long number = memberNames.stream().filter(i -> i.startsWith("A")).count();
		System.out.println(number);
		
		Optional<String> present =  memberNames.stream().reduce((word1,word2) -> word1.length() > word2.length() ? word1:word2);
		present.ifPresent(System.out::println);
	}
}
