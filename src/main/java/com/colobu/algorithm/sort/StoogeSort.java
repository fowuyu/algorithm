package com.colobu.algorithm.sort;

import com.colobu.util.SwapUtil;

public class StoogeSort implements ISort
{
	public  static <T extends Comparable<? super T>> void stoogeSort(T[] source,int startIndex,int endIndex)
	{
		if (source[endIndex].compareTo(source[startIndex]) < 0)
			SwapUtil.swap(source, startIndex, endIndex);
		
		if ((endIndex - startIndex + 1) >= 3)
		{
			int t = (endIndex - startIndex + 1)/3;
			stoogeSort(source,startIndex,endIndex - t);
			stoogeSort(source,startIndex + t,endIndex);
			stoogeSort(source,startIndex,endIndex - t);
		}
	}
	
	public <T extends Comparable<? super T>> void sort(T[] source)
	{
		stoogeSort(source,0,source.length - 1);
	}

}
