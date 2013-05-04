package com.colobu.algorithm.sort;

import java.lang.reflect.Array;

public class MergeSort implements ISort
{
	private static final int INSERTIONSORT_THRESHOLD = 7;
	 
	public  static <T extends Comparable<T>> void mergeSort(T[] source,int startIndex,int endIndex,T[] tempArray)
	{
		if (startIndex == endIndex)
			return;
		
		int length = endIndex - startIndex + 1;
		if (length < INSERTIONSORT_THRESHOLD) 
		{
			InsertionSort.insertionSort(source, startIndex, endIndex);
			return;
		}
		
		int mid = (startIndex + endIndex) /2;
		mergeSort(source,startIndex,mid,tempArray);
		mergeSort(source,mid+1,endIndex,tempArray);
		//now source[startIndex,mid] is sorted, and source[mid+1,endIndex] is also sorted.
		//This is an optimization that we needn't invoke merge
		if (source[mid].compareTo(source[mid + 1]) <= 0)
			return;
		
		merge(source, startIndex, mid + 1, endIndex,tempArray);
	}
	
	private static <T extends Comparable<T>>  void merge(T[] source, int startIndex, int startIndex2, int endIndex,T[] tempArray)
	{
		
		int i = startIndex;
		int j = startIndex2;
		int k = startIndex;
		while(i<startIndex2 && j <= endIndex) {
			if(source[i].compareTo(source[j]) <=0)
			{
				tempArray[k] = source[i];
				k++;
				i++;
			}
			else
			{
				tempArray[k] = source[j];
				k++;
				j++;
			}
		}
		
		while(i<startIndex2)
		{
			tempArray[k] = source[i];
			k++;
			i++;
		}
		
		while(j <= endIndex)
		{
			tempArray[k] = source[j];
			k++;
			j++;
		}
		
		System.arraycopy(tempArray, startIndex, source, startIndex, endIndex - startIndex + 1);
	}
	    
	@SuppressWarnings("unchecked")
	public <T extends Comparable<T>> void sort(T[] source)
	{
		T[] tempArray = (T[])Array.newInstance(source[0].getClass(),source.length);
		mergeSort(source,0,source.length -1,tempArray);
	}

}
