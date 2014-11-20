/**
 * 
 */
package com.ctgi.google.arraysandstrings;

/**
 * @author Dany
 *
 * ALGORITHM:
 * - Get the two input strings.
 * - Store the first string character count in int array.(Considering ASCII values)
 * - iterate through the second string and then check for the character in the int array and 
 *   see if it is matching until the first string length
 * - If until the length of first string all character matches with the second string substring and 
 *   if the array count is zero for all character then return the substring anagram
 * 
 */
public class AnagramOfFirstStringInSecondString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		System.out.println(new AnagramOfFirstStringInSecondString().findAnagramSubstring("dog", "mrdhgodess"));
		
	}
	
	public String findAnagramSubstring(String str1, String str2)
	{
		if(str1==null || str2 ==null)
			return null;
		if(str1=="" || str2 == "")
			return null;
		int length1 = str1.length();
		int length2 = str2.length();
		
		int[] arrCount = new int[256];  //Considering the ASCII values
		for(int i=0; i<length1; i++)
		{
			char c = str1.charAt(i);
			arrCount[c]++;
		}
		
		int[] tempArr = arrCount;
		
		for(int j=0;j<length2;j++)
		{
			for(int k=j;k<length2;k++)
			{
				char ch = str2.charAt(k);

				if(k-j<length1)
				{
					if(tempArr[ch]>0)
					{
						tempArr[ch]--;
						if(k-j==length1-1)
						{
							if(isAnagram(tempArr))
								return str2.substring(j,length1);
						}
					}
					else
					{
						tempArr= arrCount;
						break;
					}
				}else
				{
					tempArr= arrCount;

					break;
				}
				}
			}
		return null;
			
		}
	
	public boolean isAnagram(int[] cArr)
	{
		for(int i=0;i<cArr.length;i++)
		{
			if(cArr[i]>0)
				return false;
		}
		
		return true;
		
	}

}
