/**

 * 
 */

package com.ctgi.google.problems;

import java.io.*;
import java.util.*;
/**
 * @author Dany
 *
 */

 class Pair {
	public String valString;
	public int weight;
	
	public Pair(String valString, int weight)
	{
		this.valString = valString;
		this.weight = weight;
	}
}
 
public class RandomStringWithHighProbabilityAssociated {
	Random rand = new Random();

	public String choose(List<Pair> choices) {
		int sumVal = 0;
		int val = 0;
		for(Pair pair : choices)
		{
			val = pair.weight;
			sumVal += val;
		}
		int randomNum = rand.nextInt(sumVal);
		int sum=0, index = 0;
		while(sum<randomNum)
		{
			sum = sum + choices.get(index++).weight;
		}

		Pair pairString = choices.get(Math.max(0, index-1));

		return pairString.valString;
	}

	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<String>();
		List<Pair> choices = new ArrayList<Pair>();	//= [("A", 1), ("B", 2) ("C", 1)];
		choices.add(new Pair("A", 1));
		choices.add(new Pair("B", 2));
		choices.add(new Pair("C", 1));

		System.out.println("Value : "+new RandomStringWithHighProbabilityAssociated().choose(choices));
		strings.add("Hello, World!");
		strings.add("Welcome to CoderPad.");

		for (String string : strings) {
			System.out.println(string);
		}
	}

}
