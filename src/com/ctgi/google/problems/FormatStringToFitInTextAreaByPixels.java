/**
 * 
 */
package com.ctgi.google.problems;

/**
 * @author Dany
 *
 */

// If I type a line of text that is too wide to fit the text area it will automatically wrap to the next line. This is what you will be implementing in this coding problem.
// Write function: input 1) string 2) width in pixels of text area -> output 1) string with newlines added
// Provided function: input 1) string -> output 1) width in pixels of string
// f(u+v) != f(u) + f(v)
// f(u+v) >= f(u)
// "Hello world" != "Hello" + " " + "world"

// "Hello world again", 500px
// "Hello world again" -> 750px
// "Hello" -> 450px

//""
public class FormatStringToFitInTextAreaByPixels {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public String appendStringWithNewLines(String str, int pixels)
	{
		int strLength = str.length();

		String currentStringPart = "";
		int currentPixelSize = 0;
		String lastValidStringPart = "";

		StringBuffer formattedStringBuffer = new StringBuffer();
		int j=0;
		int i=0;

		while(j<strLength)
		{  

			for(i=j;i<strLength;i++)
			{
				currentStringPart = str.substring(j,i);
				currentPixelSize = f(currentStringPart);
				if(currentPixelSize == pixels)
				{
					currentStringPart = currentStringPart + "\n";
					formattedStringBuffer.append(currentStringPart);
					break;
					//return currentStringPart;
				}else if(currentPixelSize < pixels)
				{
					lastValidStringPart = currentStringPart;
				}else
				{
					lastValidStringPart = lastValidStringPart + "\n";
					formattedStringBuffer.append(lastValidStringPart);
					break;
					//return lastValidStringPart;
				}      
			}
			j=i;
		}

		return formattedStringBuffer.toString();

	}
}
