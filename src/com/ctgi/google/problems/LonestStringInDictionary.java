/**
 * 
 */
package com.ctgi.google.problems;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Dany
 *
 */
public class LonestStringInDictionary {

	/**
	 * @param args
	 */
	static StringObject longestWord = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> dictionary=new ArrayList<String>();
		dictionary.add("cbde");
		dictionary.add("acd");

		dictionary.add("abd");
		dictionary.add("adecb");
		dictionary.add("mba");
		dictionary.add("abcd");

		
		new LonestStringInDictionary().findLongestString("abcde", dictionary);
		
		System.out.println(longestWord.str);
	}
	
	public void findLongestString(String word, ArrayList<String> dictionary)
	{
		if(word==null || word == "")
			return;
		int count=0;
		HashMap<Character, Boolean> charMap = new HashMap<Character, Boolean>();
		for(int i=0; i< word.length();i++)
		{
			charMap.put(word.charAt(i), true);
		}
		
		for(String str : dictionary)
		{
			count=0;
			for(int j=0;j<str.length();j++)
			{
				if(charMap.containsKey(str.charAt(j)))
				{
					count++;
				}else
					break;
			}
			if(count==str.length())
			{
				if(longestWord==null)
					longestWord=new StringObject(str, str.length());
				else if(longestWord.length<count)
					longestWord=new StringObject(str, count);
			}
		}
	}
	
	

}
