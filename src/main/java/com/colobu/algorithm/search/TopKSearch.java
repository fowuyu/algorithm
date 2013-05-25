package com.colobu.algorithm.search;

import java.lang.reflect.Array;

import com.colobu.datastructure.MaxHeap;
import com.colobu.datastructure.MinHeap;

public class TopKSearch
{
	public static <T extends Comparable<? super T>> T[] searchTopKSmallest(T[] source, int k) {
		assert(source != null && source.length > k);
		@SuppressWarnings("unchecked")
		T[] result = (T[])Array.newInstance(source[0].getClass(), k);
		for (int i = 0; i < k; i++)
		{
			result[i] = source[i];
		}
		
		MaxHeap<T> heap = new MaxHeap<T>(result);
		int sourceLength = source.length;
		for (int i = k; i < sourceLength; i++)
		{
			if (heap.getRoot().compareTo(source[i]) > 0)
			{
				heap.setRoot(source[i]);
			}
		}
		
		return heap.getData();
	}
	
	public static <T extends Comparable<? super T>> T[] searchTopKBiggest(T[] source, int k) {
		assert(source != null && source.length > k);
		@SuppressWarnings("unchecked")
		T[] result = (T[])Array.newInstance(source[0].getClass(), k);
		for (int i = 0; i < k; i++)
		{
			result[i] = source[i];
		}
		
		MinHeap<T> heap = new MinHeap<T>(result);
		int sourceLength = source.length;
		for (int i = k; i < sourceLength; i++)
		{
			if (heap.getRoot().compareTo(source[i]) < 0)
			{
				heap.setRoot(source[i]);
			}
		}
		
		return heap.getData();
	}
}
