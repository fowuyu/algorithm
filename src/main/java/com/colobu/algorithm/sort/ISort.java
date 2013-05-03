package com.colobu.algorithm.sort;

public interface ISort {
	<T extends Comparable<T>> void sort(T[] source);
}
