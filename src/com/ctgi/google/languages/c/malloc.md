C Language - Malloc - Calloc - 
============================
###Malloc
C dynamic memory allocation refers to performing manual memory management for dynamic memory allocation in the C programming language via a group of functions in the C standard library, namely malloc, realloc, calloc and free.

The C library function void *malloc(size_t size) allocates the requested memory and returns a pointer to it.

####Following is the declaration for malloc() function.

void *malloc(size_t size)

**Parameters**
size -- This is the size of the memory block, in bytes.

```c
#include <stdio.h>
#include <stdlib.h>

int main()
{
   char *str;

   /* Initial memory allocation */
   str = (char *) malloc(15);
   strcpy(str, "tutorialspoint");
   printf("String = %s,  Address = %u\n", str, str);

   /* Reallocating memory */
   str = (char *) realloc(str, 25);
   strcat(str, ".com");
   printf("String = %s,  Address = %u\n", str, str);

   free(str);
   
   return(0);
}
```

###Calloc
The C library function void *calloc(size_t nitems, size_t size) allocates the requested memory and returns a pointer to it. The difference in malloc and calloc is that malloc does not set the memory to zero where as calloc sets allocated memory to zero.

####Declaration
Following is the declaration for calloc() function.

void *calloc(size_t nitems, size_t size)

**Parameters**
* nitems -- This is the number of elements to be allocated.
* size -- This is the size of elements.

####Return Value
This function returns a pointer to the allocated memory, or NULL if the request fails.

```c
#include <stdio.h>
#include <stdlib.h>

int main()
{
   int i, n;
   int *a;

   printf("Number of elements to be entered:");
   scanf("%d",&n);

   a = (int*)calloc(n, sizeof(int));
   printf("Enter %d numbers:\n",n);
   for( i=0 ; i < n ; i++ ) 
   {
      scanf("%d",&a[i]);
   }

   printf("The numbers entered are: ");
   for( i=0 ; i < n ; i++ ) {
      printf("%d ",a[i]);
   }
   
   return(0);
}
```
###Free()
The C library function void free(void *ptr) deallocates the memory previously allocated by a call to calloc, malloc, or realloc.

####Declaration
Following is the declaration for free() function.

void free(void *ptr)

**Parameters**
ptr -- This is the pointer to a memory block previously allocated with malloc, calloc or realloc to be deallocated.If a null pointer is passed as argument, no action occurs

**Return Value**
This function does not return any value.

```c
#include <stdio.h>
#include <stdlib.h>

int main()
{
   char *str;

   /* Initial memory allocation */
   str = (char *) malloc(15);
   strcpy(str, "tutorialspoint");
   printf("String = %s,  Address = %u\n", str, str);

   /* Reallocating memory */
   str = (char *) realloc(str, 25);
   strcat(str, ".com");
   printf("String = %s,  Address = %u\n", str, str);

   /* Deallocate allocated memory */
   free(str);
   
   return(0);
}
```

Let us compile and run the above program, this will produce the following result:

```c
String = tutorialspoint, Address = 355090448
String = tutorialspoint.com, Address = 355090448
```

###Realloc()
The C library function void *realloc(void *ptr, size_t size) attempts to resize the memory block pointed to by ptr that was previously allocated with a call to malloc or calloc.

###Declaration
Following is the declaration for realloc() function.

void *realloc(void *ptr, size_t size)

**Parameters**
ptr -- This is the pointer to a memory block previously allocated with malloc, calloc or realloc to be reallocated.If this is NULL, a new block is allocated and a pointer to it is returned by the function.

size -- This is the new size for the memory block, in bytes.If it is 0 and ptr points to an existing block of memory, the memory block pointed by ptr is deallocated and a NULL pointer is returned.

**Return Value**
This function returns a pointer to the newly allocated memory, or NULL if the request fails.

```c
#include <stdio.h>
#include <stdlib.h>

int main()
{
   char *str;

   /* Initial memory allocation */
   str = (char *) malloc(15);
   strcpy(str, "tutorialspoint");
   printf("String = %s,  Address = %u\n", str, str);

   /* Reallocating memory */
   str = (char *) realloc(str, 25);
   strcat(str, ".com");
   printf("String = %s,  Address = %u\n", str, str);

   free(str);
   
   return(0);
}
```
###Referrences

* [TutorialsPoint.com](http://www.tutorialspoint.com/cprogramming/c_pointers.htm)

