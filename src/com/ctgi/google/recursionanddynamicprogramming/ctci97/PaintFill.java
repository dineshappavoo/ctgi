/**
 * 
 */
package com.ctgi.google.recursionanddynamicprogramming.ctci97;

/**
 * @author Dany
 *
 *
 *Algorithm
 * - Get the x and y position of the color
 * - There are four possible ways to move(left right, top, bottom)
 * - oldColor=color(x,y) ;replaceColor=colorTobeReplacedWith; newColor=color(x+1,y)..[top,left,right,left]
 * - if(oldColor==newColor) then newColor=replaceColor else return
 * - 
 * 
 * Example 
 * 
 * 		(1, 1)
		
 * 		4445
		4544
		4554
		4444
 */
public class PaintFill {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = {{4,4,4,5},{4,5,4,4},{4,5,5,4},{4,4,4,4}};
		new PaintFill().paintFill(arr, 1, 1, 5, 5, 7);
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				System.out.print(" "+arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void paintFill(int[][] arr, int x, int y, int oldValue,int newValue, int replaceValue)
	{
		//Base Case
		if(x<0||x>arr.length || y<0 || y> arr[0].length)
			return;
		if(oldValue==newValue)
			arr[x][y]=replaceValue;
		else
			return;
		paintFill(arr, x+1, y, oldValue, arr[x+1][y], replaceValue); //Bottom
		paintFill(arr, x, y+1, oldValue, arr[x][y+1], replaceValue); //Right
		paintFill(arr, x-1, y, oldValue, arr[x-1][y], replaceValue); //Top
		paintFill(arr, x, y-1, oldValue, arr[x][y-1], replaceValue); //Left
	}
	

}
