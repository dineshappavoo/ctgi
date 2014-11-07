package com.ctgi.google.problems;


/**
 * @author Dany
 *
 *
 *Find the maximum sum sub array in a array which positive and negative integers.
 *
 *	intArr = {-8,7,9,-5,6,-2,0 }
 *	Output:
 *	Max sum         : 17
	Max start index : 1
	Max end index   : 4
 *
 */

public class KadaneSubArray {

	public static void main(String[] args) {
		//int[] intArr={0, -1, -1, 5, -1, 8, 2, 0, 0, 0 };
		int[] intArr1 = {3, -1, -1, -1, -1, -1, 2, 0, 0, 0 };
		int[] intArr = {-8,7,9,-5,6,-2,0 };

		//int[] intArr={-6,-2,-3,-4,-1,-5,-5};
		findMaxSubArray(intArr);
	}

	public static void findMaxSubArray(int[] inputArray){

		int maxStartIndex=0;
		int maxEndIndex=0;
		int maxSum = Integer.MIN_VALUE; 

		int cumulativeSum= 0;
		int maxStartIndexUntilNow=0;

		for (int currentIndex = 0; currentIndex < inputArray.length; currentIndex++) {

			int eachArrayItem = inputArray[currentIndex];

			/*if (cumulativeSum<0){
            	maxStartIndexUntilNow=currentIndex+1;
            	cumulativeSum=0;
            	}*/

			cumulativeSum+=eachArrayItem;

			if(cumulativeSum>maxSum){
				maxSum = cumulativeSum;
				maxStartIndex=maxStartIndexUntilNow;
				maxEndIndex = currentIndex;
			}
			if (cumulativeSum<0){
				maxStartIndexUntilNow=currentIndex+1;
				cumulativeSum=0;
			}

		}

		System.out.println("Max sum         : "+maxSum);
		System.out.println("Max start index : "+maxStartIndex);
		System.out.println("Max end index   : "+maxEndIndex);
	}

}
