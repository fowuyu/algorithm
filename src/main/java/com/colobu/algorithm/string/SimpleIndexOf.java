package com.colobu.algorithm.string;

public class SimpleIndexOf
{
	public static int indexOf(String a, String b)
	{
		char[] aa = a.toCharArray();
		char[] bb = b.toCharArray();
		int count = aa.length - bb.length;
		
		for (int i = 0; i <= count; i++)
		{
			// check the first char
			if (aa[i] != bb[0])
				continue;

			int j = 1;
			for (j = 1; j < bb.length; j++)
			{
				if (aa[i + j] != bb[j])
					break;
			}

			if (j == bb.length)
				return i;
		}
		return -1;
	}
}
