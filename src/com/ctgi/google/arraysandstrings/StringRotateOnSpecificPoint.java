/**
 * 
 */
package com.ctgi.google.arraysandstrings;

/**
 * @author Dany
 *
 */
public class StringRotateOnSpecificPoint {

	/**
	 * @param args
	 * DESCRIPTION:
	 * - Given a string.Rotate the string on a specific index
	 *   for example "Water" rotation point 2 
	 *    gives erWat
	 * ALGORITHM :
	 * METHOD -I : [Not implemented]
	 * - Get the input string and the rotation point
	 * - Maintain two pointers i and j. i starts from the beginning of the string and 
	 *   j starts after the rotation point.
	 * - Keep swapping the character until j reaches the end of the string
	 * - Once j reaches the end swap the ith char with the next character until i reaches the end of the string
	 * 
	 * METHOD II:
	 * - Get the input string and rotation point
	 * - split the string into two on the rotation point namely first and second.
	 * - reverse the first and second strings - reverse(first) and reverse(second)
	 * - concatenate the reversed strings
	 * - reverse the concatenated string
	 * - return the string
	 *
	 */
	public static void main(String[] args) {
		String res = new StringRotateOnSpecificPoint().reverseString("Dinesh");
		System.out.println(res);
		
		System.out.println(new StringRotateOnSpecificPoint().rotateOnAnIndex("Water", 2));
	}
	
	public String rotateOnAnIndex(String str, int index)
	{
		if(str == null)
			return null;
		if(str == "")
			return "";
		String first = str.substring(0, index);
		String second = str.substring(index, str.length());
		
		String rev = reverseString(first) + reverseString(second);
		
		//System.out.println(first);
		//System.out.println(second);
		return reverseString(rev);
	}
	
	public String reverseString(String str)
	{
		if(str==null)
			return null;
		if(str=="")
			return "";
		int length = str.length();
		int i=0, j=length-1;
		
		char[] cArr = str.toCharArray();
		char temp;

		while(i<=j)
		{
			temp = cArr[i];
			cArr[i] = cArr[j];
			cArr[j] = temp;
			i++;
			j--;
		}
		
		return new String(cArr,0,length);
	}

}
