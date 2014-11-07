package com.ctgi.google;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 
 */


/**
 * @author Dany
 *
 */
public class BreadthFirstSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	
	public StringBuffer doBFS(TreeNode root)
	{
		StringBuffer sBuffer=new StringBuffer();
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(root);
		root.visited=true;
		
		while(!queue.isEmpty())
		{
			TreeNode n=queue.poll();

			sBuffer.append(n.data);
			sBuffer.append(",");
			//System.out.print(n.data+",");
			TreeNode left=n.left;
			TreeNode right=n.right;
		
			if(n.left!=null&&n.left.visited==false)
			{
			queue.add(left);
			}
			
			if(n.right!=null&&n.right.visited==false)
			{
			queue.add(right);
			}
			
			n.visited=true;		
		}	
		return sBuffer;
	}

}
