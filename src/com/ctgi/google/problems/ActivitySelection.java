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
 */
public class ActivitySelection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActivitySelection aSelection = new ActivitySelection();
		ArrayList<ActivityTime> activities = new ArrayList<ActivityTime>();

		activities.add(new ActivityTime(2,5));
		activities.add(new ActivityTime(5,9)); 
  		activities.add(new ActivityTime(8,11)); 
  		activities.add(new ActivityTime(9,11)); 
  		activities.add(new ActivityTime(12,13)); 
  		activities.add(new ActivityTime(13,14)); 
  		activities.add(new ActivityTime(15,17)); 
  		activities.add(new ActivityTime(16,18)); 
  		activities.add(new ActivityTime(19,20)); 
  		activities.add(new ActivityTime(19,21)); 


		ArrayList<ActivityTime> result = aSelection.findMinimumHallsForActivity(activities); 

		for(ActivityTime aTime : result)
		{
			System.out.println(aTime.startTime+","+aTime.endTime);
		}
	}


	public ArrayList<ActivityTime> findMinimumHallsForActivity(ArrayList<ActivityTime> activities)
	{
		//Minheap used to sort the activity by end time
		PriorityQueue<ActivityTime> minHeap = implementMinHeapPriorityQueue();
		for(ActivityTime aTime : activities)
		{
			minHeap.add(aTime);
		}
		ArrayList<ActivityTime> resultActivities = new ArrayList<ActivityTime>();
		ActivityTime first = minHeap.poll();
		int currentEnd = first.endTime;
		resultActivities.add(first);
		for(int i=1;i<activities.size();i++)
		{
			ActivityTime aTime = minHeap.poll();
			if(aTime.startTime>=currentEnd)
			{
				resultActivities.add(aTime);
			}
			currentEnd = aTime.endTime;
		}
		return resultActivities;
	}

	public PriorityQueue<ActivityTime> implementMinHeapPriorityQueue()
	{
		PriorityQueue<ActivityTime> queue = new PriorityQueue<ActivityTime>(11, new Comparator<ActivityTime>()
				{
			public int compare(ActivityTime o1, ActivityTime o2)
			{
				int w1=o1.endTime;
				int w2=o2.endTime;
				return (w1 - w2); 
			}
				}
				);
		return queue;	
	}

}
