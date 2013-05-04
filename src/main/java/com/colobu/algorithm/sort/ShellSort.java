package com.colobu.algorithm.sort;

public class ShellSort implements ISort
{
	//gap sequence:a(n) = floor(fibonacci(n+1)^(1+sqrt(5)))
	//the Fibonacci numbers (leaving out one of the starting 1's) to the power of twice the golden ratio
	private static final int[] gaps = { 1,5,13,43,113,297,815,1989,4711,11969,27901,84801,
        213331,543749,1355339,3501671,8810089,21521774,
        58548857,157840433,410151271,1131376761,2147483647 };
	
	public  static <T extends Comparable<T>> void shellSort(T[] source,int startIndex,int endIndex)
	{
		int k;
		int n = endIndex - startIndex + 1;
		for (k = 0; gaps[k] < n; k++) ;
		
		while(--k >= 0)
		{
			int gap = gaps[k];
			for (int i = startIndex + gap; i < endIndex + 1; i++)
			{
				T temp = source[i];
				int j = i;
                while (j >= gap && source[j - gap].compareTo(temp) > 0)
                {
                	source[j] = source[j - gap];
                    j = j - gap;
                }
                source[j] = temp;
			}
		}
		
	}
	public <T extends Comparable<T>> void sort(T[] source)
	{
		shellSort(source,0,source.length -1);
	}

}
