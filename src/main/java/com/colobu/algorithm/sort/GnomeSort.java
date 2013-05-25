package com.colobu.algorithm.sort;

import com.colobu.util.SwapUtil;

/**
 * The simplest sort algorithm is not Bubble Sort..., it is not Insertion Sort..., it's <b>Gnome Sort</b>.
 * 
 * 
 * <p><a href="http://dickgrune.com/Programs/gnomesort.html">
 * http://dickgrune.com/Programs/gnomesort.html</a>.
 *
 * @author smallnest
 * @email smallnest@gmail.com
 */
public class GnomeSort implements ISort
{
	public  static <T extends Comparable<? super T>> void gnomeSort(T[] source,int startIndex,int endIndex)
	{
		int i = startIndex;
		
		while (i <= endIndex)
		{
			if (i == startIndex || source[i - 1].compareTo(source[i]) <= 0)
				i++;
			else
			{
				SwapUtil.swap(source, i, i-1);
				i--;
			}
		}
	}
	
	
	public <T extends Comparable<? super T>> void sort(T[] source)
	{
		gnomeSort(source,0,source.length - 1);
	}

}
