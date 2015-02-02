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

void mergeSort(int*, int, int);
void merge(int*, int, int, int);

#define SIZE 8
int arr[SIZE];
int auxArr[SIZE];

int NUM_OF_THREADS;

struct threadArgs
{
    int threadId;
    int low;
    int high;
};

void *foo(void *targ)
{
    int tID;// = (int*) targ;
    tID=*((int*) targ);
    printf("%d\n",tID);
    return NULL;
}


void merge(int *arr, int low, int mid, int high)
{
    
    for(int i=low;i<=high;i++)
    {
        auxArr[i] = arr[i];
    }
    int current = low;
    int right = mid+1;
    int left = low;
    while((left<=mid)&&(right<=high))
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
        arr[current+j] = auxArr[left+j];
    }
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

void *mergeSortThreadFunc(void *tArgs)
{
    int low = ((struct threadArgs*) tArgs)->low;
    int high = ((struct threadArgs*) tArgs)->high;
    mergeSort(arr, low, high);
    
    return NULL;
}

int main() {
    
    
    for(int i=0;i<SIZE;i++)
    {
        arr[i] = SIZE-i;
    }
    
    printf("Test call 4\n");

    for(int i=0;i<SIZE;i++)
    {
        printf("%d\t",arr[i]);
    }
    printf("Test call 3\n");

    
    printf("\n");
    //mergeSort(arr,0, SIZE-1);


    
    //Merge sort through multithreading
    int low=0;
    int high=0;
    int mid=0;

    printf("Test call 2\n");

    high = SIZE - 1;

    mid = (low+high)/2;

    NUM_OF_THREADS = 2;

    struct threadArgs** tArgs;
    tArgs = (struct threadArgs**) malloc(NUM_OF_THREADS * sizeof(struct threadArgs*));

    printf("Test call 1");

    /*
    for(int i=0;i<NUM_OF_THREADS;i++)
    {
        tArgs[i] = (struct threadArgs*) malloc(sizeof(struct threadArgs));
        tArgs[i]->threadId = i;
        tArgs[i]->low

    }*/
    
    tArgs[0] = (struct threadArgs*) malloc(sizeof(struct threadArgs));
    tArgs[0]->threadId = 0;
    tArgs[0]->low=mid+1;
    tArgs[0]->high=high;
    
    tArgs[1] = (struct threadArgs*) malloc(sizeof(struct threadArgs));
    tArgs[1]->threadId = 1;
    tArgs[1]->low=0;
    tArgs[1]->high=mid;

    printf("Test call");
    
    pthread_t pt[2];
    
    for(int i=0;i<2;i++)
    {
        pthread_create(&pt[i], NULL, mergeSortThreadFunc, (void*) &tArgs[i] );
        pthread_join(pt[i], NULL);
    }
    printf("Test call 0");

    
    merge(arr,low,mid,high);
    printf("\n");

    for(int i=0;i<SIZE;i++)
    {
        printf("%d\t",arr[i]);
    }
    
    printf("\n");
    
    //int size = (int)(sizeof(pt))/(int)sizeof(pthread_t);
    
    return 0;
}

