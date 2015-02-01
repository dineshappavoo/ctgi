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
int addNumbers(int, int);

int main()
{
    int a=3, b=4;
    int d = addNumbers(a, b);
    printf("Result %d",d);
    return 0;
}

int addNumbers(int a, int b)
{
    int c =a+b;
    return c;
}

