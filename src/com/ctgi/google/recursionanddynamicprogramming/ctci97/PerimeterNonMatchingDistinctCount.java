/**
 * 
 */
package com.ctgi.google.recursionanddynamicprogramming.ctci97;

import java.util.HashMap;

/**
 * @author Dany
 *
 *ALGORITHM:
 * - Get the x and y position of the color
 * - There are four possible ways to move(left right, top, bottom)
 * - Define oldColor=color(x,y) ;newColor=color(x+1,y)..[top,left,right,left]
 * - if(oldColor==newColor) then do nothing else { 1. Check if the hashmap contains the non matching element if so increment the count
 * 		2. if hashmap does not contain this element then add with the count as one 3. Finally return}
 * - call all possible four ways in case the oldValue==newValue
 * - 
 * 
 *  * Example 
 * 
 * 		(1, 1)

 * 		4445
		3574
		4558
		4644
 * HINTS:
 *  - Return type of the function can be void because it does not have to return anything but update the hashmap on matching condition
 *  - Keep the old value as the first value (Not mandatory but helpful for other functionalities)
 *  - The function will run in infinite loop because it will end up in the same comparison for the oldValue newValue comparison  - To solve
 *    this use a visited pointer (In this case a two dimensional array with visited pointer)
 *    
 *  - Here overlapping sub problems and optimal substructure consideration may not be required(DP)
 */
public class PerimeterNonMatchingDistinctCount {

	/**
	 * @param args
	 */
	public static int[][] visitedValues;
	public static void main(String[] args) {

		int[][] arr = {{4,4,4,5},{3,5,7,4},{4,5,5,8},{4,6,4,4}};
		visitedValues = new int[arr.length][arr[0].length];

		HashMap<Integer, Integer> perimeterMap= new HashMap<Integer, Integer>();
		new PerimeterNonMatchingDistinctCount().findNonMatchingPerimeterDistinctCount(arr, 1, 1, 5, 5, perimeterMap);


		for(int key : perimeterMap.keySet())
		{
			System.out.println("NonMatching Value : "+key+" Count  : "+perimeterMap.get(key));
		}

	}

	public void findNonMatchingPerimeterDistinctCount(int[][] arr, int x, int y, int oldValue, int newValue, HashMap<Integer, Integer> perimeterCountMap)
	{
		if(x<0 || x>arr.length || y<0 || y>arr[0].length)
			return;
		if(oldValue==newValue)
		{
			if(visitedValues[x][y]==1)
				return;
			else
				visitedValues[x][y]=1;
		}else
		{
			if(visitedValues[x][y]==1)
				return;
			else
			{
				if(perimeterCountMap.containsKey(newValue))
				{
					perimeterCountMap.put(newValue, (perimeterCountMap.get(newValue))+1);
				}else
				{
					perimeterCountMap.put(newValue, 1);
				}
				visitedValues[x][y]=1;

				return;
			}
		}

		findNonMatchingPerimeterDistinctCount(arr, x+1, y, oldValue, arr[x+1][y], perimeterCountMap); //Bottom
		findNonMatchingPerimeterDistinctCount(arr, x, y+1, oldValue, arr[x][y+1], perimeterCountMap); //Right
		findNonMatchingPerimeterDistinctCount(arr, x-1, y, oldValue, arr[x-1][y], perimeterCountMap); //Top
		findNonMatchingPerimeterDistinctCount(arr, x, y-1, oldValue, arr[x][y-1], perimeterCountMap); //Left

	}

}
