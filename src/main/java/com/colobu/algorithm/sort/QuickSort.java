package com.colobu.algorithm.sort;

import com.colobu.algorithm.util.SwapUtil;

public class QuickSort implements ISort {

	public <T extends Comparable<T>> void quickSort(T[] source,int l,int u)
	{		
		if (source == null)
			return;
		if (u-l < 1)
			return;
		
		T pivot = source[l];
		SwapUtil.swap(source, l, u);
		int storeIndex = l;
		for(int i=l; i<u; i++)
		{
			if (source[i].compareTo(pivot) <= 0)
			{
				SwapUtil.swap(source, storeIndex, i);
				storeIndex++;
			}
		}
		SwapUtil.swap(source, storeIndex, u);
		
		
		quickSort(source,l,storeIndex -1);
		quickSort(source,storeIndex +1,u);
	}
	
		
	
	public <T extends Comparable<T>> void sort(T[] source) {
		quickSort(source,0,source.length-1);
	}

}
