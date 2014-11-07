/**
 * 
 */
package com.ctgi.google;

/**
 * @author Dany
 *
 */
public class ArrayZigZagArrangment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr={4,5,7,3,2,1};
		int[] res=new ArrayZigZagArrangment().arrangeZigZag(arr);
		for(int i :res)
		{
			System.out.print(" "+i);
		}
	}
	
	public int[] arrangeZigZag(int[] arr)
	{
		int length=arr.length;
		int temp;
		for(int i=0;i<length-1;i++)
		{
			if((i&1)>0)
			{
				if(arr[i]<arr[i+1])
				{
					temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;

				}
			}else
			{
				if(arr[i]>arr[i+1])
				{
					temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
				}
			}
		}
		
		return arr;
	}

}
