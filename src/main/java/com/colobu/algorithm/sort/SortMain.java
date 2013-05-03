package com.colobu.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class SortMain {

	public static <T extends Comparable<T>> void testWithJDK(T[] source) {
		System.out.println("test " + source.length +  " elements with Arrays.sort");
		long t = System.currentTimeMillis();
		Arrays.sort(source);
		t = System.currentTimeMillis() -t;
		//verify
		boolean result = true;
		for (int i = 0; i < source.length-1; i++) {
			if (source[i+1].compareTo(source[i])<0)
				result = false;
		}
		
		System.out.println("cost:" + t/1000.0 + " seconds, result:" + result);
	}
	
	public static <T extends Comparable<T>> void test(ISort sort,T[] source) {
		System.out.println("test " + source.length +  " elements with " + sort.getClass());
		long t = System.currentTimeMillis();
		sort.sort(source);
		t = System.currentTimeMillis() -t;
		//verify
		boolean result = true;
		for (int i = 0; i < source.length-1; i++) {
			if (source[i+1].compareTo(source[i])<0)
				result = false;
		}
		
		System.out.println("cost:" + t/1000.0 + " seconds, result:" + result);
	}
	
	public static Integer[] prepareData(int count) {
		Random rand = new Random();
		
		Integer[] source = new Integer[count];
		for (int i = 0; i < count; i++) {
			source[i] = rand.nextInt();
		}
		
		return source;
	}
	
	public static void main(String[] args) {
		int MAX = 50000;
		Integer[] source = prepareData(MAX);
		
		testWithJDK(source.clone());
		test(new QuickSort(),source.clone());
		test(new BidirectionalScannQuickSort(),source.clone());
		test(new CombineQuickSortInsertionSort(),source.clone());
		test(new ShellSort(),source.clone());
		test(new BubbleSort(),source.clone());
		test(new CocktailSort(),source.clone());
		test(new SelectionSort(),source.clone());
		test(new InsertionSort(),source.clone());
		test(new MergeSort(),source.clone());
		//test(new StoogeSort(),source.clone());
	}

	
}
