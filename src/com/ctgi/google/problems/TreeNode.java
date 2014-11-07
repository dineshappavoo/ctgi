package com.ctgi.google.problems;



/**
 * 
 */

/**
 * @author Dinesh Appavoo
 *
 */
public class TreeNode {

	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	public boolean visited;
	
	
	public TreeNode(int data)
	{
		this.data=data;
		this.left=null;
		this.right=null;
		this.parent=null;
		
	}


	public TreeNode() {
		// TODO Auto-generated constructor stub
	}

	public TreeNode insertBT(TreeNode root, int data, int dataAfter, String sPos)
	{
		TreeNode temp=root;
		if(temp==null)
			return null;
		if(temp.data==dataAfter)
		{
			if(sPos=="left")
			{
				TreeNode newLeftNode=new TreeNode(data);
				if(temp.left==null)
				{
					temp.left=newLeftNode;
					newLeftNode.parent=temp;
					return root;
				}else
				{
					TreeNode tempNode=temp.left;
					temp.left=newLeftNode;
					newLeftNode.parent=temp;
					tempNode.parent=newLeftNode;
					newLeftNode.left=tempNode;
				}
				
			}else if(sPos=="right")
			{
				TreeNode newRightNode=new TreeNode(data);
				if(temp.right==null)
				{
					temp.right=newRightNode;
					newRightNode.parent=temp;
				}else 
				{
					TreeNode tempNode1=temp.right;
					temp.right=newRightNode;
					newRightNode.parent=temp;
					newRightNode.left=tempNode1;
					tempNode1.parent=newRightNode;
				}
					
			}
		}
		
		insertBT(root.left, data, dataAfter, sPos);
		insertBT(root.right, data, dataAfter, sPos);
		return root;
		
		
	}
	
	public TreeNode insertBST(TreeNode root, int data)
	{
		TreeNode temp=root;
		if(temp==null)
			return null;
		if(data<=temp.data)
		{
			if(temp.left==null)
			{

				TreeNode newNode=new TreeNode(data);
				temp.left=newNode;
				newNode.parent=temp;

				return root;
			}else
			insertBST(temp.left, data);
		}
		if(data>temp.data)
		{

			if(temp.right==null)
			{

				TreeNode newNode=new TreeNode(data);
				temp.right=newNode;
				newNode.parent=temp;

				return root;
			}else
			insertBST(temp.right, data);
		}
		return root;
	}
	
	public void inOrderTraversal(TreeNode root)
	{
		if(root==null)
			return;
		inOrderTraversal(root.left);
		
		System.out.print(root.data+" ");

		
		inOrderTraversal(root.right);
		
		//For testing whether the tree is left skewed
		//if(root.right!=null)
			//System.out.println("Right exist");
		
		
	}
	
	
	public void preOrderTraversal(TreeNode root)
	{
		if(root==null)
			return;
		System.out.print(root.data+" ");

		inOrderTraversal(root.left);

		inOrderTraversal(root.right);
		
		
	}
	
	public void getNodes(TreeNode root, TreeNode[] catchArr, int searchData, int count)
	{
		if(root==null)
			return;
		getNodes(root.left, catchArr, searchData, count);
		
		//System.out.println("Node Value : "+root);
		if(root.data==searchData)
			catchArr[count]=root;
		
		
		getNodes(root.right, catchArr, searchData, count);
	}
	
}
