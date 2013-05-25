package com.colobu.algorithm.search;

import java.lang.reflect.Array;
import java.util.Arrays;

import com.colobu.util.SwapUtil;

public class GeneralSelectionTopKSearch
{
	public static <T extends Comparable<? super T>> T[] searchTopKSmallest(T[] source, int k) {
		assert(source != null && source.length > k);
		@SuppressWarnings("unchecked")
		T[] result = (T[])Array.newInstance(source[0].getClass(), k);
		for (int i = 0; i < k; i++)
		{
			int smallestIndex = i;
			T smallestValue = source[i];
			
			for (int j = i+1; j < source.length; j++)
			{
				if (source[j].compareTo(smallestValue) < 0)
				{
					smallestIndex = j;
					smallestValue = source[j];
				}
			}
			if (smallestIndex != i)
				SwapUtil.swap(source, i, smallestIndex);
		}
		
		System.arraycopy(source,0,result,0,k);
		return result;
	}
	
	public static <T extends Comparable<? super T>> T[] searchTopKBiggest(T[] source, int k) {
		assert(source != null && source.length > k);
		@SuppressWarnings("unchecked")
		T[] result = (T[])Array.newInstance(source[0].getClass(), k);
		for (int i = 0; i < k; i++)
		{
			int biggestIndex = i;
			T biggestValue = source[i];
			
			for (int j = i+1; j < source.length; j++)
			{
				if (source[j].compareTo(biggestValue) > 0)
				{
					biggestIndex = j;
					biggestValue = source[j];
				}
			}
			if (biggestIndex != i)
				SwapUtil.swap(source, i, biggestIndex);
		}
		
		System.arraycopy(source,0,result,0,k);
		return result;
	}
}
