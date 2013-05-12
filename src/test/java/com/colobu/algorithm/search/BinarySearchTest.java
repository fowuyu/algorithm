package com.colobu.algorithm.search;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import com.colobu.algorithm.sort.QuickSort;

public class BinarySearchTest
{
	static Integer[] source;
	static Random rand = new Random();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		source = new Integer[500000];
		for (int i = 0; i < source.length; i++)
		{
			source[i] = rand.nextInt();
		}
		QuickSort.quickSort(source, 0, source.length -1);
	}

	@Test
	public void testSearch()
	{
		//randomly test 10 times
		int i = 10;
		while(i-->0) 
		{
			 Integer target = rand.nextInt();
			 int index = BinarySearch.search(source, target);
			 if (index == -1) 
			 {
				for (int j = 0; j < source.length; j++)
				{
					if (source[j].intValue() == target.intValue())
						fail("find the target");
				}
			 }
			 else
			 {
				 if (source[index].intValue() != target.intValue())
				 {
					 fail("wrong implementation");
				 }
			 }
		}
		
		Integer target = source[rand.nextInt(source.length)];
		int index = BinarySearch.search(source, target);
		if (index >= 0)
		{
			assertTrue(source[index].intValue() == target.intValue());
		}
		else
		{
			fail("wrong implementation");
		}
	}

}
