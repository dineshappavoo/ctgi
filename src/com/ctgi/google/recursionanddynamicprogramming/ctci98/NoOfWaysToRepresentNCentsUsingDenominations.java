/**
 * 
 */
package com.ctgi.google.recursionanddynamicprogramming.ctci98;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Dinesh Appavoo
 *
 * RECURSIVE ALGORITHM:
 * - Get the possible denominations in a list and the value n(Cents)
 * - Each function call will be having sub recursive calls of size of the denomination list 
 * - On each list item recursive call reduce the list value from n.
 * - Base case:
 * 		- if(n==0) then return 1 ;//One possible way
 *		- if(n<0) then return 0;
 *	- Recursive	case
 * 		- Add the return value together on each call and return the same finally
 * Example:
 *  n=10; denomination={2,3,4};  
 *
 * PROPERTIES OF THE PROBLEM:
 * - There could be redundant n values for some recursive calls - This implies that the problem has 'OVERLAPPING SUBPROBLEMS'
 * - The return value of one recursive call can be used in another recursive call - This implies that problem has 'OPTIMAL SUBSTRUCTURE'
 * 
 * - Because of the above two properties the problem can be solved using dynamic programming
 * - Simply a memoization table can be maintained to catch sub recursive call return values and the same can be used for other recursive calls without redundant calculations			 
 *			 
 */
public class NoOfWaysToRepresentNCentsUsingDenominations {

	/**
	 * @param args
	 */
	public static HashMap<Integer, Integer> memoTable = new HashMap<Integer, Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> denominations = new ArrayList<Integer>();
		denominations.add(2);
		denominations.add(3);
		denominations.add(4);
		
		int waysinDP = new NoOfWaysToRepresentNCentsUsingDenominations().findNoOfPossibleWaysinDP(100, denominations);
		System.out.println("DP :"+waysinDP);
		int ways = new NoOfWaysToRepresentNCentsUsingDenominations().findNoOfPossibleWays(100, denominations);
		System.out.println("Normal Recursion: "+ways);


	}
	
	//Recursive Function
	public int findNoOfPossibleWays(int n, ArrayList<Integer> denominations)
	{
		if(n==0)
			return 1;
		if(n<0)
			return 0;
		int ways=0;
		for(int denom : denominations)
		{
			ways+=findNoOfPossibleWays(n-denom, denominations);
		}
		return ways;
	}
	
	//Dynamic Programming
	public int findNoOfPossibleWaysinDP(int n, ArrayList<Integer> denominations)
	{
		if(n==0)
			return 1;
		if(n<0)
			return 0;
		if(memoTable.containsKey(n))
			return memoTable.get(n);
		int ways=0;
		for(int denom : denominations)
		{
			ways  += findNoOfPossibleWaysinDP(n-denom, denominations);
		}
		memoTable.put(n, ways);
		return memoTable.get(n);
	}

}
