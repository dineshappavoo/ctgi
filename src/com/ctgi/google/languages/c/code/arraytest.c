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
void arrayinc(int A[], int n) ;

main() {
    
    int A[7] = {2, 7, 19, 45, 3, 42, 9} ;
    int i ;
    
    printf ("sizeof(int) = %d\n", sizeof(int)) ;
    
    printf("\nOriginal array:\n") ;
    for (i = 0 ; i < 7 ; i++) {
        printf("A[%d] = %d  ", i, A[i]) ;
    }
    printf("\n") ;
    
    arrayinc(A,7) ;
    
    printf("\nModified array:\n") ;
    for (i = 0 ; i < 7 ; i++) {
        printf("A[%d] = %d  ", i, A[i]) ;
    }
    printf("\n") ;
    
}