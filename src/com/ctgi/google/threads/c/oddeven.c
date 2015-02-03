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

# define N 10
# define NO_OF_THREADS 2

pthread_mutex_t numLock;

int arr[N];
int odd[N/2];
int even[N/2];

void *findOdd(void*);
void *findEven(void*);

void *findOdd(void *tArgs)
{
    int j=0;
    for(int i=0;i<N;i++)
    {
        if((arr[i]&1)>0)
            odd[j++]=arr[i];
    }
    return NULL;
}

void *findEven(void *tArgs)
{
    int j=0;
    for(int i=0;i<N;i++)
    {
        if((arr[i]&1)==0)
            even[j++]=arr[i];
    }
    return NULL;
}

int main()
{
    for(int i=0;i<N;i++)
    {
        arr[i] = i;
    }
    
    pthread_t pt[NO_OF_THREADS];

    
    pthread_mutex_init(&numLock, NULL);
    
    pthread_mutex_lock(&numLock);
    pthread_create(&pt[0], NULL, findOdd, NULL);
    pthread_join(pt[0], NULL);
    pthread_mutex_unlock(&numLock);

    pthread_mutex_lock(&numLock);
    pthread_create(&pt[1], NULL, findEven, NULL);
    pthread_join(pt[1], NULL);
    pthread_mutex_unlock(&numLock);

    
    
    printf("ODD : ");
    for (int j=0; j<N/2; j++) {
        printf("%d\t",odd[j]);
    }
    printf("\n");
    
    printf("EVEN : ");
    for (int j=0; j<N/2; j++) {
        printf("%d\t",even[j]);
    }
    printf("\n");

    pthread_mutex_destroy(&numLock);

    
    return 0;
}