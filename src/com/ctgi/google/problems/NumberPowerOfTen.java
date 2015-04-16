/**
 * 
 */
package com.ctgi.google.problems;

/**
 * Given an integer x how do you find x is a power of 10? 
 * 
 * 
 * @author Dany
 *
 */
public class NumberPowerOfTen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new NumberPowerOfTen().isPowerOfTen(30, 10));
	}
	
	public boolean isPowerOfTen(int x, int y)
	{
		while (x%y == 0)
			{x = x / y;
			
			}
		
		if(x==1)
		{
			return true;
		}else
		{
			return false;
		}
	}

}
