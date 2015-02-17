//
//  arraytest.c
//  arraytest
//
//  Created by Dinesh Appavoo on 1/29/15.
//  Copyright (c) 2015 Dinesh Appavoo. All rights reserved.
//
// File: arraytest.c
//
// C program to test arrayinc.asm
//
#include<stdio.h>

int main() {
    
    
    //Testing segmentation fault
    /**
     *A pointer which holds memory address of a memory which is already freed is known as a dangling pointer. You cannot figure out whether a given pointer is dangling or not until you use it. When a dangling pointer is used, usually a segmentation fault is observed.
     
     In the code above, we have malloc'd 3 bytes on heap and stored the address of first byte in a pointer 'p'. Next we initialized these three bytes. Next we freed this memory and after that we are trying to use this memory again. Well this is not permitted as once a memory is freed, it no longer belongs to our process. Though, if you run the below code, it may not give a segmentation fault immediately as free() returns the memory to heap and now its up to the implementation of heap to take it back to its pool. Once its taken back to heap by kernel then the code above will start giving segmentation faults.
     *
     **/
    char *p = (char*)malloc(3);
    *p='a';
    *(p+1) = 'b';
    *(p+2) = 'c';
    free(p);
    *p='a';
    *(p+1)='d';
    
    
    
    //1.Access a memory pointer which is not allocated with any value
    char *str1="Dines";
    //char *str2;
    char *str2=(char *)malloc(6*sizeof(char));
    strcpy(str2,str1);
    printf("%s\n",str2);
    
    //2.Assigning value way out of address limit
    char *mem= (char *)malloc(6*sizeof(char));
    long int i=0;
    for( i=0;i<1000000000;i++)
    {
        mem[i]='p';
    }
    for( i=0;i<1000000000;i++)
    {
        printf("%c ",mem[i]);
    }
    
    
    //3.Try to access the memory of lower region which is dedicated to OS
    char *point = (char*)0100;
    *point='e';
    printf("%c\n",point);
    
    //4.Try to get input into a grabage address
    int num;
    printf("Num value %u\n ",&num);
    printf("Enter a number ");
    scanf("%d",num);
    
    
    //Accessing pointers
    int var =10;
    int *pointer;
    pointer=&var;
    printf("Address : %u\n value : %d\n",pointer, *pointer);
    
    return 0;
    
}