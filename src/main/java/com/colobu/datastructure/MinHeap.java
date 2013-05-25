package com.colobu.datastructure;

import com.colobu.util.SwapUtil;

public class MinHeap<T extends Comparable<? super T>>
{
	private T[] data;

	public MinHeap(T[] data)
	{
		this.data = data;
		heapify();
	}

	private void heapify()
	{
		//sift down from the last parent node to root
		for (int i = (data.length) / 2 - 1; i >= 0; i--)
		{
			siftDown(i);
		}
	}

	private void siftDown(int i)
	{
		int l = getLeftChildIndex(i);
		int r = getRightChildIndex(i);

		int smallest = i;

		if (l < data.length && data[l].compareTo(data[i]) < 0)
			smallest = l;

		if (r < data.length && data[r].compareTo(data[smallest]) < 0)
			smallest = r;

		if (i == smallest) //parent is already the biggest
			return;

		SwapUtil.swap(data, i, smallest);

		siftDown(smallest);
	}

	private int getRightChildIndex(int i)
	{
		return (i + 1) << 1;
	}

	private int getLeftChildIndex(int i)
	{
		return ((i + 1) << 1) - 1;
	}

	public T getRoot()
	{
		return data[0];
	}

	public void setRoot(T root)
	{
		data[0] = root;
		siftDown(0);
	}

	public T[] getData()
	{
		return data;
	}
}
