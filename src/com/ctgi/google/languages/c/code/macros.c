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
void showMacrosWithoutDefinition(void);

# define macro1
# define macro2

const int MAX=3;
int main()
{
    showMacrosWithoutDefinition();
    return 0;
}
void showMacrosWithoutDefinition()
{
    #ifdef macro1
        printf("Macro1 is defined\n");
    #endif
    
    #ifdef macro2
        printf("Macro2 is defined\n");
    #endif
}
