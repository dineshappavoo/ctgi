QUESTIONS:
1.Given a string of words, reverse each word in the string. For example "Hello world" should be "olleH dlrow" [platfora] [ReverseWordsFromString]
2.Given a string of word find the sorted list of word based on the no. of occurances of the word. For example {hello, world, the, utd, the, texas hello, the}
    in this case {hello-2, world-1, the-2, utd-1, texas-1} and the output should be {texas-1, utd-1, world-1, hello-2, the-2}. Here words with same occurances should be sorted. [platfora] [ArrangeStringsBasedOnOccurances]
3.Given three sorted arrays, merge the arrays efficiently. [platfora] []
4.Given a list of integers for example 1, 3, 9, 5, 6, 8, 5 and another integer x=4, return the closest elements index in the list to x. [Amazon] [ClosestNumbers]
5.Given a Familly tree of elements  and an element n = 2
       A
       /\
      b c     -> return def;
      / /\
     d e f
[Amazon] [TreeChildrenFromLevel]
6.Definition: 1 is a Pure number; X is a Pure number if the square of the sum of digits of X is a Pure number.
    
    Example:
        64 => (6+4)^2 = 100;
            100 => (1+0+0)^2 = 1
        Therefore, both 64 and 100 are Pure.
        
        Note that if you reach a single digit number that's NOT 1, you keep going: 7 => 7^2 = 49, etc.
        
        Returns true iff x is a Pure number. x is guaranteed to be a positive integer. [Pure Storage] [	PureNumber ]
7.Choose a random string based on the probablity of the weight associated with that. [Uber] [RandomStringWithHighProbabilityAssociated]
8.Given a list of strings group the strings based on their anagram property. For example [ "god", "baba", "man", "dog" "abba"] should be ["god", "dog","man", "baba", "abba"]
9.