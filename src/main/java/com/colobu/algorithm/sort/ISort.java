package com.colobu.algorithm.sort;

public interface ISort {
	<T extends Comparable<? super T>> void sort(T[] source);
}
