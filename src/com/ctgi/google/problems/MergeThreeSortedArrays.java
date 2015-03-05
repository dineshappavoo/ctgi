/**
 * 
 */
package com.ctgi.google.problems;

/**
 * @author Dany
 *
 */
public class MergeThreeSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] mergeThreeArrays(int[] arr1, int[] arr2, int[] arr3)
	{
		int length1 = arr1.length;
		int length2 = arr2.length;
		int length3 = arr3.length;
		
		int secondMax = length1>length2?length1:length2;
		int maxSize = length3>secondMax?length3:secondMax;
		
		int[] mergedArray = new int[length1+length2+length3];
		int i=0, j=0, k=0;
		int val1, val2, val3;
		for(int current=0;current<maxSize;current++)
		{
			if(i<length1 && j< length2 && k<length3)
			{
				
			}
		}
		
	}

}
