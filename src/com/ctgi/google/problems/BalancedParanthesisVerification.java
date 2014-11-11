/**
 * 
 */
package com.ctgi.google.problems;

/**
 * @author Dany
 *
 */
public class BalancedParanthesisVerification {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str="( (a+b)*(c* (d+e) ) )";
		String str1="(a+b)*(c*(d+e))";
		String str2="a+b*(c*(d+e))";
		String str4="(a+b)*(c*(d+e)))";
		String str5="((a+b)*c*d+e)))";
		
		System.out.println(new BalancedParanthesisVerification().checkBalancedParanthesis(str));


	}
	
	public boolean checkBalancedParanthesis(String str)
	{
		if(str==""||str==null)
			return false;
		char prev='a';
		int count=0;
		for(int i=0;i<str.length();i++)
		{
			char current = str.charAt(i);
			if(((current=='(')||(current==')'))&&(prev=='a'))
			{
				prev=current;
				if(prev==')')
					return false;
				else
					count=1;
			}else if(prev!='a') //Since char can't be assigned as empty (but Character object can be assigned as null)
			{
				if((current==prev)&&(current=='('))
				{
					count++;
					prev=current;
				}else if((current==prev)&&(current==')'))
				{
					count--;
					prev=current;
				}else if((current!=prev)&&(current=='('))
				{
					prev=current;
				}else if((current!=prev)&&(current==')'))
				{
					prev=current;
				}
			}
		}
		
		//System.out.println(count);
		if(count==1)
			return true;
		else
			return false;
		
	}

}
