package com.colobu.algorithm.sort;

import com.colobu.util.SwapUtil;

public class CombineQuickSortInsertionSort implements ISort {

	private static final int INSERTIONSORT_THRESHOLD = 7;
	
	public static <T extends Comparable<? super T>> void quickSort(T[] source,int startIndex,int endIndex)
	{		
		if (source == null)
			return;
		if (endIndex-startIndex < INSERTIONSORT_THRESHOLD)
		{
			InsertionSort.insertionSort(source,startIndex,endIndex);
			return;
		}
		
		T pivot = source[startIndex];
		SwapUtil.swap(source, startIndex, endIndex);
		int storeIndex = startIndex;
		for(int i=startIndex; i<endIndex; i++)
		{
			if (source[i].compareTo(pivot) <= 0)
			{
				SwapUtil.swap(source, storeIndex, i);
				storeIndex++;
			}
		}
		SwapUtil.swap(source, storeIndex, endIndex);
		
		
		quickSort(source,startIndex,storeIndex -1);
		quickSort(source,storeIndex +1,endIndex);
	}
	
		
	
	public <T extends Comparable<? super T>> void sort(T[] source) {
		quickSort(source,0,source.length-1);
	}

}
