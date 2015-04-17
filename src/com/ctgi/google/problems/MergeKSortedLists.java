/**
 * 
 */
package com.ctgi.google.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Dany
 *
 *Question: Merge k sorted lists efficiently
 *
 *ALGORITHM:Merge_K_SortedLists(list<list>)
 *1. Create a min heap 
 *2. Add object(list_index, list_value) from all lists to the heap
 *3. get the min from the heap
 *4. add the min to the merged_array and increment the respective list by 1 size and add that element to heap
 *5. continue the process until you reach all the array elements from all lists
 *6. return the merged_array
 *
 */
public class MergeKSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<ArrayList<Integer>> sortedLists = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(5);
		list1.add(7);
		list1.add(8);
		list1.add(10);
		sortedLists.add(list1);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(2);
		list2.add(4);
		list2.add(9);
		list2.add(11);
		sortedLists.add(list2);
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(1);
		list3.add(3);
		list3.add(6);
		list3.add(12);
		sortedLists.add(list3);

		int[] res = new MergeKSortedLists().mergeKSortedList(sortedLists);

		for(int n : res)
		{
			System.out.println(" "+n);
		}
	}

	public int[] mergeKSortedList(ArrayList<ArrayList<Integer>> sortedLists)
	{
		int totalSize = 0;
		int noOfLists = 0;
		int[] mergedArray;
		boolean[] listExist;
		int j=0, value = 0, index;
		Number numObj;
		for(ArrayList<Integer> list : sortedLists)
		{
			totalSize += list.size();
			noOfLists++;
		}

		mergedArray = new int[totalSize];
		listExist = new boolean[noOfLists];
		PriorityQueue<Number> minHeap = implementMinHeapPriorityQueue();

		for(int i=0;i<noOfLists;i++)
		{
			minHeap.add(new Number(i, sortedLists.get(i).get(0)));
		}
		while(!isAllListsMerged(listExist))
		{
			numObj = minHeap.poll();
			index = numObj.listIndex;
			mergedArray[j++] = numObj.value;
			sortedLists.get(index).remove(0);
			if (sortedLists.get(index).size() == 0) {
				listExist[index] = true;
			}
			if(!listExist[index])
				minHeap.add(new Number(index, sortedLists.get(index).get(0)));
		}
		return mergedArray;		
	}

	public boolean isAllListsMerged(boolean[] listExists)
	{
		for(boolean val : listExists)
		{
			if(!val)
				return false;
		}
		return true;
	}

	public PriorityQueue<Number> implementMinHeapPriorityQueue()
	{
		PriorityQueue<Number> queue = new PriorityQueue<Number>(11, new Comparator<Number>()
				{
			public int compare(Number o1, Number o2)
			{
				int v1=o1.value;
				int v2=o2.value;
				return (v1 - v2); 
			}
				}
				);
		return queue;	
	}
}
