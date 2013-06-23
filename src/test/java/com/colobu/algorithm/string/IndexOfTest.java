package com.colobu.algorithm.string;

public class IndexOfTest
{
	public static void testStringIndexOf(String a,String b)
	{
		long t = System.currentTimeMillis();
		int index = a.indexOf(b);
		t = System.currentTimeMillis() - t;
		System.out.println("JdkStringIndexOf for a and b:" + index + ", time:" + t);
	}
	
	public static void testSimpleIndexOf(String a,String b)
	{
		long t = System.currentTimeMillis();
		int index = SimpleIndexOf.indexOf(a, b);
		t = System.currentTimeMillis() - t;
		System.out.println("SimpleIndexOf for a and b:" + index + ", time:" + t);
	}
	
	public static void testKMPIndexOf(String a,String b)
	{
		long t = System.currentTimeMillis();
		int index = KMP.indexOf(a, b);
		t = System.currentTimeMillis() - t;
		System.out.println("KMP for a and b:" + index + ", time:" + t);
	}
	
	public static void main(String[] args)
	{
		String a = "here is a sample example";
		String b = "example";
		
		testStringIndexOf(a,b);
		testSimpleIndexOf(a,b);
		testKMPIndexOf(a,b);
	}

}
