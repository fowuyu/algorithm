package com.colobu.algorithm.search;

import java.lang.reflect.Array;

import com.colobu.util.SwapUtil;

public class QuickSelectTopKSearch
{
	public static <T extends Comparable<? super T>> T[] searchTopKSmallest(T[] source, int k) {
		assert(source != null && source.length > k);
		@SuppressWarnings("unchecked")
		T[] result = (T[])Array.newInstance(source[0].getClass(), k);
		//qucikSelect(source,0,source.length - 1,k,false);
		qucikSelectWithoutRecursion(source,0,source.length - 1,k,false);
		System.arraycopy(source,0,result,0,k);
		return result;
	}
	
	public static <T extends Comparable<? super T>> T[] searchTopKBiggest(T[] source, int k) {
		assert(source != null && source.length > k);
		@SuppressWarnings("unchecked")
		T[] result = (T[])Array.newInstance(source[0].getClass(), k);
		//qucikSelect(source,0,source.length - 1,k,true);
		qucikSelectWithoutRecursion(source,0,source.length - 1,k,true);
		System.arraycopy(source,0,result,0,k);
		return result;
	}
	
	private static <T extends Comparable<? super T>> void qucikSelect(T[] source, int startIndex, int endIndex, int k,boolean queryBiggest)
	{
		if (startIndex == endIndex)
			return;
		
		int pivotIndex = partition(source, startIndex, endIndex,queryBiggest);
		int foundCount = pivotIndex - startIndex + 1;
		if (foundCount== k)
			return;
		else if (foundCount < k)
		{
			qucikSelect(source, pivotIndex + 1, endIndex, k - foundCount,queryBiggest);
		}
		else
		{
			qucikSelect(source, startIndex, pivotIndex - 1, k,queryBiggest);
		}
	}
	
	private static <T extends Comparable<? super T>> void qucikSelectWithoutRecursion(T[] source, int startIndex, int endIndex, int k,boolean queryBiggest)
	{
		while(true)
		{
			int pivotIndex = partition(source, startIndex, endIndex,queryBiggest);
			int foundCount = pivotIndex - startIndex + 1;
			if (foundCount== k)
				return;
			else if (foundCount < k)
			{
				startIndex =  pivotIndex + 1;
				k = k - foundCount;
			}
			else
			{
				endIndex = pivotIndex - 1;
			}
		}
	}
	
	private static <T extends Comparable<? super T>> int partition(T[] source, int startIndex, int endIndex,boolean queryBiggest)
	{
		T pivot = source[startIndex];
		SwapUtil.swap(source, startIndex, endIndex);
		int pivotNewIndex = startIndex;
		for(int i=startIndex; i<endIndex; i++)
		{
			if (queryBiggest)
			{
				if (source[i].compareTo(pivot) >= 0)
				{
					SwapUtil.swap(source, pivotNewIndex, i);
					pivotNewIndex++;
				}
			}
			else
			{
				if (source[i].compareTo(pivot) <= 0)
				{
					SwapUtil.swap(source, pivotNewIndex, i);
					pivotNewIndex++;
				}
			}
			
		}
		SwapUtil.swap(source, pivotNewIndex, endIndex);
		return pivotNewIndex;
	}
}
