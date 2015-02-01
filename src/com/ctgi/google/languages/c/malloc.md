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

###AlignedMalloc
The address of a block returned by malloc or realloc in GNU systems is always a multiple of eight (or sixteen on 64-bit systems). If you need a block whose address is a multiple of a higher power of two than that, use aligned_alloc or posix_memalign. aligned_alloc and posix_memalign are declared in stdlib.h.

Write an aligned malloc & free function that takes number of bytes and aligned byte (which is always power of 2)
EXAMPLE
align_malloc (1000,128) will return a memory address that is a multiple of 128 and that points to memory of size 1000 bytes.
aligned_free() will free memory allocated by align_malloc.

The aligned_alloc function allocates a block of size bytes whose address is a multiple of alignment. The alignment must be a power of two and size must be a multiple of alignment.

The aligned_alloc function returns a null pointer on error and sets errno to one of the following values:

ENOMEM
There was insufficient memory available to satisfy the request.

EINVAL
alignment is not a power of two.

This function was introduced in ISO C11 and hence may have better portability to modern non-POSIX systems than posix_memalign.


For a more generic memory allocation function, the caller doesn't want to have to keep track of two pointers (one to use and one to free).
So you store a pointer to the 'real' buffer below the aligned buffer.

Steps:
1. We will use malloc routine provided by C to implement the functionality.
Allocate memory of size (bytes required + alignment Ð 1 + sizeof(void*)) using malloc.
alignment: malloc can give us any address and we need to find a multiple of alignment.
(Therefore, at maximum multiple of alignment, we will be alignment-1 bytes away from any location.)
sizeof(size_t): We are returning a modified memory pointer to user, which is different from the one that would be returned by malloc. We also need to extra space to store the address given by malloc, so that we can free memory in aligned_free by calling free routine provided by C.
2. If it returns NULL, then aligned_malloc will fail and we return NULL.
3. Else, find the aligned memory address which is a multiple of alignment (call this p2).
4. Store the address returned by malloc (e.g., p1 is just size_t bytes ahead of p2), which will be required by aligned_free.
5. Return p2.

You can find the code here
```c
void* aligned_malloc(size_t required_bytes, size_t alignment)
{
    void* p1; // original block
    void** p2; // aligned block
    int offset = alignment - 1 + sizeof(void*);
    if ((p1 = (void*)malloc(required_bytes + offset)) == NULL)
    {
        return NULL;
    }
    p2 = (void**)(((size_t)(p1) + offset) & ~(alignment - 1));
    
    p2[-1] = p1;
    return p2;
}
```
And for the aligned free,

```c
void aligned_free(void *p)
{
    free(((void**)p)[-1]);
}
```



###Referrences

* [TutorialsPoint.com](http://www.tutorialspoint.com/cprogramming/c_pointers.htm)

