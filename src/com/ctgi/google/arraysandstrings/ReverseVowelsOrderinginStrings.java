/**
 * 
 */
package com.ctgi.google.arraysandstrings;

import java.util.ArrayList;

/**
 * @author Dany
 * 
 * ALGORITHM:
 * - Get the input string
 * - Create a boolean array to store the vowels vBool[]
 * - create a ArrayList to store the vowel 
 * - Iterate through the character in the input strings and check for vowels
 * -    if(vBool(c)) then update the Arraylist with the char c else do nothing
 * - Iterate through the strings again and update string (To update the string, store the string in a char array because string object is immutable)
 * -   if iteration char is vowel then update the char array element with ArrayList elements (Iteration in arraylist should start from the last element of arraylist)
 * - 
 * 
 * COMPLEXITY:
 * - O(n) Time
 * - O(n) Space
 */
public class ReverseVowelsOrderinginStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str= "dinesh appavoo";
		char[] res = new ReverseVowelsOrderinginStrings().reverseVowelPositionsInString(str);
		
		for(int i=0;i<res.length;i++)
		{
			System.out.print(res[i]);

		}
		
		
	}
	
	public char[] reverseVowelPositionsInString(String str)
	{
		boolean[] vBool = new boolean[256];
		String vowels = "aeiou";
		for(int i=0;i<vowels.length();i++)
		{
			vBool[vowels.charAt(i)] = true;
		}
		ArrayList<Character> vowelList = new ArrayList<Character>();
		
		for(int j=0;j<str.length();j++)
		{
			if(vBool[str.charAt(j)])
				vowelList.add(str.charAt(j));
		}
		
		int vowelIndex = vowelList.size()-1; //Index starts from last vowel char
		char[] cArr = str.toCharArray();
		for(int k=0;k<str.length();k++)
		{
			if(vBool[str.charAt(k)])
				cArr[k]=vowelList.get(vowelIndex--);				
		}
		
		return cArr;
		
	}

}
