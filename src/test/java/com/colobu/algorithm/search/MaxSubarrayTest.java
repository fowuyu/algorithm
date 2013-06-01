package com.colobu.algorithm.search;

import java.util.Arrays;
import java.util.Random;

import com.colobu.util.Tuple;

public class MaxSubarrayTest
{

	public static void main(String[] args)
	{
		Random rand = new Random();
		int[] arr = new int[20];
		for (int i=0; i < arr.length; i++)
		{
			int value = rand.nextInt(10);
			if (value % 3 == 0)
				value = -value;
			
			arr[i] = value;		
		}
		
		Tuple result = MaxSubarray.maxSubarray(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("max sum:" + result.getIndex(0) + ",startIndex:" + result.getIndex(1) + ",endIndex:" +result.getIndex(2));
	}

}
