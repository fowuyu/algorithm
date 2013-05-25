package com.colobu.algorithm.search;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import com.colobu.algorithm.sort.ISort;
import com.colobu.algorithm.sort.QuickSort;


public class TopKSearchMain
{
	public static Integer[] prepareData(int count) {
		Random rand = new Random();
		
		Integer[] source = new Integer[count];
		for (int i = 0; i < count; i++) {
			source[i] = rand.nextInt(Integer.MAX_VALUE);
		}
		
		return source;
	}
	
	public static <T extends Comparable<? super T>> T[] testWithHeap(T[] source,int k) {
		System.out.println("search the biggest " + k +  " in " + source.length + " elements");
		long t = System.currentTimeMillis();
		T[] topK = TopKSearch.searchTopKBiggest(source, k);
		t = System.currentTimeMillis() -t;
		
		QuickSort.quickSort(topK, 0, k -1);
		System.out.println("cost:" + t/1000.0 + " seconds, result:" + Arrays.toString(topK));
		return topK;
	}
	
	public static <T extends Comparable<? super T>> T[] testWithQuicksort(T[] source,int k) {
		System.out.println("search the biggest " + k +  " in " + source.length + " elements by quicksort");
		long t = System.currentTimeMillis();
		QuickSort.quickSort(source, 0, source.length -1);
		t = System.currentTimeMillis() -t;
		
		T[] topK = (T[])Array.newInstance(source[0].getClass(), k);
		int index = source.length - k;
		for (int i = 0; i < k; i++)
		{
			topK[i] = source[index + i];
			
		}
		
		System.out.println("cost:" + t/1000.0 + " seconds, result:" +  Arrays.toString(topK));
		return topK;
	}
	
	public static void main(String[] args)
	{
		int k = 20;
		int MAX = 50000;
		Integer[] source = prepareData(MAX);
		testWithHeap(source.clone(),k);
		testWithQuicksort(source.clone(),k);
	}

}
