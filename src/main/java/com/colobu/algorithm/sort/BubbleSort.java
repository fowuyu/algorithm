package com.colobu.algorithm.sort;

import com.colobu.algorithm.util.SwapUtil;

public class BubbleSort implements ISort
{
	public  static <T extends Comparable<T>> void insertionSort(T[] source,int startIndex,int endIndex)
	{
		boolean swapped = true;
		for (int i = startIndex; i < endIndex && swapped; endIndex--)
		{
			swapped = false;
			for (int j = i; j < endIndex; j++)
			{
				if (source[j+1].compareTo(source[j]) < 0)
				{
					SwapUtil.swap(source, j, j+1);
					swapped = true;
				}
			}
		}
	}
	
	public <T extends Comparable<T>> void sort(T[] source)
	{
		insertionSort(source,0,source.length-1);
	}

}
