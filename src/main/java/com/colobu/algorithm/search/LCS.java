package com.colobu.algorithm.search;

import java.util.List;

///Longest common subsequence
//c[i][j] = 0  (i = 0 or j = 0)
//c[i][j] = c[i - 1][j - 1] + 1  (i ,j > 0 and x[i] == y[i])
//c[i][j] = max{c[i][j - 1],c[i - 1][j])  (i ,j > 0 and x[i] i= y[i])
public class LCS
{
	public static int[][] lcs(int[] a, int[] b)
	{
		int[][] c = new int[a.length][b.length];
		for (int i = 0; i < a.length; i++)
		{
			c[i][0] = 0;
		}
		for (int i = 0; i < b.length; i++)
		{
			c[0][i] = 0;
		}

		for (int i = 1; i < a.length; i++)
		{
			for (int j = 1; j < b.length; j++)
			{
				if (a[i] == b[j])
				{
					c[i][j] = c[i - 1][j - 1] + 1;
				}
				else if (c[i - 1][j] >= c[i][j - 1])
				{
					c[i][j] = c[i - 1][j];
				}
				else
				{
					c[i][j] = c[i][j - 1];
				}
			}
		}
		
		return c;
	}

	public static void backtrack(List<Integer> subseq,int[][] c,int[] a, int[] b, int i,int j)
	{
		if ( i == 0 || j ==0)
			return;
		else if (a[i] == b[j])
		{
			 backtrack(subseq,c, a, b, i-1, j-1);
			 subseq.add(a[i]);
		}
		else if (c[i][j-1] > c[i-1][j])
			backtrack(subseq,c, a, b, i, j - 1);
		else 
			backtrack(subseq,c, a, b, i-1, j);
	}
	
	
}
