package com.colobu.algorithm.sort;


/**
 * The simplest sort algorithm is not Bubble Sort..., it is not Insertion Sort..., it's <b>Gnome Sort</b>.
 * 
 * <p>The gnome sort may be optimized by introducing a variable to store the position before traversing back toward the beginning of the list. 
 * This would allow the "gnome" to teleport back to his previous position after moving a flower pot. 
 * With this optimization, the gnome sort would become a variant of the insertion sort. 
 * The animation in the introduction to this topic takes advantage of this optimization.
 * and before traversing back toward we save the swapped value to reduce swap count.
 * 
 * <p><a href="http://dickgrune.com/Programs/gnomesort.html">
 * http://dickgrune.com/Programs/gnomesort.html</a>.
 *
 * @author smallnest
 * @email smallnest@gmail.com
 */
public class EnhancedGnomeSort implements ISort
{
	public  static <T extends Comparable<T>> void enhancedGnomeSort(T[] source,int startIndex,int endIndex)
	{
		int i = startIndex;
		int lastIndex = -1;
		
		T temp = null;
		
		while (i <= endIndex)
		{
			if (i == startIndex || source[i - 1].compareTo(temp) <= 0)
			{
				if (lastIndex != -1)
				{
					source[i] = temp;
					i = lastIndex;
					lastIndex = -1;
				}
				i++;
				if (i <= endIndex)
					temp = source[i];
			}
			else
			{
				if (lastIndex == -1) 
				{
					lastIndex = i;
				}
				source[i] = source[i-1]; //don't set source[i-1] = temp to reduce swap count
				i--;
			}
		}
	}
	
	
	public <T extends Comparable<T>> void sort(T[] source)
	{
		enhancedGnomeSort(source,0,source.length - 1);
	}

}
