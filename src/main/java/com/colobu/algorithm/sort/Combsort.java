package com.colobu.algorithm.sort;

import com.colobu.util.SwapUtil;

public class Combsort implements ISort
{
	private static final float shrink = 1.3f;
	
	public  static <T extends Comparable<? super T>> void combsort(T[] source,int startIndex,int endIndex)
	{
	    int i, gap = endIndex - startIndex + 1;
	    boolean swapped = false;
	 
	    while ((gap > 1) || swapped) {
	        if (gap > 1) {
	            gap = (int)((float)gap / shrink);
	        }
	 
	        swapped = false;
	 
	        for (i = startIndex; gap + i <= endIndex; ++i) {
	            if (source[i].compareTo(source[i + gap]) > 0) {
	                SwapUtil.swap(source, i, i + gap);
	                swapped = true;
	            }
	        }
	    }
	}
	
	
	public <T extends Comparable<? super T>> void sort(T[] source)
	{
		combsort(source,0,source.length - 1);
	}

}
