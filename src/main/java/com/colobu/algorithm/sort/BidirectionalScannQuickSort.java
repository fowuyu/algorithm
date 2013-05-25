package com.colobu.algorithm.sort;

import com.colobu.util.SwapUtil;

public class BidirectionalScannQuickSort implements ISort {

	public static <T extends Comparable<? super T>> void quickSort(T[] source,int startIndex,int endIndex)
	{		
		if (source == null)
			return;
		if (endIndex-startIndex < 1)
			return;
		
		T pivot = source[startIndex];
		int i = startIndex + 1;
		int j = endIndex;
		
		while(i<=j)
		{
			while(i<=j && source[i].compareTo(pivot) <= 0)			
				i++;
			while(i<=j && source[j].compareTo(pivot) > 0)
				j--;
			
			if (i<j) 
			{
				SwapUtil.swap(source, i, j);
				i++;
				j--;
			}
		}
		
		SwapUtil.swap(source, startIndex, j);
		quickSort(source,startIndex,j-1);
		quickSort(source,j+1,endIndex);
		
	}
	
	public <T extends Comparable<? super T>> void sort(T[] source) {
		quickSort(source,0,source.length-1);
	}

}
