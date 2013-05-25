package com.colobu.algorithm.search;

public class BinarySearch
{
	public static <T extends Comparable<? super T>> int search(T[] sortedSource, T target) {
		int low = 0;
		int high = sortedSource.length -1;
		
		while (low <= high) {
			int mid = (high +low) >>> 1;

			if (sortedSource[mid].compareTo(target) < 0) {
				low = mid + 1;
			}
			else if (sortedSource[mid].compareTo(target) > 0) 
				high = mid - 1;
			else //sortedSource[mid] == target
				return mid;
		}
		
		return -1;
	}
}
