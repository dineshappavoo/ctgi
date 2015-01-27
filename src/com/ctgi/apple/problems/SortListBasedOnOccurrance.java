/**
 * 
 */
package com.ctgi.apple.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

import com.amazon.challenge.AmazonChallenge.Product;

/**
 * @author Dany
 *
 *There are several words in a file. Get the occurrence of every word and sort it based on the 
 *occurrence, if more than one word is having same occurrence than sort it alphabetically.
 *
 *ALGORITHM:
 * 1. Get the input list
 * 2. Put it in a hashmap and update the count as value in the map
 * 3. Sort the 
 * 3. Iterate through the hashmap and then add the element to the maxHeap
 *
 *
 */
public class SortListBasedOnOccurrance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}	

	class WordObj{
		String word;
		int count;
		public WordObj(String word, int count)
		{
			this.word = word;
			this.count = count;
		}
	}

	public PriorityQueue<WordObj> implementMaxHeap()
	{
		PriorityQueue<WordObj> pq = new PriorityQueue<WordObj>(11, new Comparator<WordObj>() {
			public int compare(WordObj o1, WordObj o2)
			{
				int p1=o1.count;
				int p2=o2.count;
				return (p2-p1); 
			}
		});
		return pq;
	}
	
	public ArrayList<ArrayList<String>> getSortedWordList(ArrayList<String> wordList)
	{
		ArrayList<ArrayList<String>> resList = new ArrayList<ArrayList<String>>();
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
		
		HashMap<Integer, ArrayList<String>> valueWordMap = new HashMap<Integer, ArrayList<String>>();
		
		for(String word : wordList)
		{
			if(wordMap.containsKey(word))
			{
				wordMap.put(word, wordMap.get(word)+1);
			}else
			{
				wordMap.put(word, 1);
			}
		}
		
		for(String word : wordMap.keySet())
		{
			int count  = wordMap.get(word);
			if(valueWordMap.containsKey(count))
			{
				valueWordMap.get(count).add(word);
			}else
			{
				ArrayList<String> wList = new ArrayList<String>();
				wList.add(word);
				valueWordMap.put(count, wList);
			}
		}
		
		for(int count : valueWordMap.keySet())
		{
			ArrayList<String> words = valueWordMap.get(count);
			
		}
		PriorityQueue<WordObj> maxHeap = implementMaxHeap();
		for(String word : wordMap.keySet())
		{
			int count = wordMap.get(word);
			maxHeap.add(new WordObj(word, count));
		}
		
		
		return resList;
	}



}
