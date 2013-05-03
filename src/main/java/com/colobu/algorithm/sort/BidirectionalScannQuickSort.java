package com.colobu.algorithm.sort;

import com.colobu.algorithm.util.SwapUtil;

public class BidirectionalScannQuickSort implements ISort {

	public <T extends Comparable<T>> void quickSort(T[] source,int l,int u)
	{		
		if (source == null)
			return;
		if (u-l < 1)
			return;
		
		T pivot = source[l];
		int i = l + 1;
		int j = u;
		
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
		
		SwapUtil.swap(source, l, j);
		quickSort(source,l,j-1);
		quickSort(source,j+1,u);
		
	}
	
	public <T extends Comparable<T>> void sort(T[] source) {
		quickSort(source,0,source.length-1);
	}

}
