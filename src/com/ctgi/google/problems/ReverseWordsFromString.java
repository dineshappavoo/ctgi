/**
 * 
 */
package com.ctgi.google.problems;

/**
 * @author Dany
 *
 */
public class ReverseWordsFromString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = " Hello  world         a                go ";
		System.out.println(str.substring(1,5+1));
		String res = new ReverseWordsFromString().reverseWords(str);
		System.out.println("Reversed String : "+res);
	}

	public String reverseWords(String str)
	{
		StringBuffer sBuffer = new StringBuffer();
		char c;
		int startIndex=0, endIndex=0;
		boolean isStartIndexSet=false;

		for(int i=0;i<str.length();i++)
		{
			c = str.charAt(i);
			if(c!=' ')
			{
				if(isStartIndexSet)
				{
					endIndex=i;
				}else
				{
					startIndex=i;
					endIndex=i;
					isStartIndexSet=true;
				}
			}else
			{
				if(isStartIndexSet)
				{
					sBuffer.append(reverseString(str.substring(startIndex, endIndex+1)));
					sBuffer.append(c);
					isStartIndexSet=false;
				}else
				{
					sBuffer.append(c);
				}
			}


		}

		return sBuffer.toString();
	}

	public String reverseString(String str)
	{
		StringBuffer sBuffer=new StringBuffer();
		char c;
		for(int i=str.length()-1;i>=0;i--)
		{
			c= str.charAt(i);
			sBuffer.append(c);
		}return sBuffer.toString();
	}

}
