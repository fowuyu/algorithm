package com.colobu.algorithm.sort;

public class InsertionSort implements ISort
{

	public  static <T extends Comparable<T>> void insertionSort(T[] source,int startIndex,int endIndex)
	{
		for (int i = startIndex; i <= endIndex; i++)
		{
			T temp = source[i];
			int j = i;
			while (j>0 && temp.compareTo(source[j-1])<0)
			{
				 source[j] =  source[j-1];
				 j--;
			}
			source[j] = temp;
		}
	}
	
	
	public <T extends Comparable<T>> void sort(T[] source)
	{
		insertionSort(source,0,source.length-1);
	}

}
