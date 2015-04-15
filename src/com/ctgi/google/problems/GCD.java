/**
 * 
 */
package com.ctgi.google.problems;

/**
 * @author Dany
 *
 */
public class GCD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GCD gcd = new GCD();
		long gcdVal = gcd.gcd(10, 12);
		System.out.println("Two numbers : "+gcdVal);
		long[] val = new long[5];
		long num = 50;
		for(int i=0;i<val.length;i++)
		{
			val[i] = num;
			num += 5;
		}
		long gcdVal1 = gcd.gcd(val);
		System.out.println("List of Numbers "+gcdVal1);
	}
	
	public static long gcd(long a, long b)
	{
	    while (b > 0)
	    {
	        long temp = b;
	        b = a % b; // % is remainder
	        a = temp;
	    }
	    return a;
	}

	public static long gcd(long[] input)
	{
	    long result = input[0];
	    for(int i = 1; i < input.length; i++) result = gcd(result, input[i]);
	    return result;
	}

}
