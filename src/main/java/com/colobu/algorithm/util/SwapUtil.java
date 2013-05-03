package com.colobu.algorithm.util;

public class SwapUtil {
	public static <T> void swap(T[] source,int i,int j)
	{
		if (i == j)
			return;
		T temp = source[i];
		source[i] = source[j];
		source[j] = temp;
	}
}
