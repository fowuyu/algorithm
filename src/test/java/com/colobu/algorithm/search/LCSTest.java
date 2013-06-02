package com.colobu.algorithm.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.colobu.util.Tuple;

public class LCSTest
{

	public static void main(String[] args)
	{
		Random rand = new Random();
		int[] a = new int[20];
		int[] b = new int[30];
		
		for (int i=0; i < a.length; i++)
		{
			a[i]= rand.nextInt(20);	
		}
		for (int i=0; i < b.length; i++)
		{
			b[i]= rand.nextInt(20);
		}
		
		List<Integer> result = new ArrayList<Integer>(b.length);
		int[][] c = LCS.lcs(a, b);
		LCS.backtrack(result, c, a, b, a.length -1, b.length -1);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(result.toString());
	}

}
