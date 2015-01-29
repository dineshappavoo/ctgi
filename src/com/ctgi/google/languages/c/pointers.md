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

###Multi level Pointers

To declare the double pointers use **. Double pointers are noting but pointers to the pointers. pointers to the pointers is shown in the following code

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

You can use any level of pointers. But but there is a limit.Having two levels of indirection (a pointer to a pointer to something) is common. Any more than that gets a bit harder to think about easily; don't do it unless the alternative would be worse.

###NULL Pointers in C
It is always a good practice to assign a NULL value to a pointer variable in case you do not have exact address to be assigned. This is done at the time of variable declaration. A pointer that is assigned NULL is called a null pointer.

The NULL pointer is a constant with a value of zero defined in several standard libraries. Consider the following program:

```
void showNullPointers()
{
    int var=8;
    int *pointer = NULL;
    printf("The Null pointer is value %x\n",pointer);
    pointer = &var;
    printf("The pointer value after assignment %x\n",pointer);
}
```

On most of the operating systems, programs are not permitted to access memory at address 0 because that memory is reserved by the operating system. However, the memory address 0 has special significance; it signals that the pointer is not intended to point to an accessible memory location. But by convention, if a pointer contains the null (zero) value, it is assumed to point to nothing.

###C Pointer Arithmetic
To understand pointer arithmetic, let us consider that ptr is an integer pointer which points to the address 1000. Assuming 32-bit integers, let us perform the following arithmetic operation on the pointer:
```
ptr++
```
Now, after the above operation, the ptr will point to the location 1004 because each time ptr is incremented, it will point to the next integer location which is 4 bytes next to the current location. This operation will move the pointer to next memory location without impacting actual value at the memory location. If ptr points to a character whose address is 1000, then above operation will point to the location 1001 because next character will be available at 1001. Because character needs 1 byte memory. 

```
const int MAX=3;
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
```
  
###Referrences

* [Tutorials Point](http://www.tutorialspoint.com/cprogramming/c_pointers.htm)

