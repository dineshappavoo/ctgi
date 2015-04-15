/**
 * 
 */
package com.ctgi.google.problems;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Dany
 *
 * Question : string manipulation program and remove duplicate words ?
 *
 *ALGORITHM : Remove_Duplicates(Str)
 *1. Create a Hashmap of <String, Boolean> to store the words
 *2. For each word in the string
 *		if word exists in hMap then dont add to the result string
 *		else add to the result string and put in the hashmap
 *3. return the result string
 */
public class RemoveDuplicateWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Dinesh is currently working on ctgi repository. Also Dinesh likes to work on big data projects . These projects helps him in his job search . But job search does not only depend on this";
		String res = new RemoveDuplicateWords().removeDuplicateWords(str);
		System.out.println(res);
	}
	
	public String removeDuplicateWords(String str)
	{
		if(str == null || str == "")
			return null;
		HashMap<String, Boolean> strMap = new HashMap<String, Boolean>();
		Scanner scanner = new Scanner(str);
		String word = "";
		StringBuffer sBuffer = new StringBuffer();
		while(scanner.hasNext()) 
		{
			word = scanner.next();
			if(!strMap.containsKey(word))
			{
				sBuffer.append(word);
				sBuffer.append(" ");
				strMap.put(word, true);
			}
		}
		return sBuffer.toString();
	}

}
