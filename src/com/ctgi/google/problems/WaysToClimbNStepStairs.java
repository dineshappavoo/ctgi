/**
 * 
 */
package com.ctgi.google.problems;

import java.util.HashMap;

/**
 * @author Dany
 *
 *Q : Implement stairs(N) that (collect the solutions in a list) prints all the ways to climb up a N-step-stairs where one can either take a single step or double step. 
	We'll use 1 to represent a single step, and 2 to represent a double step. 
	stairs(3) 
	111 
	12 
	21
	
	ALGORITHM : WAYS_TO_CLIMB(int n, level, HashMap, lastClimbedValue)
	1.if n==0
		then PRINT_WAYS(HashMap, level) and return 1;
	2.if n<0 then retutn 0;
	3.HashMap.put(level,lastClimbedValue);
	4.return WAYS_TO_CLIMB(n-1, level+1,HashMap, 1) + WAYS_TO_CLIMB(n-2, level+1, HashMap,2);
	
	ALGORITHM:PRINT_WAYS(HashMap, level)
	1.int i=0;
		for each int in HashMap 
			if val!=0 and i<=level
				print val
			i++
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
