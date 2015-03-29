/**
 * 
 */
package com.ctgi.google.algorithms;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Dany
 *
 */
public class AllPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<CharSequence> result = new AllPalindrome().printAllPalindromes("hellolle");
		for(CharSequence s : result)
		{
			System.out.println(s+" " +s.length());
		}
		
		System.out.println(new AllPalindrome().countPalin("hellolle"));

	}



	public static Set<CharSequence> printAllPalindromes(String input) {
		if (input.length() <= 2) {
			return Collections.emptySet();
		}
		Set<CharSequence> out = new HashSet<CharSequence>();
		int length = input.length();
		for (int i = 1; i < length - 1; i++) {
			for (int j = i - 1, k = i + 1; j >= 0 && k < length; j--, k++) {
				if (input.charAt(j) == input.charAt(k)) {
					out.add(input.subSequence(j, k + 1));
				} else {
					break;
				}
			}
		}
		return out;
	}
	
	
	
	private int countPalin(String str)
    {
        int numPalin = 0;
        for (int i = 2; i <= str.length(); i++) 
        {
            for (int j = 0; j+i <= str.length(); j++) 
            {
                System.out.println("j "+j);
                System.out.println("i "+i);
                String test = str.substring(j, i);
                 
                if (checkPalin(test) && !test.equals("")) 
                {
                    System.out.println("test "+test);
                    numPalin++;
                }
            }
        }
         
        return numPalin;
    }
     
    private boolean checkPalin(String str)
    {
        StringBuffer sb = new StringBuffer(str);
        String rev = sb.reverse().toString();
         
        //System.out.println("str "+str);
        //System.out.println("rev "+rev);
        if (!str.equalsIgnoreCase(rev)) 
        {
            return false;
        }
         
        return true;
    }
}
