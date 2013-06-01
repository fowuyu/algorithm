package com.colobu.util;

public class Tuple
{
	private Object[] objects;
	
	public Tuple(Object... objects)
	{
		this.objects = objects;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getIndex(int i)
	{
		return (T)objects[i];
	}
	
	public int length()
	{
		return objects.length;
	}
}
