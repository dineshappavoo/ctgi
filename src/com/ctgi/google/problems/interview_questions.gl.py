ALGORITHMS:

1. Find the deepest node of a binary tree. If multiple nodes are at the deepest level, then return the rightmost node. -  [DeepestNodeInBinaryTree, CreateTreeGivenPostAndInOrder, DeepestNode]
2. Randomize an array, ensuring no items are in the same position they were in originally.
3. Arrange an array in a zig zag manner s1 < s2 > s3 < s4 ..sn [3] - [ArrayZigZagArrangment]
4. Build a multiplier
5. Given a collection of intervals, merge all overlapping intervals. - [MergeOverlappingIntervals] [Interval]
    For example,
    Given [1,3],[2,6],[8,10],[15,18],
    return [1,6],[8,10],[15,18].
    ref : http://www.programcreek.com/2012/12/leetcode-merge-intervals/
6. Implement String tokenizer in java
7. Given set of characters duplicates possible, and given dictionary (list of words). Find longest word from dictionary that can be made from given characters. How will you do it if '*' (matches one wild character) is also included? - [LonestStringInDictionary] [StringObject] (Duplicates yet to be implemented)
8. Implement a stack with find_min api as well
9. Given set of points, find line with max points on it
10. utf-8 byte stream verification and character extraction
11. Problem of segment tree
12. Given a string "aycvxfz" and a smaller string "fxa"
    Return a pointer to the location of the letter that first occurs in the bigger string from the smaller string.
13. Write code to determine if a given input string contains balanced parentheses. [BalancedParanthesisVerification]
14. Write a function with integer input which returns an integer having been flipped around in the binary sense. Example:
    Given 3, it should be turned into 0000 0011, then flipped 1100 0000, then return 64+128 = 192.
15. Find the local minima in an array. A local minima is defined as a number whose left and right indices are greater than it in     value.
    reference: http://www.glassdoor.com/Interview/Find-the-local-minima-in-an-array-A-local-minima-is-defined-as-a-number-whose-left-and-right-indices-are-greater-than-it-i-QTN_717525.htm
16. An array contains integers with the property that a particular number, called the majority element, appears more than 50% of the time. Give an algo to find this majority number
17. maximum contiguous subarray problem [2]
18. There are n points in a plane. Find the max number of points that lie on a line
19. In a given binary tree, find the number of elements that lie in a given range.
20. In order traversal of a binary tree, next element in inorder traversal
21. The one that tripped me up asked me to write code to return all words in a dictionary that can be formed from a string of    numbers (e.g. 34556), where the numbers map the same why they do on a phone
22. Given a graph as input, write a java method returning boolean true if the graph is bipartitie, else false.
23. Given a sorted matrix where the number below and right of you will always be bigger, write an algorithm to find if a particular number exist in the matrix. What is the running time of your algorithm.
24. Rotate an m*n image that is stored in an array.
25. How would I implement the autocomplete function on an iPhone or Google search?
26. No. of paths between two points in a grid
27. You and opponent alternate picking gold pots out of line. You can pick either from the left or the right. All amounts of gold in all pots are know. Write an algorithm to pick the most gold. Assume you opponent is using the same algorithm
28. Given a binary search tree of ints, and a min and a max int, find the sum of those nodes in the tree whose values fall between the min and the max. - [OWN][NodeSumBetweenMinAndMaxInBST]

                 8
                /  \
               /     \
              6      11
            /  \     /  \
           4    7    9   14

        min: 6, max : 9, 6 + 7 + 8 + 9

29. Given a 2-dimensional array of ints representing a bitmap, and an (x, y) coordinate of a “pixel” in that bitmap, find the perimeter of the region connected to that pixel that shares the same color. -[OWN] [PerimeterOfRegionConnected]
    0001
    0100
    0110
    0000  (1, 1)

    4445
    4544
    4554
    4444

    ...X
    .X..
    .XX.
    ....  (1, 1)
30. Find the maximum sum sub array in a array which positive and negative integers. - [OWN] [KadaneSubArray]
        intArr = {-8,7,9,-5,6,-2,0 }
    	Output:
        Max sum         : 17
        Max start index : 1
        Max end index   : 4


TEST
1.

DESIGN:
1. Design an interface
2. write a class to define a deck of cards, and write shuffle function for the cards [2]

References:
1. http://steve-yegge.blogspot.com/2008/03/get-that-job-at-google.html