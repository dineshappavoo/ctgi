/**
 * 
 */
package com.ctgi.google.problems;

/**
 * @author Dany
 *
 */
public class LCM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LCM lcm = new LCM();
		long lcmVal = lcm.lcm(10, 12);
		System.out.println("Two numbers : "+lcmVal);
		long[] val = new long[5];
		long num = 50;
		for(int i=0;i<val.length;i++)
		{
			val[i] = num;
			num += 5;
		}
		long lcmVal1 = lcm.lcm(val);
		System.out.println("List of Numbers "+lcmVal1);
	}

	public static long lcm(long a, long b)
	{
		return a * (b / GCD.gcd(a, b));
	}

	public static long lcm(long[] input)
	{
		long result = input[0];
		for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
		return result;
	}

}
