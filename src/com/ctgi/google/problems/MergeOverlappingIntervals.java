/**
 * 
 */
package com.ctgi.google.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Dany
 *
 */
public class MergeOverlappingIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Interval> inList=new ArrayList<Interval>();
		inList.add(new Interval(1, 3));
		inList.add(new Interval(2, 6));

		inList.add(new Interval(9, 11));

		inList.add(new Interval(5, 10));
		inList.add(new Interval(8, 15));
		inList.add(new Interval(20, 25));

		ArrayList<Interval> outList = new MergeOverlappingIntervals().mergeOverlappingInterval(inList);
		for(Interval interval : outList)
		{
			System.out.print("["+interval.start+","+interval.end+"],");
		}
	}
	
	public ArrayList<Interval> mergeOverlappingInterval(ArrayList<Interval> inList)
	{
		if(inList==null)
			return null;
		ArrayList<Interval> outList=new ArrayList<Interval>();
		Collections.sort(inList,new IntervalComparator());
		Interval prev=inList.get(0);
		
		int prevStart=prev.start;
		int prevEnd=prev.end;
		
		System.out.println(inList.size());
		for(int i=1;i<inList.size();i++)
		{
			Interval current=inList.get(i);
			if(current.start>=prevStart&&current.start<=prevEnd)
			{
				if(current.end>prevEnd)
					prevEnd=current.end;
			}else
			{
				outList.add(new Interval(prevStart, prevEnd));
				prevStart=current.start;
				prevEnd=current.end;
			}
		}
		outList.add(new Interval(prevStart, prevEnd));
		return outList;
	}
	
	class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
	

}
}
