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
void showMacrosWithValues(void);
void showMacrosFromCommandLine(void);
void showMacroWithCode(void);

# define macro1
# define macro2
# define BUFFER_SIZE 1024

# define SQUARE(x) x * x
const int MAX=3;
int main()
{
    showMacrosWithoutDefinition();
    showMacrosWithValues();
    showMacrosFromCommandLine();
    showMacroWithCode();
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

void showMacrosWithValues()
{
    #ifdef BUFFER_SIZE
        printf("BUFFER_SIZE defined with value [%d]\n", BUFFER_SIZE);
    #endif
}

void showMacrosFromCommandLine()
{
    //Note that the BASE_VALUE macro is not defined in this src code
    #ifdef BASE_VALUE
        printf("\BASE_VALUE defined with value [%d]\n", BASE_VALUE);
    #endif
}

void showMacroWithCode()
{
#ifdef SQUARE
    printf("SQUARE is defined\n");
#endif
    int var=5;
    printf("Macro function result %d\n", SQUARE(var));
    
}