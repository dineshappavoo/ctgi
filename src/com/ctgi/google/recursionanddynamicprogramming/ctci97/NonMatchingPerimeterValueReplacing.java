/**
 * 
 */
package com.ctgi.google.recursionanddynamicprogramming.ctci97;

/**
 * @author Dany
 *
 *
 * ALGORITHM:
 * - Get the x and y position of the value
 * - There are four possible ways to move(left right, top, bottom)
 * - Define oldValue=value(x,y) ;newValue=value(x+1,y)..[top,left,right,left]
 * - Keep a 0 initialized visited array to keep track of visited pointer
 * - if(oldValue == newValue ) then {if visited==1 then return else visited=1} else {
 *   if(visited==1) then return else {newValue=replaceValue ;visited=1;return}}
 *   Call all possible 4 ways on each function call
 *   
 *   
 *    *  * Example 
 * 
 * 		(1, 1)

 * 		4445
		3574
		4558
		4644
		
 * Hints:
 * - Don't have to add anything in the return type . Just a replacement. So function type can be void.
 * 
 */
public class NonMatchingPerimeterValueReplacing {

	/**
	 * @param args
	 */
	public static int[][] visitedValues;
	public static void main(String[] args) {

		int[][] arr = {{4,4,4,5},{3,5,7,4},{4,5,5,8},{4,6,4,4}};
		visitedValues = new int[arr.length][arr[0].length];
		
		new NonMatchingPerimeterValueReplacing().replaceNonMatchingPerimeterValue(arr, 1, 1, 5, 5, 9);
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				System.out.print(" "+arr[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public void replaceNonMatchingPerimeterValue(int[][] arr, int x, int y, int oldValue, int newValue, int replaceValue)
	{
		if(x<0||x>arr.length||y<0||y>arr[0].length)
			return;
		if(oldValue == newValue)
		{
			if(visitedValues[x][y]==1)
				return;
			else
			{
				visitedValues[x][y]=1;
			}
			
		}else
		{
			if(visitedValues[x][y]==1)
				return;
			else
			{
				visitedValues[x][y]=1;
				arr[x][y]=replaceValue;
				return;
			}
		}
		
		replaceNonMatchingPerimeterValue(arr, x+1, y, oldValue, arr[x+1][y], replaceValue);//Bottom
		replaceNonMatchingPerimeterValue(arr, x, y+1, oldValue, arr[x][y+1], replaceValue);//Right
		replaceNonMatchingPerimeterValue(arr, x-1, y, oldValue, arr[x-1][y], replaceValue);//Top
		replaceNonMatchingPerimeterValue(arr, x, y-1, oldValue, arr[x][y-1], replaceValue);//Left

	}

}
