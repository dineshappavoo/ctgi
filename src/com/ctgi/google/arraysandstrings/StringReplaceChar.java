/**
 * 
 */
package com.ctgi.google.arraysandstrings;

/**
 * @author Dany
 *
 * ALGORITHM: (Remove all occurrences a specific character from the input string)
 * - Get the input string and character c
 * - convert that to a character array
 * - make two pointers. i.One iterate through all the characters in the array
 *   ii. Another if it find the char
 */
public class StringReplaceChar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String res = new StringReplaceChar().replaceChar1("Bloomborg", 'o');

		System.out.println(res);
		/*for(int i=0;i<res.length;i++)
		{
			System.out.print(res[i]);
		}*/
	}

	public char[] replaceChar(String str, char c)
	{
		int j=0;
		boolean isCharAvail=false;
		char[] cArr=str.toCharArray();
		for(int i=0;i<cArr.length;i++)
		{
			if(!isCharAvail)
				j=i;

			while(cArr[j]==c)
			{
				j++;
				isCharAvail=true;

			}


			if(i+1<cArr.length && (j+1<cArr.length))
			{
				cArr[i]=cArr[j++];


			}

			if(j+1==cArr.length)
				cArr[i]='\0';

		}
		return cArr;
	}

	public String replaceChar1(String str, char c)
	{
		int j=0;
		char[] cArr=str.toCharArray(); //Bloomberg
		for(int i=0;i<cArr.length;i++)
		{
			if(cArr[i]!=c)
			{
				cArr[j]=cArr[i];
				j++;
			}
			else
			{
				cArr[j]=cArr[i];
			}
		}
		cArr[j] = '\0';
		String res = new String(cArr, 0, j);
		return res;
	}

}
