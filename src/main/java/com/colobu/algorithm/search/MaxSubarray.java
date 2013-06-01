package com.colobu.algorithm.search;

import com.colobu.util.Tuple;

//http://en.wikipedia.org/wiki/Kadane%27s_algorithm
public class MaxSubarray
{
	public static Tuple maxSubarray(int[] arr)
	{
		long maxEndingHere = Long.MIN_VALUE, maxSumSofar = Long.MIN_VALUE;
		int start = 0;
		int currentStart = 0;
		int end = 0;
		
		for (int i = 0; i< arr.length; i++)
		{
			if (maxEndingHere < 0)
			{
				maxEndingHere = arr[i];
				currentStart = i;
			}
			else
				maxEndingHere = maxEndingHere + arr[i];
			
			if (maxEndingHere > maxSumSofar)
			{
				maxSumSofar = maxEndingHere;
				start = currentStart;
				end = i;
			}
		}

		return new Tuple(maxSumSofar,start,end);
	}

}
