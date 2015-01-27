/**
 * 
 */
package com.ctgi.apple.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.CountDownLatch;


/**
 * @author Dany
 *
 *There are several words in a file. Get the occurrence of every word and sort it based on the 
 *occurrence, if more than one word is having same occurrence than sort it alphabetically.
 *
 *ALGORITHM:
 * 1. Get the input list
 * 2. Put it in a hashmap and update the word occurrence count as value in the map
 * 3. Iterate through the hash map and add word and count to the max heap which is implemented based on count priority
 * 3. Iterate through the max heap and sort the words which has same occurrence count. 
 * 	  Then add the words to result list.
 * 4. return the result list
 *
 */
public class SortListBasedOnOccurrance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> wordList = new ArrayList<String>();
		wordList.add("Dinesh");
		wordList.add("Poornesh");
		wordList.add("Rahul");
		wordList.add("Dinesh");
		wordList.add("Moezhi");
		wordList.add("Rahul");
		ArrayList<String> res = new SortListBasedOnOccurrance().getSortedWordList(wordList);
		for(String word : res)
		{
			System.out.println(word);
		}
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
	
	public ArrayList<String> getSortedWordList(ArrayList<String> wordList)
	{
		ArrayList<String> resultList = new ArrayList<String>();
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
		
		//HashMap<Integer, ArrayList<String>> valueWordMap = new HashMap<Integer, ArrayList<String>>();
		
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
		PriorityQueue<WordObj> maxHeap = implementMaxHeap();
		for(String word : wordMap.keySet())
		{
			int count = wordMap.get(word);
			maxHeap.add(new WordObj(word, count));
		}
		
		int lastCountValue =0;
		ArrayList<String> wordArrList = new ArrayList<String>();
		WordObj firstWord = maxHeap.poll();
		wordArrList.add(firstWord.word);
		lastCountValue = firstWord.count;
		
		while(!maxHeap.isEmpty())
		{
			WordObj wObj = maxHeap.poll();
			if(wObj.count==lastCountValue)
			{
				wordArrList.add(wObj.word);
				lastCountValue = wObj.count;
			}else
			{
				Collections.sort(wordArrList);
				resultList.addAll(wordArrList);
				wordArrList = new ArrayList<String>();
				wordArrList.add(wObj.word);
				lastCountValue = wObj.count;
			}
		}
		Collections.sort(wordArrList);
		resultList.addAll(wordArrList);		
		
		return resultList;
	}
}





/*		for(String word : wordMap.keySet())
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
	
}*/
