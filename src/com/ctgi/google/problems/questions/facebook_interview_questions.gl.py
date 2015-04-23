Facebook
========
1.Given an array such that every next element differs from the previous by +/- 1. (i.e. a[i+1] = a[i] +/-1 ) Find the local max OR min in O(1) time. The interviewer mentioned one more condition that the min or max should be non-edge elements of the array 
	Example: 1 2 3 4 5 4 3 2 1 -> Local max is 5 
	1 2 3 4 5 -> No local max or min exists 
	5 4 3 2 1 -> No local max or min exists
2.write a function that calculates the minimum number of meeting rooms that can accommodate given schedules 
	input: same 
	output: # of rooms 
	Also back to back events are allowed e.g. {2,5} {5,9} correct o/p:1   [com.ctgi.google.problems.ActivitySelection][com.ctgi.google.problems.ActivityTime]
3.write a function that detects conflicts in given meeting schedules 
	input: a list of intervals, [(s1, e1), (s2, e2), ] 
	output: return True if there's any conflict, False otherwise [com.ctgi.google.problems.ConflictInMeetingSchedules][com.ctgi.google.problems.ActivityTime]
4.There are 3 romms in which party is going on lets say room A, B, C. Guests are coming one by one and you have to tell the guest which room to enter. At any point of time each room has to maintain a percentage Lets say the percentage that each room has to maintain is 
	A- 20% , B-30% , C- 50%. You can maintain total count of each room and keep on adding count to respective room as the new guest enters each room. How would you go about it. What formula would you use.  Give a generalise formula so that it works if no. of rooms increase.
5.You are given a 2d rectangular array of positive integers representing the height map of a continent. The "Pacific ocean" touches the left and top edges of the array and the "Atlantic ocean" touches the right and bottom edges. 
- Find the "continental divide". That is, the list of grid points where water can flow either to the Pacific or the Atlantic. Water can only flow from a cell to another one with height equal or lower. 
	Example: 

	Pacific ~ ~ ~ ~ ~ |__ 
	~ 1 2 2 3 (5) ~ 
	~ 3 2 3 (4)(4) ~ 
	~ 2 4 (5) 3 1 ~ 
	~ (6)(7) 1 4 5 ~ 
	__ (5) 1 1 2 4 ~ 
	|~ ~ ~ ~ ~ Atlantic 

	The answer would be the list containing the coordinates of all circled cells: 
	[(4,0), (3,1), (4,1), (2,2), (0,3), (1,3), (0,4)]
6.Implement stairs(N) that (collect the solutions in a list) prints all the ways to climb up a N-step-stairs where one can either take a single step or double step. 
	We'll use 1 to represent a single step, and 2 to represent a double step. 
	stairs(3) 
	111 
	12 
	21   [com.ctgi.google.problems.WaysToClimbNStepStairs]
7.A robot has to move in a grid which is in the form of a matrix. It can go to 
	1.) A(i,j)--> A(i+j,j) (Down) 
	2.) A(i,j)--> A(i,i+j) (Right) 

	Given it starts at (1,1) and it has to go to A(m,n), find the minimum number of STEPS it has to take to get to (m,n) and write 
	public static int minSteps(int m,int n)   [com.ctgi.google.problems.MinimumStepsForRobotMovement]

	For instance to go from (1,1) to m=3 and n=2 it has to take (1, 1) -> (1, 2) -> (3, 2) i.e. 2 steps
8.Given an m x n matrix where each row element is sorted, but the columns do not appear in sorted order, write a function to print each matrix element in sorted order. 
	Example matrix: 
	matrix = [ 
	[20, 40, 80], 
	[5, 60, 90], 
	[45, 50, 55] 
	] 
	
	Your function should print 5, 20, 40, 45, 50, 55, 60, 80, 90. 
	
	Add on: Assume that we are space-constrained such that we can only hold one row in memory at a time. Optimize your function to work under such constraints as efficiently as possible.
9.Question: Given a sequence of positive integers A and an integer T, return whether there is a continuous sequence of A that sums up to exactly T 
	Example 
	[23, 5, 4, 7, 2, 11], 20. Return True because 7 + 2 + 11 = 20 
	[1, 3, 5, 23, 2], 8. Return True because 3 + 5 = 8 
	[1, 3, 5, 23, 2], 7 Return False because no sequence in this array adds up to 7
10.Given a string containing letter, digit, and other characters, write a function to check palindrome for only letter and digit. The implementation need to be in-place, no extra memory is allowed to create another string or array. 
	For example: 
	
	"ABA" is palindrome 
	"A!#A" is palindrome 
	"A man, a plan, a canal, Panama!" is palindrome
11.Write a program that reverses a linked list without using more than O(1) storage.
12.Write a program that answers YES/NO search queries containing * placeholders. Example: if the data you have is (hazem, ahmed, moustafa, fizo), then you should answer as follows for: 
	ahmed : YES
	m**stafa :YES
	fizoo : NO
	fizd : NO
	***** : YES
	**** : YES
	** : NO
	Your program should be able to answer each query in O(1) time
13.Input: A string equation that contains numbers, '+' and '*' 
	Output: Result as int. 
	
	For example: 
	Input: 3*5+8 (as String) 
	Output: 23 (as int)
14.Given a class Range
	class Range {
		public int begin;
		public int end;
		public Range(int begin, int end) {
			this.begin = begin;
			this.end = end;
		}
	}
	The problem: 
	Intput: 
	1) list of Ranges that don't overlap (not sorted) 
	2) newRange that might overlap. 
	Output: 
	list of merged Ranges 
	
	For example: 
	Input: [1..5] [9..13] [17..22] 
	newRange: [4..10] 
	Output: [1..13] [17..22]
15.Convert a binary tree into a In Order traversal circular list re-purposing the node's pointers Left & Right as Previous and Next respectively. 

	Hint: A single node Left & Right points to itself. 
	
	Note: This is not a binary search tree.
16.You are given a set of unique characters and a string. Find the smallest substring of the string containing all the characters in the set. 
	ex: 
	Set : [a, b, c] 
	String : "abbcbcba" 
	
	Result: "cba"
17.First they did ask to find pattern of this
	'this is a test sentence' => [t, h, i, s, i, s, a, t, e, s, t, s, e, n, t, e, n, c, e]
	'thiis iss a teest seentennce' => [i, s, e, e, n]
	'thiiis iss aa teeest seentennnce' => [i, e, n]
	'thiiiis iss a teeest seeentennncccce' => [i, c]
	after i have to do body of function 
	
	getLongestConsecutiveChar
18.1.) Given an array, find the maximum difference between two array elements given the second element comes after the first. 
	For example. 
	array = [1,2,3,4,5,6,7]
	We can take the difference between 2 and 1 (2-1), but not the different between 1 and 2 (1-2).
	This question is super easy, I solved it within minutes of getting of the phone. I came up with an O(n^2) solution over the phone. My improved solution was O(n).
19.You are at latest version of committed code.  assume one branch of code. Code version is in sorted order. It is corrupted with bug. You have fun isBug(VerNumber) which returns True or False. Find the version in which bug was introduced?

	This can be solved with linearly checking each version or modified binary search. Person asked to write test cases? This is where i struggled. how do you write test case for this question? Do you guys use framework syntax or something else?
20.Inplace reverse a sentence. You given a sentence of english words and spaces between them. 
	Nothing crazy: 
	1) no double spaces 
	2) no empty words 
	3) no spaces at the ends of a sentence
	
	
	void inplace_reverse(char* arr, int length) {
	    // your solution
	}
	Example: 
	input "I wish you a merry Christmas" 
	output "Christmas merry a you wish I" 
	
	Constrains: O(1) additional memory
21.The closest common ancestor in a tree forest.
	class Node {
	    Node* parent; // == null for root of tree
	    Node* left;
	    Node* right;
	}
	
	Node* tree_forest[]; // array of pointers which points to roots of each tree respectively
	
	Node* closest_common_ancestor(Node* n1, Node* n2) {
	    // your solution
	}
	Example:
	
	
	|    a     |   j
	|   / \    |  /
	|  b   c   | h
	| /   / \  |
	|d   e   f |
	for e and d CCA is a 
	for e and f CCA is c 
	for e and c CCA is c 
	for h and d CCA is null 
	
	Constrains: O(1) additional memory
22.Design a URL system. He even wanted to know what kind of algorithm to use, improve the speed, availability etc.
23.Given a 4 X 4 game slot that has random alphabets in all the slots. Write a function that takes the keyboard and the word as input and returns true if the word can be formed 
	False otherwise. A word can be formed on the board by connecting alphabets adjacent to each other (horizontal, vertical and diagonally) 
	Same alphabet should not be reused.
24.Given a set of n people, find the celebrity. 
	Celebrity is a person who: 
	1. Knows only himself and no one else 
	2. Every one else knows this person 
	
	You are given the following helper function: 
	bool knows(i, j); 
	Returns: 
	True: If i knows j 
	False: otherwise 
	
	I proposed the O(n2) algorithm at first but he wanted me to improve on it. He wanted an O(n) algorithm
25.You have a list of words with ranking. Now you need to create a function that will take this list as input and provide a way so that a T9 keyboard can provide three top results of probable words based on rankings for the numbers punched in.
26.Tree to List: convert a binary tree to a circular doubly-linked list
27.roll two dice, what is the probability of rolling no sixes?
28.Given an array of integers, return true if there're 3 numbers adding up to zero (repetitions are allowed) 
	{10, -2, -1, 3} -> true 
	{10, -2, 1} -> true -2 + 1 +1 =0
29.Find the maximum number of non-intersecting events in a calendar.
30.Write a function to print the rows of a binary tree, terminating each row with a carriage return
31.Given a Tree:
	  A
	  /\ 
	 B  C
	 /\  /\
	D E    F G
	Write a function that prints: 
	A 
	BC 
	DEFG
32.Given an array of ages (integers) sorted lowest to highest, output the number of occurrences for each age. 
	For instance: 
	[8,8,8,9,9,11,15,16,16,16] 
	should output something like: 
	8: 3 
	9: 2 
	11: 1 
	15: 1 
	16: 3 
	
	This should be done in less than O(n).
33.Print a BST such that it looks like a tree (with new lines and indentation, the way we see it in algorithms books).
34.Write a function that takes the following inputs and gives the following outputs. 
	Input: A list of points in 2-dimensional space, and an integer k 
	Output: The k input points closest to (5, 5), using Euclidean distance 	
	
	Example: 	
	Input: {(-2, -4), (0, 0), (10, 15), (5, 6), (7, 8), (-10, -30)}, k = 2 
	Output: {(5, 6), (7, 8)}
35.An efficient way to sort patient files in an array of just 3 types 'High-importance', 'Mid-importance', 'Low-importance' which are in an arbitrary order (unsorted). 

	The output preference should start with the highest. 
	1. High-importance 
	2. Mid-importance 
	3. Low-importance 
	
	[high,low,low,med,high,low] 
	ps: I was told to take advantage of the fact that they are just only 3 types.
36.There is a list of rectangles and a list of points in a 2d space. Note that the edge of each rectangle are aligned to XY axis. question is how to find rectangles with point or points inside
37.Given a list of strings, return a list of lists of strings that groups all anagrams. 
	Ex. given {trees, bike, cars, steer, arcs} 
	return { {cars, arcs}, {bike}, {trees, steer} } 
	
	m = # of words 
	n = length of longest word 
	
	I solved this in O(m * n * log n) time.
38.Array of size (n-m) with numbers from 1..n with m of them missing. Find one all of the missing numbers in O(log). Array is sorted. 
	Example: 
	n = 8 
	arr = [1,2,4,5,6,8] 
	m=2 
	Result has to be a set {3, 7}.
39.You are given an array of non-negative integers (0, 1, 2 etc). The value in each element represents the number of hops you may take to the next destination. Write a function that determines when you start from the first element whether you will be able to reach the last element of the array. 
	if a value is 3, you can take either 0, 1, 2 or 3 hops. 
	For eg: for the array with elements 1, 2, 0, 1, 0, 1, any route you take from the first element, you will not be able to reach the last element.
40.Given an array of integers. Move all non-zero elements to the left of all zero elements.
41.There's a new language which uses the latin alphabet. However, you don't know the order among letters. 
	It could be: 
	a b c d ... 	
	as it could also be: 
	
	b e z a m i ...	
	You receive a list of words lexicographically sorted by the rules of this new language. From this list, derive one valid particular ordering of letters in this language.
42.Write a program to find pattern. 
	0: 1 
	1: 11 
	2: 21 
	3: 1211 
	4: 111221 
	5: 312211 
	Iterate over the previous number, and find count for same number number. Append that count before number. 
	e.g., 
	public String pattern(int input){} 
	
	If input = 4, function should return 111221.
43.Let's say there is a double square number X, which can be expressed as the sum of two perfect squares, for example, 10 is double square because 10 = 3^2 + 1^2 .Determine the number of ways which it can be written as the sum of two squares
44.write an algorithm to decide weather a string is a palindrome. Ignore any non-letter characters in the the string. 
	Ignore capital/lower case. 
	Space complexity O(1) 
	
	for example, the following should return true: 
	A man, a plan, a canal -- Panama! [DUPLICATE + 1]
45.	Suppose we have array of N numbers. We will define N functions on this array. Each function will return the sum of all numbers in the array from Li to Ri ( Li is left index, Ri is right index). Now we have 2 types of queries: 

	Type1: 1 x y Change the xth element of the array to y 
	Type2: 2 l r Return the sum of all functions from m to n. 
	
	Input type: 
	First Line is the size of the array i.e. N 
	
	Next Line contains N space separated numbers Ai denoting the array 
	
	Next N line follows denoting Li and Ri for each functions. 
	
	Next Line contains an integer Q , number of queries to follow. 
	
	Next Q line follows , each line containing a query of Type 1 or Type 2 
	
	Here is an example: 
	Input: 
	5 
	1 2 3 4 5 
	1 2 
	3 4 
	1 4 
	1 5 
	3 5 
	5 
	1 1 5 
	2 2 4 
	2 1 3 
	1 4 5 
	2 1 5 
	
	Output: 
	40 
	28 
	63 
	
	Explanation: 
	Function 1 is sum of values from index 1 to index 2 = 1+2=3 
	So , F1=3 
	Similarly, F2=3+4=7 
	F3=1+2+3+4=10 
	F4=15 
	F5=12 
	
	Now when I query 1 1 5 
	means it is type 1 query, so we replace value at index 1 by 5. 
	So our new array is, 
	5 2 3 4 5 
	and 
	F1=7 
	F2=7(unchanged) 
	F3=14 
	F4=19 
	F5=12(unchanged) 
	
	Then next query is 2 2 4 
	means give sum of all functions from index 2 to 4. 
	So, ans= 7+14+19 =40 (output 1) 
	
	Similarly are other 2 outputs. 
	Index are 1 based in example. 
	Comment me if you are not clear with question. 
	
	Edit: I know one can do it with naive approach or using segment tree. But they wanted more faster way to do it.
46.Suppose we are given a set L of n line segments in the plane, where the endpoints of each segment lie on the unit circle x^2 + y^2 = 1, and all 2n endpoints are distinct. Describe 
	and analyze an algorithm to compute the largest subset of L in which no pair of segments intersects.
47.Given two strings, return boolean True/False, if they are only one edit apart.Edit can be insert/delete/update of only one character in the string. Eg: 
	-True 
	xyz,xz 
	xyz, xyk 
	xy, xyz 
	
	
	-False 
	xyz, xyz 
	xyz,xzy 
	x, xyz
48.You're given a dictionary of strings, and a key. Check if the key is composed of an arbitrary number of concatenations of strings from the dictionary. For example: 

	dictionary: "world", "hello", "super", "hell" 
	key: "helloworld" --> return true 
	key: "superman" --> return false 
	key: "hellohello" --> return true
49.Having a home-defined linked list with the following structure, where the next will point to the next node in the list and the random will point to a random node in the list (not null). 
Create a copy of the structure (the data field in each node is not unique for different nodes): 
	/* 
	Example: 
	Having the list: 
	1 -> 2 -> 3 -> X 
	With random pointers to: 
	1: 3 
	2: 2 
	3: 1 
	
	Create the list: 
	1' -> 2' -> 3' -> X 
	1': 3' 
	2': 2' 
	3': 1' 
	*/ 
	
	class Node { 
	int data; 
	Node next; 
	Node random; 
	}
50.You're given an array of integers(eg [3,4,7,1,2,9,8]) Find the index of values that satisfy A+B = C + D, where A,B,C & D are integers values in the array. 

	Eg: Given [3,4,7,1,2,9,8] array 
	The following 
	3+7 = 1+ 9 satisfies A+B=C+D 
	so print (0,2,3,5)
51.(To write in Objective-C; I will write the EXACT question). Given a dictionary of words, return an array of the words whose match. (i.e. pattern "c.t" match with "cat", "cut", etc. because the dot notation stand for ANY character). 
	SUGGEST: use suffix tree, for(for()) is not a good solution.
52.Given an array of positive integers that represents possible points a team could score in an individual play. Now there are two teams play against each other. Their final scores are S and S'. How would you compute the maximum number of times the team that leads could have changed? 
	For example, if S=10 and S'=6. The lead could have changed 4 times: 
	Team 1 scores 2, then Team 2 scores 3 (lead change); 
	Team 1 scores 2 (lead change), Team 2 score 0 (no lead change); 
	Team 1 scores 0, Team 2 scores 3 (lead change); 
	Team 1 scores 3, Team 2 scores 0 (lead change); 
	Team 1 scores 3, Team 2 scores 0 (no lead change).
53.Given a mapping of alphabets to integers as follows: 
	1 = A 
	2 = B 
	3 = C 
	... 
	26 = Z 
	
	Given any combination of the mapping numbers as string, return the number of ways in which the input string can be split into sub-strings and represented as character strings. For e.g. given 
	"111" -> "AAA", "AK", "KA" -> 3 
	Valid combinations are ({1,1,1}, {1,11},{11,1}) = 3 
	"11" -> "AA", "K" -> 2 
	Valid combinations are ({1,1},{11}) = 2 
	"123" -> "ABC", "LC", "AW" -> 3 
	Valid combinations are ({1,2,3},{1,23},{12,3}) = 3 
	
	You don't have to return all the mappings, only the number of valid mappings.
54.Find the maximum depth of binary tree? Once I wrote the code for this, interviewer asked me next question.
55.Given a function 
	getRandomTripplet() 
	
	which returns a random triplet of letters from a string. You don't know the string using calls to this function you have to correctly guess the string. the length of the string is also given. 
	
	Lets say the string is helloworld the function getRandomTriplet will return things like 
	
	hlo 
	hew 
	wld 
	owo 
	
	the function maintains the relative order of the letters. so it will never return	
	ohl since h is before o in the string. 
	owe since w is after e 	
	The string is not known you are only given length of the string.
56.












	










Design
======
1.How would you architect a world-wide video distribution system? Or Facebook chat?







	
	
Behavioral
==========
1. Why Facebook? 
2. cultural fit questions etc. They asked simple question.
2. What is the challenging project you have done so far? 
3. What were the challenges? 
4. What technologies did you use? 
5. What did you learn?

