/**
 * 
 */
package com.ctgi.google.problems;

import java.util.HashMap;

/**
 * @author Dany
 *
 */
public class WaysToClimbNStepStairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new WaysToClimbNStepStairs().findAndPrintTheWaysToClimbNStepStairs(5,0,new HashMap<Integer, Integer>(), 0);
	}
	
	public int findAndPrintTheWaysToClimbNStepStairs(int n, int level, HashMap<Integer, Integer> hMap, int lastClimbedValue)
	{
		if(n==0)
		{
			hMap.put(level,lastClimbedValue);
			printWays(hMap, level);
			return 1;
		}
		if(n<0)
			return 0;
		hMap.put(level,lastClimbedValue);
		int noOfWays= findAndPrintTheWaysToClimbNStepStairs(n-1, level+1,hMap, 1) + findAndPrintTheWaysToClimbNStepStairs(n-2, level+1, hMap,2);
		return noOfWays;
	}

	public void printWays(HashMap<Integer, Integer> hMap, int level)
	{
		int val=0, i=0;
		for(int key : hMap.keySet())
		{
			val = hMap.get(key);
			if(val!=0 && i<=level)
				System.out.print(val);
			i++;
		}
		System.out.println();

	}

}
