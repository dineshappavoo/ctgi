/**
 * 
 */
package com.ctgi.google.recursionanddynamicprogramming.ctci97;

/**
 * @author Dany
 *
 */
public class MatchingPositionsCount {

	/**
	 * @param args
	 */
	
	static int[][] colors={{4,4,4,5},{4,5,4,4},{4,5,5,4},{4,4,4,4}};
	static int[][] visited=new int[colors.length][colors[0].length];
	static int count =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val =  new MatchingPositionsCount().findMatchingPositionCount(colors, 1, 1, 1, 1, count);
		 System.out.println(val);
		

	}
	
	public int findMatchingPositionCount(int[][] colors, int x, int y, int oldX, int oldY, int count)
	{
		if(x<0 || x>colors.length || y<0 || y>colors[0].length)
		{
			return count;
		}
		
		if(colors[x][y] != colors[oldX][oldY])
		{
			if(visited[x][y]==1)
				return count;
			visited[x][y] = 1;
			return count;
		}else 
		{
			if(visited[x][y] ==1)
			{
				return count;
			}else
			{
				visited[x][y] = 1;
				count++;
		
		int totCount = findMatchingPositionCount(colors, x+1, y, x, y, count) +
		findMatchingPositionCount(colors, x, y+1, x, y, count)+
		findMatchingPositionCount(colors, x-1, y, x, y, count)+
		findMatchingPositionCount(colors, x, y-1, x, y, count);
		return totCount;
			}
		}
	}

}
