package com.colobu.algorithm.sort;

import com.colobu.algorithm.util.SwapUtil;

public class QuickSort implements ISort {

	public static <T extends Comparable<T>> void quickSort(T[] source,int startIndex,int endIndex)
	{		
		if (source == null)
			return;
		if (endIndex-startIndex < 1)
			return;
		
		int pivotNewIndex = partition(source, startIndex, endIndex);
		
		quickSort(source,startIndex,pivotNewIndex -1);
		quickSort(source,pivotNewIndex +1,endIndex);
	}



	public static <T extends Comparable<T>> int partition(T[] source, int startIndex, int endIndex)
	{
		T pivot = source[startIndex];
		SwapUtil.swap(source, startIndex, endIndex);
		int pivotNewIndex = startIndex;
		for(int i=startIndex; i<endIndex; i++)
		{
			if (source[i].compareTo(pivot) <= 0)
			{
				SwapUtil.swap(source, pivotNewIndex, i);
				pivotNewIndex++;
			}
		}
		SwapUtil.swap(source, pivotNewIndex, endIndex);
		return pivotNewIndex;
	}
	
		
	
	public <T extends Comparable<T>> void sort(T[] source) {
		quickSort(source,0,source.length-1);
	}

}
