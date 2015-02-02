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
#include<stdlib.h>
#include<pthread.h>

void *foo(void *targ)
{
    int tID;// = (int*) targ;
    tID=*((int*) targ);
    printf("%d\n",tID);
    return NULL;
}

void mergeSort(int *arr, int low, int high)
{
    if(low<high)
    {
        int mid = (low + high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }
}

int* merge(int *arr, int low, int mid, int high)
{
    int size = (int) sizeof(arr)/sizeof(int);
    printf("Array Size %d\n",size);

    int *auxArr = malloc(sizeof(int) * size);
    for(int i=0;i<size;i++)
    {
        auxArr[i] = arr[i];
    }
    
    int current = low;
    int right = mid+1;
    int left = low;
    while((left<=mid)&&(right<high))
    {
        if(auxArr[left]<=auxArr[right])
        {
            arr[current++] = auxArr[left++];
        }else
        {
            arr[current++] = auxArr[right++];
        }
    }
    int remaining = mid-left;
    for(int j=0;j<=remaining;j++)
    {
        arr[left++] = auxArr[j];
    }
    return arr;
}

int main() {
    int tId1 = 1;
    int tId2 = 2;
    int tId[] = {1,2};
    pthread_t pt[2];
    
    for(int i=0;i<2;i++)
    {
        pthread_create(&pt[i], NULL, foo, (void*) &tId[i] );
        pthread_join(pt[i], NULL);
    }
    
    int size = (int)(sizeof(pt))/(int)sizeof(pthread_t);
    printf("size of Array is %d\n",size);
    return 0;
}

