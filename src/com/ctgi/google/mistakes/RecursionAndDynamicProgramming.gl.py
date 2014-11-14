COMMON MISTAKES IN RECURSION AND DYNAMIC PROGRAMMING:

BASE CASE:
1. Check for all possible base cases. For example , In coin denomination or any other possible ways type problems you will handle if(n==0) return 1;
    But dont forget to handle  if(n<0) return 0;

2. If your keeping track of visited pointers then dont forget to update the visitedValues array in the base case.


RECURSIVE CALLS:
1. If there is a possibility of reaching curent position from other recursive calls then use visited pointer to keep track of each elements
    For example , in two dimensional array there could be 4 sub recursive calls from each function calls(bottom,right, top, left). In this case maintain another two dimensional arrays with [o|1] to identify the visited elements.
2. If the function return type is not void then dont forget to add the keyword 'return' on each sub recursive calls.
3.



TEST
1.

DESIGN:
1. Design an interface
2. write a class to define a deck of cards, and write shuffle function for the cards [2]

References:
1. http://steve-yegge.blogspot.com/2008/03/get-that-job-at-google.html