/**
 * 
 */
package com.ctgi.google.problems;

import java.util.ArrayList;

/**
 * @author Dany
 *
 *Definition: 1 is a Pure number; X is a Pure number if the square of the sum of digits of X is a Pure number.

	Example:
  		64 => (6+4)^2 = 100;
  		100 => (1+0+0)^2 = 1
  	Therefore, both 64 and 100 are Pure.

	Note that if you reach a single digit number that's NOT 1, you keep going: 7 => 7^2 = 49, etc.

	Returns true iff x is a Pure number. x is guaranteed to be a positive integer.
 */
public class PureNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PureNumber pNum = new PureNumber();
		boolean res = pNum.isPure(7);
		System.out.println("Is Pure ?"+res);
	}

	public boolean isPure(int xVal)
	{	
		long x = (int)xVal;
		long sum = 0;
		long squareVal = 0;
		ArrayList<Long> lastValList = new ArrayList<Long>();
		
		System.out.println("X Val "+x);
		while(squareVal!=1)
		{
			while(x>0)
			{
				sum += x%10;
				x = x/10;
			}
			squareVal = (int)sum * (int)sum;
			System.out.println("Square Val "+squareVal);
			if(squareVal == 1)
				return true;
			if(lastValList.contains(squareVal))
				return false;
			lastValList.add(squareVal);

			x = squareVal;
			sum = 0;
		}
		return false;

	}

}
