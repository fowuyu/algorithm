package com.colobu.algorithm.sort;

import com.colobu.util.SwapUtil;

public class SelectionSort implements ISort
{
	public  static <T extends Comparable<? super T>> void selectionSort(T[] source,int startIndex,int endIndex)
	{
		for (int i = startIndex; i < endIndex; i++)
		{
			//find the minimum value in [i,endIndex]
			int minIndex = i;
			for (int j = i + 1; j <= endIndex; j++)
			{
				if (source[j].compareTo(source[minIndex]) < 0)
					minIndex = j;
			}
			SwapUtil.swap(source, i, minIndex);
		}
	}
	
	public <T extends Comparable<? super T>> void sort(T[] source)
	{
		selectionSort(source,0,source.length-1);
	}

}
