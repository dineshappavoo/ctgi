/**
 * 
 */
package com.ctgi.google.problems;

/**
 * @author Dany
 *
 *Where do you see yourself five years from now?

"In five years I hope to be working with an employer in an increasingly responsible position, that enables me to utilize my talents and work closely with my colleagues in solving important problems. I see myself taking on new and exciting challenges in an enjoyable environment and hopefully this will be with your company."



What type of decisions do you have difficulty making?
"I sometimes have difficulty choosing between two equally good ideas." or "I used to have difficulty saying 'no' to people until I learned to better set priorities."
 *
 *
 *
 */
public class NvidiaYelp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	INPUT: 1->2->3->4->5
	OUTPUT: 1->2->4->5


	public Node deleteNode(Node node)
	{

	    
	    if(node==null)
	        return null; 
	    
	    if(node.next==null)
	        return null;
	   node.data = node.next.data;
	   node.next = node.next.next;
	   return node;

	}

	INPUT: [a1, a2, a3,...an, b1, b2, b3,...bn]
	OUTPUT: [a1, b1, a2, b2,............an, bn]


	Size: 2n

	1 2 3 4 5 6 7 8
	1 5 2 6 3 7 4 8

	INPUT a1 a2 a3 b1 b2 b3
	OUTPUT a1 a2 b1 a3 b2 b3, a1 b1 a2 b2 a3 b3


	    a1 =0
	    b1 =3
	    last =5
	    (2*b1's)%last
	    (2*3)%5 =1
	    
	public void swapArrayElements(int[] arr)
	{
	    int length = arr.length;
	    if(lenght == 0)
	        return;
	        
	    if(length == 2)
	        return;
	        
	        N=lastIndex
	        int count =0, val=1, temp=arr[1];
	        
	        while(count<N-1)
	        {
	            swap(temp, arr[(2*i)%N]);
	            i= (2*i)%N;
	            count++;
	        }
	        
	        
	    
	    
	    
	        
	}


	import java.io.*;
	import java.util.*;

	/*
	 * To execute Java, please define "static void main" on a class
	 * named Solution.
	 *
	 * If you need more classes, simply define them inline.
	 */

	class Solution {
	  public static void main(String[] args) {
	    ArrayList<String> strings = new ArrayList<String>();
	    //strings.add("Hello, World!");
	    //strings.add("Welcome to CoderPad.");
	    //strings.add("This pad is running Java 8.");

	    strings.add("star");
	    strings.add("astr");
	    strings.add("car");
	    strings.add("rac");
	    strings.add("st");

	    new Solution().groupAnagrams(strings);


	  }
	  
	      
	    void groupAnagrams(ArrayList<String> inList)
	      {
	      if(inList == null)
	        return;
	      int size = inList.size();
	      if(size == 0)
	        return;
	      
	      HashMap<String, ArrayList<String>> anagramMap = new HashMap<String, ArrayList<String>>();
	      
	      String key="";
	      ArrayList<String> valList;
	      
	      for(String str : inList)
	        {
	          key = sortString(str);
	          if(anagramMap.containsKey(key))
	            {
	            valList = anagramMap.get(key);
	            valList.add(str);
	            anagramMap.put(key, valList);
	          }else
	            {
	            valList = new ArrayList<String>();
	            valList.add(str);
	            anagramMap.put(key,valList);
	          }
	      }
	      
	      for(String keyStr : anagramMap.keySet())
	        {
	          ArrayList<String> values = anagramMap.get(keyStr);
	        for(String str : values)
	          {
	                  System.out.println(str);
	        }
	      }
	    }
	    
	    public String sortString(String str)
	      {
	      if(str==null)
	        return null;
	      int length = str.length();
	      char[] cArr = str.toCharArray();
	      Arrays.sort(cArr);
	      return cArr.toString();
	    }
	}


	/* 
	Your previous Python content is preserved below:

	#
	#input: [star, astr, car, rac, st]
	#output: [[star, astr], [car, rac], [st]]
	#


	def say_hello():
	    print 'Hello, World'

	for i in xrange(5):
	    say_hello()

	 */



}
