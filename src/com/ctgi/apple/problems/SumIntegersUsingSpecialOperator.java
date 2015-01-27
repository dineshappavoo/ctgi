/**
 * 
 */
package com.ctgi.apple.problems;

/**
 * @author Dany
 *
 */
public class SumIntegersUsingSpecialOperator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res = new SumIntegersUsingSpecialOperator().sumIntegerUsingIncrementalOperator(-3, -8);
		System.out.println(res);
		int res1 = new SumIntegersUsingSpecialOperator().sumIntegerUsingIncrementalOperatormethod2(-3, -8);
		System.out.println(res1);
	}
	
	/**
	 * Write code to sum 2 integer but u cant use a+b method, you have to use either ++ or --. 
	 * How you will handle negative numbers?
	 * 
	 * @return
	 */
	public int sumIntegerUsingIncrementalOperator(int a, int b)
	{
		boolean bFlag=false;
		if(b<0)
			bFlag=true;
		if(bFlag)
		{
			b = Math.abs(b);
			for(int i=0; i<b; i++)
			{
				a--;
			}
		}else
		{
			for(int i=0; i< b; i++)
			{
				a++;
			}
		}		
		return a;
	}
	
	public int sumIntegerUsingIncrementalOperatormethod2(int a, int b)
	{
		while(a>0)
		{
			a--;
			b++;
		}
		while(a<0)
		{
			a++;
			b--;
		}
		return b;
	}

}
