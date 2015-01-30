C Language - Macros
=====================
There may be a condition where we want to use a value or a small piece of code many times in a code. Also there is a possibility that the in future, the piece of code or value would change. Then changing the value all over the code does not make any sense. There has to be a way out through which one can make the change at one place and it would get reflected at all the places. This is where the concept of a macro fits in.

```c
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main(void);
void showMacrosWithoutDefinition(void);

# define macro1
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
}
```
Now, one would question where are these testing macros used. Well, mostly these type of testing macros are used in a big project involving many source and header files. In such big projects, to avoid including a single header more than once (directly and indirectly through another header file) a macro is defined in the original header and this macro is tested before including the header anywhere so as to be sure that if the macros is already defined then there is no need to include the header as it has already been included (directly or indirectly).

###Macros with values
There are macros that have some values associated with them. For example :
```c
#define MACRO1 25
```
So, in the above example, we defined a macro MACRO1 which has value 25. The concept is that in the preprocessing stage of the compilation process, the name of this macro is replaced with macros value all over the code. For example :

```c
# define BUFFER_SIZE 1024
void showMacrosWithValues()
{
    #ifdef BUFFER_SIZE
        printf("\BUFFER_SIZE defined with value [%d]\n", BUFFER_SIZE);
    #endif
}
```

###Defining Macros from the command line
Macros can be given values from command line.
```c
#include <stdio.h>
int main(void)
{
    //Note that the BASE_VALUE macro is not defined in this src code
    #ifdef BASE_VALUE
        printf("\BASE_VALUE defined with value [%d]\n", BASE_VALUE);
    #endif
    return 0;
}
```
In the code above, the macro MACRO1 is being tested and its value is being used but it is not defined anywhere. Lets define it from the command line :
```c
$ gcc -Wall -DBASE_VALUE=25 macros.c -o macros
$ ./macro

BASE_VALUE Defined with value [25]
```
So we see that through the command line option -D[Macroname]=[Value] it was made possible.

###Macros with piece of code as their values
As discussed in the introduction part, macros can also contain small piece of code as their values. Those piece of code which are very small and are being used repetitively in the code are assigned to macros. For example :

```c
# define SQUARE(x) x * x
void showMacroWithCode()
{
#ifdef SQUARE
    printf("SQUARE is defined\n");
#endif
    int var=5;
    printf("Macro function result %d\n", SQUARE(var));
    
}
```

You can find the source code [here](https://github.com/dineshappavoo/ctgi/blob/master/src/com/ctgi/google/languages/c/code/macros.c)
  
###Referrences

* [TutorialsPoint.com](http://www.tutorialspoint.com/cprogramming/c_pointers.htm)
* [thegeekstuff.com](http://www.thegeekstuff.com/2012/05/c-macros/)

