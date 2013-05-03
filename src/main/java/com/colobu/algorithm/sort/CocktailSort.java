package com.colobu.algorithm.sort;

import com.colobu.algorithm.util.SwapUtil;

public class CocktailSort implements ISort
{
	public  static <T extends Comparable<T>> void cocktailSort(T[] source,int startIndex,int endIndex)
	{
		boolean swapped = true;
		while (swapped)
		{
			swapped = false;
			
			for (int i = startIndex; i < endIndex; i++)
			{
				if (source[i+1].compareTo(source[i]) < 0)
				{
					SwapUtil.swap(source, i, i+1);
					swapped = true;
				}
			}
			endIndex--;
			
			for (int i = endIndex; i >startIndex; i--)
			{
				if (source[i].compareTo(source[i-1]) < 0)
				{
					SwapUtil.swap(source, i, i-1);
					swapped = true;
				}
			}
			
			startIndex++;
		}
	}
	
	public <T extends Comparable<T>> void sort(T[] source)
	{
		cocktailSort(source,0,source.length-1);
	}

}
