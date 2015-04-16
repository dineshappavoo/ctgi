/**
 * 
 */
package com.ctgi.google.problems;

/**
 * @author Dany
 *
 *Question : Find the second smallest element from the array?
 */
public class SecondMinimumFromTheArray {

	/**
	 * Execution entry point.
	 */
	public static void main(String args[])
	{
		doTestsPass();
	}


	/**
	 * int secondSmallest(int[] x)
	 * Returns second smallest integer in array x. If x has fewer than 2 elements returns 0.
	 */
	public static int secondSmallest(int[] x)
	{

		if( x.length < 2 )
		{
			return( 0 );
		}

		int Smallest = Integer.MAX_VALUE; // Max 32 bit integer
		int SecSmallest = Integer.MAX_VALUE;
		int Elem;
		for( int i=0; i < x.length; i++ )
		{
			Elem = x[i];
			if( Elem < Smallest )
			{
				SecSmallest = Smallest;
				Smallest = Elem;
			}
			else if( Elem < SecSmallest )
			{
				SecSmallest = Elem;
			}
		}
		return( SecSmallest );
	}

	/**
	 * bool doTestsPass()
	 * Runs various tests. Returns true if tests pass. Otherwise,
	 * returns false.
	 */
	public static boolean doTestsPass()
	{
		// todo: implement more tests, please
		// feel free to make testing more elegant
		int[] a = {};
		int[] b = {0};
		int[] c = {0,1};
		int[] d = {-1,0,1,-2,2};
		int[] e = {1,1,2};
		int[] f = {Integer.MAX_VALUE};
		int[] g = {Integer.MIN_VALUE,0,Integer.MAX_VALUE};

		boolean result = true;
		result &= secondSmallest( a ) == 0;
		result &= secondSmallest( b ) == 0;
		result &= secondSmallest( c ) == 1;
		result &= secondSmallest( d ) == -1;
		result &= secondSmallest( e ) == 1;
		result &= secondSmallest( f ) == 0;
		result &= secondSmallest( g ) == 0;

		if(result)
		{
			System.out.println("All tests pass\n");
		}
		else
		{
			System.out.println("There are test failures\n");
		}
		return result;
	}


	public int returnSecondSmallest(int[] arr)
	{
		int length = arr.length;
		int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;

		if(length<2)
			return 0;
		else if(length==2)
		{
			if(arr[0]<arr[1])
			{
				secondSmallest = arr[1];

			}else
			{
				secondSmallest = arr[0];

			}
		}	
		smallest = arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]<smallest)
			{
				secondSmallest = smallest;
				smallest = arr[i];
			}else
			{

			}
		}
		return secondSmallest;
	}
}
