C Language - Pointers
=====================

C programming tasks are performed more easily with pointers, and other tasks, such as dynamic memory allocation, cannot be performed without using pointers.

every variable is a memory location and every memory location has its address defined which can be accessed using ampersand (&) operator, which denotes an address in memory. Consider the following example, which will print the address of the variables defined:

```
#include <stdio.h>

int main ()
{
   int  var1;
   char var2[10];

   printf("Address of var1 variable: %x\n", &var1  );
   printf("Address of var2 variable: %x\n", &var2  );

   return 0;
}

```

To declare the double pointers usee **. Double pointers are noting but pointers to the pointers. pointers to the pointers is shown in the following code

```
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


```
  
###Referrences

* ([Tutorials Point](http://www.tutorialspoint.com/cprogramming/c_pointers.htm))

