//
//  bitmanipulation.c
//  bitmanipulation
//
//  Created by Dinesh Appavoo on 1/31/15.
//  Copyright (c) 2015 Dinesh Appavoo. All rights reserved.
//
//QUESTION:bit manipulation questions like, write a macro to check if nth bit was set , write a function to count no of 1's in a variable and what was the complexity of the implementation etc.

#include<stdio.h>
#include<stdbool.h>

# define isNthBitSet(num, i)  (num & (1<<i))>0
# define countNoOfOnes(num) ({int count=0;  while(num>0) { if((num&1)>0)   {\
        count++;\
    }\
    num = num>>1;\
}\
count;\
})
int main() {
    
    int a=7;
    int i=2;
    printf("Is Nth bit set %d\n",isNthBitSet(a,i));
    printf("No of Bits set %d\n",countNoOfOnes(a));
    return 0;
}
