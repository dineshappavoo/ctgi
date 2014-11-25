/**
 * 
 */
package com.ctgi.google.problems;

/**
 * @author Dany
 *
 */
public class second {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	Given an org chart as a non-cyclical tree, each node is a person.  What is the greatest number of degrees of separation from the CEO ?
	        1
	    2       3
	4 5 6
	class TreeNode {
		List<TreeNode> children;
		int happiness;
		public List<TreeNode> getChildren();
	}


	public static int getMaxDegree(TreeNode root) {
	if(root == null)
		return 0;
	int max = 0;
	List<TreeNode> childList = root.getChildren();
	for(TreeNode n : childList) {
	int height = getMaxDegree(n);
	if(height>max)
		max=height + 1;
	}
	return max;
	}

	Given an org chart as a non-cyclical tree, each node is a person.  Each node has a personal happiness score (the greater the double, the greater the happiness).  Each manager (node with children) has an uncalculated aggregate happiness: the average happiness of all reports and him/herself.  Return the node with the greatest aggregate happiness.



	               1->5 (26/5)
	   2->3->5         4->6
	5->4  7->8








	class TreeNode {
		int nodeId;
		List<TreeNode> children;
		int happiness;
		double avgHappiness;
		int numEmployees;
		public List<TreeNode> getChildren();
	}


	public void claculateHappinessFromEachSubtree(TreeNode root, HashMap<Integer, double> hMap)
	{
	if(root == null)
	{
	return;
	}
	int size=1;
	int totHappiness = 0;
	List<TreeNode> childList =  root.getChildren();

	for(TreeNode n : childList)
	{
	claculateHappinessFromEachSubtree(n, hMap);

	totHappiness += n.happiness;
	size++;
	}
	double avgHappiness = (totHappiness + root.happiness)/size;

	hMap.put(root.nodeId, avgHappiness);
	}

	          1->5 (26/5)
	   2->3->5         4->6
	5->4  7->8

	 (1, )
	(2, 3)
	()



	
	

}
