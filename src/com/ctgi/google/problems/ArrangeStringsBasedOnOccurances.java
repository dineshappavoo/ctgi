/**
 * 
 */
package com.ctgi.google.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Dany
 *
 */
public class ArrangeStringsBasedOnOccurances {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> stringList = new ArrayList<String>();
		stringList.add("world");
		stringList.add("world");
		stringList.add("the");
		stringList.add("utd");
		stringList.add("hello");
		stringList.add("hello");
		stringList.add("a");


		HashMap<String, Integer> strMap = new ArrangeStringsBasedOnOccurances().arrangeStringByOccurances(stringList);
		System.out.println(strMap);
	}

	public HashMap<String, Integer> arrangeStringByOccurances(ArrayList<String> stringList)
	{
		HashMap<String, Integer> strMap = new HashMap<String, Integer>();
		for(String str : stringList)
		{
			if(strMap.containsKey(str))
			{
				strMap.put(str, strMap.get(str)+1);
			}else
			{
				strMap.put(str, 1);
			}
		}		
		strMap = (HashMap<String, Integer>) sortByValue(strMap);
		System.out.println("unsorted map: "+strMap);
		return strMap;
	}

	//Unused - Have to test later
	class ValueComparator implements Comparator<String> {

		Map<String, Integer> base;
		public ValueComparator(Map<String, Integer> base) {
			this.base = base;
		}

		// Note: this comparator imposes orderings that are inconsistent with equals.    
		public int compare(String a, String b) {
			if (base.get(a) >= base.get(b)) {
				return -1;

			} else {
				return 1;
			} // returning 0 would merge keys
		}

	}


	public static  Map<String,Integer> sortByValue(Map<String,Integer> unsortMap) {

		List<String> l = new LinkedList(unsortMap.entrySet());

		Collections.sort(l, new Comparator() {
			public int compare(Object Obj1, Object Obj2) {
				return ((Comparable) ((Map.Entry) (Obj1)).getValue())
						.compareTo(((Map.Entry) (Obj2)).getValue());
			}
		});

		Map mapSorted = new LinkedHashMap();
		for (Iterator itrerator = l.iterator(); itrerator.hasNext();) {
			Map.Entry ent = (Map.Entry) itrerator.next();
			mapSorted.put(ent.getKey(), ent.getValue());
		}
		return mapSorted;
	}
}
