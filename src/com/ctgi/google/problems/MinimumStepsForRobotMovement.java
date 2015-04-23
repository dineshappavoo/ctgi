/**
 * 
 */
package com.ctgi.google.problems;

import java.util.ArrayList;

/**
 * @author Dany
 *
 *Q : A robot has to move in a grid which is in the form of a matrix. It can go to 
	1.) A(i,j)--> A(i+j,j) (Down) 
	2.) A(i,j)--> A(i,i+j) (Right) 

	Given it starts at (1,1) and it has to go to A(m,n), find the minimum number of STEPS it has to take to get to (m,n) and write 
	public static int minSteps(int m,int n) 
	
	
	
	
 */
public class MinimumStepsForRobotMovement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new MinimumStepsForRobotMovement().minSteps(3,2));
	}
	
	public int minSteps(int m, int n)
	{
		ArrayList<Integer> steps = new ArrayList<Integer>();
		int ways = findRobotMovementWays(1, 1, 1, 1, m, n, 0, steps);
		int minNoOfSteps = Integer.MAX_VALUE; 
		for(int val : steps)
		{
			if(val<minNoOfSteps)
			{
				minNoOfSteps = val;
			}
			System.out.println("Value : "+val);

		}
		return minNoOfSteps;		
	}
	
	public int findRobotMovementWays(int x, int y, int oldX, int oldY, int destX, int destY, int level, ArrayList<Integer> steps)
	{
		if(x<0 || x>destX || y<0 || y>destY)
		{
			steps.add(level);
			return 0;
		}
		if(x == destX && y == destY)
			return 1;
		int noOfways =  findRobotMovementWays(x+1, y, x, y, destX, destY, level+1, steps) + 
						findRobotMovementWays(x, y+1, x, y, destX, destY, level+1, steps);
		return noOfways;
	}
	

}
