/**
 * 
 */
package com.ctgi.google.problems;

/**
 * @author Dany
 *
 *
 *1. Find the deepest node of a binary tree. If multiple nodes are at the deepest level, then return the rightmost node.

 */
public class DeepestNodeInBinaryTree {

	/**
	 * @param args
	 */
	
	public static DeepestNode deepestNode=new DeepestNode(null, Integer.MIN_VALUE);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] postOrder={110,121,135,71,101,116,40,22,32,100,82,142,6,143,25,49,123,87,77,31,120,12,48,41,66,17,109,63,28,35,140,113,70,79,122,92,53,96,90,75,8,114,21,36,91,9,115,43,128,37,93,107,86,1,104,138,16,65,14,2,102,111,98,83,10,119,52,68,19,85,84,80,118,13,130,94,18,50,112,11,44,124,51,134,55,99,62,56,33,57,30,137,81,39,105,108,89,42,5,126,64,23,60,141,136,127,103,3,78,139,4,74,26,129,88,20,7,59,69,133,73,97,61,131,45,38,125,54,76,46,95,106,47,67,24,72,15,34,27,29,58,117,132,0};
		int[] inOrder={117,58,67,95,46,54,125,73,69,59,7,88,26,139,78,103,136,60,23,126,42,89,105,81,137,30,33,56,99,51,44,112,50,18,13,118,80,84,85,68,52,10,83,98,111,102,2,16,86,36,21,114,8,75,90,53,92,122,70,66,41,120,31,77,87,123,25,143,6,82,100,22,116,101,135,110,121,71,40,32,142,49,12,48,17,109,63,28,35,140,113,79,96,91,9,115,43,128,37,93,107,1,104,138,65,14,119,19,130,94,11,124,134,55,62,57,39,108,5,64,141,127,3,4,74,129,20,133,97,61,131,45,38,76,106,47,24,72,15,34,27,29,132,0};
		TreeNode root=null;
		System.out.println("Size "+postOrder.length);
		
		try {
			root = new CreateTreeGivenPostAndInOrder().createBinaryTree(postOrder, 0, postOrder.length-1, inOrder, 0, inOrder.length-1);
		} catch (Exception e) {
			System.out.println("Invalid Input");
		}
		
		root.inOrderTraversal(root);
		new DeepestNodeInBinaryTree().findDeepestNode(root, 0);
		System.out.println("\nNode Data "+deepestNode.node.data+" Depth "+deepestNode.depth);
		
	}	
	public void findDeepestNode(TreeNode root, int level)
	{
		if(root==null)
			return;
		if(root.left==null && root.right==null)
		{
			if(level>=deepestNode.depth)
			{
				deepestNode=new DeepestNode(root, level);
				return;
			}else
				return;
		}
		findDeepestNode(root.left, level+1);
		findDeepestNode(root.right, level+1);

	}
}


