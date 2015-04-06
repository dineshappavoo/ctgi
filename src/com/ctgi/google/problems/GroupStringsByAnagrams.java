/**
 * 
 */
package com.ctgi.google.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Dany
 *
 */

/**
 *ALGORITHM :(list)
 *1. Declare a hashmap of string, list<String>
 *2. Iterate through the list. *
 *3. Foreach string str 
 *		sortedstring =sort(str)
 *		if hmap contains(sortedstring)
 *			hmap.get(sortedstring).add(str)
 *		else
 *			alist = new ArrayList<String>
 *			alist.add(str)
 *			hmap.put(sortedstring, alist)
 *
 */
public class GroupStringsByAnagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    ArrayList<String> strings = new ArrayList<String>();
	    strings.add("star");
	    strings.add("astr");
	    strings.add("car");
	    strings.add("rac");
	    strings.add("st");
	    
	    new GroupStringsByAnagrams().groupStringsByAnagrams(strings);
	}

	public void groupStringsByAnagrams(ArrayList<String> list)
	{
		if(list == null)
			return;
		HashMap<String, ArrayList<String>> hMap = new HashMap<String, ArrayList<String>>();
		String sortedString="";
		ArrayList<String> aList;
		
		for(String str : list)
		{
			sortedString = sortString(str);
			//System.out.println("Orig: "+str+"   Sorted :  "+sortedString);
			if(hMap.containsKey(sortedString))
			{
				hMap.get(sortedString).add(str);
			}else
			{
				aList = new ArrayList<String>();
				aList.add(str);
				hMap.put(sortedString, aList);
			}
		}
		System.out.print("[ ");
		for(String s : hMap.keySet())
		{
			aList = hMap.get(s);
			System.out.print("[ ");
			for(String st : aList)
			{
				System.out.print(st+" ");
			}
			System.out.print("]");
		}
		System.out.print(" ]");

	}

	public String sortString(String str)
	{
		if(str == null)
			return null;
		char[] cArr = new char[str.length()];
		cArr = str.toCharArray();
		Arrays.sort(cArr);
		return new String(cArr);
	}
}
