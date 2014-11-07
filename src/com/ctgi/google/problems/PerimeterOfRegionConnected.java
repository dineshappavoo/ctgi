/**
 * 
 */
package com.ctgi.google.problems;

/**
 * @author Dany
 *
 */
public class PerimeterOfRegionConnected {

	/**
	 * @param args
	 * 
	 * 
	 * 	4445
		4544
		4554
		4444
	 */
	static int[][] colors={{4,4,4,5},{4,5,4,4},{4,5,5,4},{4,4,4,4}};

	static int[][] visited=new int[colors.length][colors[0].length];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int res=new PerimeterOfRegionConnected().findPerimeterOfRegionConnected(colors, 1, 1, colors[1][1], colors[1][1]);
		System.out.println(res);
	}
	
	public int findPerimeterOfRegionConnected(int[][] colors, int x, int y, int oldVal, int newVal)
	{
		if(	(x>colors.length) || (x< 0) || (y>(colors[0].length))  || (y<0) )
			return 0;
		if(oldVal!=newVal)
		{
			return 1;
		}
		else
		{
			if(visited[x][y]==1)
			{
				return 0;
			}
			visited[x][y]=1;
		}
		
		return findPerimeterOfRegionConnected(colors, x-1, y, colors[x][y], colors[x-1][y])+
				findPerimeterOfRegionConnected(colors, x, y-1, colors[x][y], colors[x][y-1])+
				findPerimeterOfRegionConnected(colors, x+1, y, colors[x][y], colors[x+1][y])+
				findPerimeterOfRegionConnected(colors, x, y+1, colors[x][y], colors[x][y+1]);
	}

}
