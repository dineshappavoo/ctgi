QUESTIONS:
1.Given a string of words, reverse each word in the string. For example "Hello world" should be "olleH dlrow" [platfora] [com.ctgi.google.problems.ReverseWordsFromString]
2.Given a string of word find the sorted list of word based on the no. of occurances of the word. For example {hello, world, the, utd, the, texas hello, the}
    in this case {hello-2, world-1, the-2, utd-1, texas-1} and the output should be {texas-1, utd-1, world-1, hello-2, the-2}. Here words with same occurances should be sorted. [platfora] [com.ctgi.google.problems.ArrangeStringsBasedOnOccurances]
3.Given three sorted arrays, merge the arrays efficiently. [platfora] [com.ctgi.google.problems.MergeKSortedArrays]
4.Given a list of integers for example 1, 3, 9, 5, 6, 8, 5 and another integer x=4, return the closest elements index in the list to x. [Amazon] [com.ctgi.google.problems.ClosestNumbers]
5.Given a Familly tree of elements  and an element n = 2
       A
       /\
      b c     -> return def;
      / /\
     d e f
[Amazon] [com.ctgi.google.problems.TreeChildrenFromLevel]
6.Definition: 1 is a Pure number; X is a Pure number if the square of the sum of digits of X is a Pure number.
    
    Example:
        64 => (6+4)^2 = 100;
            100 => (1+0+0)^2 = 1
        Therefore, both 64 and 100 are Pure.
        
        Note that if you reach a single digit number that's NOT 1, you keep going: 7 => 7^2 = 49, etc.
        
        Returns true iff x is a Pure number. x is guaranteed to be a positive integer. [Pure Storage] [	com.ctgi.google.problems.PureNumber ]
7.Choose a random string based on the probablity of the weight associated with that. [Uber] [RandomStringWithHighProbabilityAssociated]
8.Given a list of strings group the strings based on their anagram property. For example [ "god", "baba", "man", "dog" "abba"] should be ["god", "dog","man", "baba", "abba"] [Yelp] [com.ctgi.google.problems.GroupStringsByAnagrams]
9.Each software engineer at Symantec has a skill ranking from 1 to 10 and a group of software engineer friends (also Symantec employees who each also have a skill ranking from 1 to 10). You want to find which employee has the highest combined skill level at Symantec (their own plus all his co-worker friends).
    Provide an implementation of the above using Java. A driver class or a unit test should be provided which builds a list of employees with various skill levels, their friends, and the employee with the highest combined skill level.
    Example:
        Jack (4 skill level) and friends with Jane.
        Jane (1 skill level) and friends with Jack and Tina.
        Tina (7 skill level) and friends with Jane.
        Bob (10 skill level) and has no friends

        Jack has a total points of 4 + 1 = 5
        Jane has total points of 1 + 4 + 7 = 12
        Tina has total points of 7 + 1 = 8
        Bob has total points of 10

    So Jane is the superstar software engineer! [Symantec] [com.ctgi.google.problems.EmployeeNodeSkillAndAdjacentNodeSkill]
10.Given a string, find out the first non repeating character in the string? [Amazon]
11.Implement 2 stacks using an array in java? [Amazon]
12.Implement a distributed cache or LRU cache ? [Amazon]
13.Given a string and a set of strings find out whether the strings from set are prefix of the original string? For example "caterpiller" is the given string and set of strings are [cat, cater, piller] and the results should be [cat, cater] because both are the prefix of "caterpiller" [Amazon]
14.Find the second smallest element from the array? [Goldman sachs][com.ctgi.google.problems.SecondMinimumFromTheArray]
15.Given an integer x how do you find x is a power of 10? [Goldman sachs][com.ctgi.google.problems.NumberPowerOfTen]
16.Given a binary tree find whether the tree is a BST? [AMazon] []
17.Describe a datastructure to find the minimum element in O(1) time ? [Amazon]
18.Given a string s, find two max no. of occurances of characters and determine the numbers are equal or not? For example 'aaabbbcc' returns false because last two max are equal. aababbccccb gives true because max is c->4  [Amazon]
19.Serialize and Deserialize a Binary Tree. Serialization is to store tree in a file so that it can be later restored. The structure of tree must be maintained. Deserialization is reading tree back from file. [Amazon]
20.Given n elements in an array.Find the n th largest from an array using minheap or array ? [BNSF Railways] []
