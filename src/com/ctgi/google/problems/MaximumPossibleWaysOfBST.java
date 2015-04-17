/**
 * 
 */
package com.ctgi.google.problems;

import java.util.HashMap;

/**
 * @author Dany
 *
 *Question : With ' N ' no of nodes, how many different Binary and Binary Search Trees possible?
 */
public class MaximumPossibleWaysOfBST {

	/**
	 * @param args
	 */
	
	public HashMap<Long, Long> memoTable = new HashMap<Long, Long>();
	public HashMap<Integer, Integer> memoTable1 = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new MaximumPossibleWaysOfBST().t(1000));

		System.out.println(new MaximumPossibleWaysOfBST().countTrees(1000));
	}
	
	public long t(long n)
	{
		if( n<=1)
		{
			return 1;
		}
		if(memoTable.containsKey(n))
			return memoTable.get(n);
		long val =0;
		long j = n-1;
		for(long i=0;i<n;i++)
		{
			val += t(i)*t(j--);
            //val += t(i-1)*t(Math.abs(n-i));

		}
		memoTable.put(n, val);
		return memoTable.get(n);
	}
	
	public int countTrees(int numKeys) { 
		  if (numKeys <=1) { 
		    return(1); 
		  } 
		  else { 
		    // there will be one value at the root, with whatever remains 
		    // on the left and right each forming their own subtrees. 
		    // Iterate through all the values that could be the root... 
			  
			if(memoTable1.containsKey(numKeys))
				return memoTable1.get(numKeys);
		    int sum = 0; 
		    int left, right, root;

		    for (root=1; root<=numKeys; root++) { 
		      left = countTrees(root-1); 
		      right = countTrees(numKeys - root);

		      // number of possible trees with this root == left*right 
		      sum += left*right; 
		    }

		    //return(numKeys); 
			memoTable1.put(numKeys, sum);
			return memoTable1.get(numKeys);
		  } 
		} 

}
