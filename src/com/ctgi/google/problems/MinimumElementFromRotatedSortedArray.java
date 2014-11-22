/**
 * 
 */
package com.ctgi.google.problems;

/**
 * @author Dany
 *
 */
public class MinimumElementFromRotatedSortedArray {

	/**
	 * @param args
	 * 
	 * DESCRIPTION : 
	 *  - A sorted array has been rotated so that the elements might appear in the order 3,4,5,6,7,1,2
	 *    How would you find the minimum element? You may assume that the array has all unique elements.
	 *    
	 * ALGORITHM: (We can use modified binary search)
	 * - Get the input array.
	 * - Find the mid element mid = (low+high)/2 
	 * - if(A[mid]>A[high]) then rotation point may be in the right side . So do recursive call on right
	 * - else if(A[mid]<A[high]) then rotation point may be on the left side. So do recursive call on 
	 *   left sub array. 
	 * - Here mid is not compared with low because mid calculation is floor value 
	 *   i.e (3+4)/2 = 3. So low and mid can be same at any point.
	 * - else return A[mid]
	 * - Error/Base Case : if(low>high) return -1;
	 *   
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,2, 3, 4 ,5};
		int res= new MinimumElementFromRotatedSortedArray().findMinFromRotatedArray(arr, 0, arr.length-1);
		System.out.println(res);
	}
	
	public int findMinFromRotatedArray(int[] arr, int low, int high)
	{
		if(low>high)
			return -1;
		int mid = (low+high)/2;
		if(arr[mid]>arr[high])
			return findMinFromRotatedArray(arr, mid+1, high);
		else if(arr[mid]<arr[high])
			return findMinFromRotatedArray(arr, low, mid);
		else
			return arr[mid];
	}

}
