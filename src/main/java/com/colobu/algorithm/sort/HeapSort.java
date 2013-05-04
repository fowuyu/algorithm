package com.colobu.algorithm.sort;

import com.colobu.algorithm.util.SwapUtil;

public class HeapSort implements ISort
{
	public static <T extends Comparable<T>> void heapSort(T[] source, int startIndex, int endIndex)
	{
		//build a max heap
		heapify(source, startIndex,endIndex);
		
		while (endIndex > startIndex)
		{
			SwapUtil.swap(source, startIndex, endIndex);
			//rebuild a max heap
			siftDown(source, startIndex, endIndex - 1,startIndex);
			// decrement the size of the heap so that the previous
			// max value will stay in its proper place
			endIndex--;
		}
	}

	/**
	 * build elements of source between startIndex and endIndex as a max heap.
	 * 
	 * @param source
	 * @param startIndex
	 * @param endIndex
	 */
	public static <T extends Comparable<T>> void heapify(T[] source, int startIndex, int endIndex){
		int count = endIndex - startIndex + 1;
		//from the last non-leaf node to sift down
		int start = startIndex + (count - 2) / 2; //binary heap
	 
		//until reaching root
		while(start >= startIndex){ 
			siftDown(source, start, endIndex,startIndex);
			start--;
		}
	}
	 
	public static <T extends Comparable<T>> void siftDown(T[] source, int start, int end,int startIndex){
		int root = start;
	    int childIndex = startIndex + (root - startIndex) * 2 + 1;  //root*2+1 points to the left child
	    
		while(childIndex <= end){      //While the root has at least one child
			//if the child has a sibling(right child) and the child's value is less than its sibling's...
			if(childIndex + 1 <= end && source[childIndex].compareTo(source[childIndex + 1]) < 0)
				childIndex = childIndex + 1;           //... then point to the right child instead
			if(source[root].compareTo(source[childIndex]) < 0)
			{ 
				SwapUtil.swap(source, root, childIndex);
				root = childIndex; //re-calculate root and its left child index
				childIndex = startIndex + (root - startIndex) * 2 + 1; 
			}else
				return;
		}
	}
	
	public <T extends Comparable<T>> void sort(T[] source)
	{
		heapSort(source,0,source.length -1);
	}

}
