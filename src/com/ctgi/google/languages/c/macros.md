C Language - Macros
=====================
There may be a condition where we want to use a value or a small piece of code many times in a code. Also there is a possibility that the in future, the piece of code or value would change. Then changing the value all over the code does not make any sense. There has to be a way out through which one can make the change at one place and it would get reflected at all the places. This is where the concept of a macro fits in.

```
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


You can find the source code [here](https://github.com/dineshappavoo/ctgi/blob/master/src/com/ctgi/google/languages/c/code/pointers.c)
  
###Referrences

* [Tutorials Point](http://www.tutorialspoint.com/cprogramming/c_pointers.htm)

