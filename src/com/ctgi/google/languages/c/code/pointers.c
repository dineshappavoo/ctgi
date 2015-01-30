//
//  Pointers.c
//  Pointers
//
//  Created by Dinesh Appavoo on 1/29/15.
//  Copyright (c) 2015 Dinesh Appavoo. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main(void);
void showPointers(void);
void showNullPointers(void);
void showPointerArithmatic(void);
void showArrayOfPointers(void);

const int MAX=3;
int main()
{
    
    showPointers();
    showNullPointers();
    showPointerArithmatic();
    showArrayOfPointers();
    return 0;
}

void showPointers()
{
    int var=15;
    int *point;
    point=&var;
    int **pToP;
    pToP = &point;
    printf("The address of var is %x\n",&var);
    printf("The value in point is %x and the value *point would be %d\n",point, *point);
    
    printf("The pointer to pointer value %x\nThe value of first pointer %x\n",pToP, *pToP);
    printf("The value of var through pToP is %d\n",**pToP);
}

void showNullPointers()
{
    int var=8;
    int *pointer = NULL;
    printf("The Null pointer is value %x\n",pointer);
    pointer = &var;
    printf("The pointer value after assignment %x\n",pointer);
}

void showPointerArithmatic()
{
    int var[] = {10,100,1000};
    int *pointer;
    int i=MAX-1;
    pointer=var;
    //Increment pointer
    for(int i=0;i<MAX;i++)
    {
        printf("Index %d Address : %x\n",i,pointer);
        printf("Index %d Value var[i] %d\n",i, *pointer);
        pointer++;
    }
    //Decrement pointer
    pointer=&var[MAX-1];
    while(pointer>=&var[0]){
        printf("Index %d Address : %x\n",i,pointer);
        printf("Index %d Value var[i] %d\n",i, *pointer);
        pointer--;
        i--;
    }
}

void showArrayOfPointers()
{
    int var[] ={10,100, 1000};
    int *pointer[MAX];
    //Assign address to pointer array
    for (int i=0; i<MAX; i++) {
        pointer[i] = &var[i];
    }
    //Display values
    for(int i=0;i<MAX; i++){
        printf("Index %d pointer %x Value %d\n",i, pointer[i], *pointer[i]);
    }
}