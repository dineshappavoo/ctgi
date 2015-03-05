/**
 * 
 */
package com.ctgi.google.problems;

import java.util.ArrayList;

/**
 * @author Dany
 *
 */
public class ClosestNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> inList = new ArrayList<Integer>();
		inList.add(1);
		inList.add(3);
		inList.add(9);
		inList.add(5);
		inList.add(6);
		inList.add(8);
		inList.add(5);
		
		ArrayList<Integer> res = new ClosestNumbers().findClosest(inList, 4);
		for(int n : res)
		{
			System.out.println(n);
		}

	}
	
	public ArrayList<Integer> findClosest(ArrayList<Integer> inList, int x)
	{
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		int diff=Integer.MAX_VALUE;
		int val;
		for(int i=0;i<inList.size();i++)
		{
			int n = inList.get(i);
			val=Math.abs(n-x);
			if(val<diff)
			{	indexList = new ArrayList<Integer>();
				diff = val;
				indexList.add(i);
			}else if(val == diff)
			{
				indexList.add(i);

			}
		}
		
		return indexList;
	}

}
