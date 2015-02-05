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
#include<stdlib.h>
#include <stdio.h>
#include <pthread.h>

# define BufferSize 10

void *Producer();
void *Consumer();

int BufferIndex=0;
char *BUFFER;

pthread_cond_t Buffer_Not_Full=PTHREAD_COND_INITIALIZER;
pthread_cond_t Buffer_Not_Empty=PTHREAD_COND_INITIALIZER;
pthread_mutex_t mVar=PTHREAD_MUTEX_INITIALIZER;

int main()
{
    pthread_t ptid,ctid;
    
    BUFFER=(char *) malloc(sizeof(char) * BufferSize);
    
    pthread_create(&ptid,NULL,Producer,NULL);
    pthread_create(&ctid,NULL,Consumer,NULL);
    
    pthread_join(ptid,NULL);
    pthread_join(ctid,NULL);
    
    
    return 0;
}

void *Producer()
{
    for(;;)
    {
        pthread_mutex_lock(&mVar);
        if(BufferIndex==BufferSize)
        {
            pthread_cond_wait(&Buffer_Not_Full,&mVar);
        }
        BUFFER[BufferIndex++]='@';
        printf("Producer Value  : %d \n",BufferIndex);
        pthread_mutex_unlock(&mVar);
        pthread_cond_signal(&Buffer_Not_Empty);
    }
    
}

void *Consumer()
{
    for(;;)
    {
        pthread_mutex_lock(&mVar);
        if(BufferIndex==-1)
        {
            pthread_cond_wait(&Buffer_Not_Empty,&mVar);
        }
        printf("Consumer Value : %d \n",BufferIndex--);
        pthread_mutex_unlock(&mVar);
        pthread_cond_signal(&Buffer_Not_Full);
    }
}