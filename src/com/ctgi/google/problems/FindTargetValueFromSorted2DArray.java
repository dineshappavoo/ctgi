/**
 * 
 */
package com.ctgi.google.problems;

/**
 * @author Dany
 *
 *
 *13.find target value from a 2d array in which each row and column are sorted.
 */
public class FindTargetValueFromSorted2DArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = {{1, 3, 5},{6,8,9},{10, 13, 15}};
		new FindTargetValueFromSorted2DArray().findValueFromSortedArray(arr, 8);
		
	}

	public void findValueFromSortedArray(int[][] arr, int val)
	{
		int rowLength = arr.length;
		int colLength = arr[0].length;
		int j=colLength-1, i=0;
		while(i<rowLength  && j<colLength)
		{
			if(val<arr[i][j])
			{
				j--;
			}else if(arr[i][j] == val)
			{
				System.out.println("Index "+i+" , "+j); 
				break;
			}
			else
			{
				i++;
			}

		}
	}

}
