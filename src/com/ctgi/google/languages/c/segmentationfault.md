C Language - Segmentation Fault
=====================
In computing, a segmentation fault (often shortened to segfault) or access violation is a fault raised by hardware with memory protection, notifying an operating system (OS) about a memory access violation; on x86 computers this is a form of general protection fault. The OS kernel will in response usually perform some corrective action, generally passing the fault on to the offending process by sending the process a signal. Processes can in some cases install a custom signal handler, allowing them to recover on their own, but otherwise the OS default signal handler is used, generally causing abnormal termination of the process (a program crash), and sometimes a core dump.

Segmentation faults have various causes, and are a common problem in programs written in the C programming language, where they arise primarily due to errors in use of pointers for virtual memory addressing, particularly illegal access. Another type of memory access error is a bus error, which also has various causes, but is today much rarer; these occur primarily due to incorrect physical memory addressing, or due to misaligned memory access Ð these are memory references that the hardware cannot address, rather than references that a process is not allowed to address.

###Introduction Video

<a href="http://www.youtube.com/watch?feature=player_embedded&v=6fT1tCiSVyg
" target="_blank"><img src="http://img.youtube.com/vi/6fT1tCiSVyg/0.jpg" 
alt="http://img.youtube.com/vi/6fT1tCiSVyg/15.jpg" width="540" height="380" border="10" /></a>

###Meaning of Segmentation Fault 

Before jumping on to the actual scenarios, lets quickly discuss what does Segmentation Fault means? 

A segmentation fault occurs mainly when our code tries to access some memory location which it is not suppose to access. 

####For example :
Working on a dangling pointer.
Writing past the allocated area on heap.
Operating on an array without boundary checks.
Freeing a memory twice.
Working on Returned address of a local variable
Running out of memory(stack or heap)

Examples of Segmentation Fault in C 

###1) Working on a dangling pointer. 

Well, before discussing this scenario of segmentation fault, lets understand what is dangling pointers. A pointer which holds memory address of a memory which is already freed is known as a dangling pointer. You cannot figure out whether a given pointer is dangling or not until you use it. When a dangling pointer is used, usually a segmentation fault is observed. 

####Now, lets look at a code to understand it : 
```c
 #include<stdio.h> 
 #include<stdlib.h> 
  
 int main(void) 
 { 
     char *p = malloc(3); 
  
     *p = 'a'; 
     *(p+1) = 'b'; 
     *(p+2) = 'c'; 
  
     free(p); 
  
     *p = 'a'; 
  
     return 0; 
 }
```

In the code above, we have malloc'd 3 bytes on heap and stored the address of first byte in a pointer 'p'. Next we initialized these three bytes. Next we freed this memory and after that we are trying to use this memory again. Well this is not permitted as once a memory is freed, it no longer belongs to our process. Though, if you run the above code, it may not give a segmentation fault immediately as free() returns the memory to heap and now its up to the implementation of heap to take it back to its pool. Once its taken back to heap by kernel then the code above will start giving segmentation faults. 

####another example : 
```c
 #include<stdio.h> 
 #include<stdlib.h> 
 #include<string.h> 
  
 int main(void) 
 { 
     char *p ; 
  
     strcat(p, "abc"); 
     printf("\n %s \n", p); 
  
     return 0; 
 }
```
In the code above, we have pointer 'p', to which we have not allocated any memory. Now we use the garbage address held by the pointer 'p' in the function 'strcat()'. So in the implementation of strcat(), whenever 'p' is accessed, it will give a segmentation fault. 

####And yet another example
```c
 #include<stdio.h> 
 #include<stdlib.h> 
 #include<string.h> 
  
  
 void func(char ** argv) 
 { 
     char arr[2]; 
     strcpy(arr, argv[1]); 
  
     return; 
 } 
  
 int main(int argc, char *argv[]) 
 { 
     func(argv); 
     return 0; 
 }
```

In the above code, we try to access the second argument from command line in the function func() without even checking whether the user has even provided the second argument or not. If the user did not provide then argv[1] will point to a location that our code does not have access to. Hence, in that case we will definitely get a segmentation fault. 

###2)Writing past the allocated area on heap. 
There are times when a logic inadvertently writes past the allocated area on heap. This may happen while performing some operations in a loop or not doing array bound checks etc. So this type of situation also results in a segmentation fault. For example, look at the following code : 

```c
 #include<stdio.h> 
 #include<stdlib.h> 
  
 int main(void) 
 { 
     char *p = malloc(3); 
  
     int i = 0; 
  
     for(i=0;i<0Xffffffff;i++) 
     { 
         p[i] = 'a'; 
     } 
  
     printf("\n %s \n", p); 
  
     return 0; 
 }
```
In the example above, we allocate some bytes to pointer 'p' but try to write way past these bytes in a loop. So, the result we get is a segmentation fault. 

###3) Operating on an array without boundary checks. 

In this scenario, the logic is flawed in a way that an array is written out of its boundary limits and in a rare scenario (or in case of exploits), this buffer overflow may result in overwriting the return address(ie the address to return after executing the present function). And hence returning on a garbage address and executing the instruction kept there may very well cause segmentation fault. 

Lets look the following code :
```c
 #include<stdio.h> 
 #include<stdlib.h> 
 #include<string.h> 
  
  
 void func(char ** argv) 
 { 
     char arr[2]; 
     strcpy(arr, argv[1]); 
  
     return; 
 } 
  
 int main(int argc, char *argv[]) 
 { 
     func(argv); 
     return 0; 
 }
```
In the code above, we are passing the command line argument array to function func(). Inside the function func(), we try to copy the second command line argument (with index '1') into the array arr. The problem here is the function we use to copy. We use strcpy() which has no concern with the capacity of array arr. This function will not detect or prevent a buffer overflow. So if we try to enter very huge string through this logic presented above, we will definitely overwrite the return address kept in the stack of this function and will cause a segmentation fault to happen.

Here is the output of the code above(I tried to run it twice with different command line args) : 

```c
 ~/practice $ ./segfault abc 
  ~/practice $
  
  ~/practice $ ./segfault abcjflcnmscn,snlkewfdebddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd 
 Segmentation fault
``` 

As can be clearly seen, in the first attempt, the code worked fine but in the second attempt, a large command line argument probably overwrote the return address stored on stack of the function func() and hence when the control went back to this overwritten value any damn thing could have caused a segmentation fault as this memory location mostly(until you are very lucky) does not belong to our process. 

###4) Freeing a memory twice. 
This is a bit specific to function free() but is a very common reason for segmentation faults to occur. The specification of free() specifies that if this function is used again on an already freed pointer, the results are undefined and mostly we see a segmentation fault in this scenario. 

Lets quickly see the code :

```c
 #include<stdio.h> 
 #include<stdlib.h> 
 #include<string.h> 
  
 int main(int argc, char *argv[]) 
 { 
     char *p = malloc(8); 
  
  
     free(p); 
     free(p); 
     return 0; 
 }
```
As clearly seen in the code above, we have allocated memory once but we have freed it back to back twice. This is wrong practice and should be avoided. 

###5) Working on Returned address of a local variable 
In this scenario, the address of a local variable is returned to calling function and this address is used there. For example, consider the following code : 

```c
 #include<stdio.h> 
 #include<stdlib.h> 
 #include<string.h> 
  
  
 char* func() 
 { 
     char c = 'a'; 
     return &c; 
 } 
  
 int main(int argc, char *argv[]) 
 { 
     char *ptr = func(); 
     char arr[10]; 
     memset(arr,'0', sizeof(arr)); 
     arr[0] = *ptr; 
     return 0; 
 }
 ```
 In the code above, we did exactly the same now since we all know that the stack of the function is unwind-ed when func() returns. So, its fatal to use any address out of a function stack that has already been unwind-ed. This may cause a segmentation fault.
 
###6) Running out of memory. 

It may happen that we run out of memory. This memory can be a stack memory or a heap memory. Lets consider the following two examples to understand this :
```c
 #include<stdio.h> 
 #include<stdlib.h> 
 #include<string.h> 
  
 int main() 
 { 
     main(); 
 }
```

If you execute the code above, it continuously calls on main() recursively. So with every call, a stack is formed and none of these stacks is ever unwind-ed as we never stop calling main. So at a point all of the process's stack memory gets eaten up and then we get segmentation fault. 

Consider example of heap memory : 

```c
 #include<stdio.h> 
 #include<stdlib.h> 
 #include<string.h> 
  
  
 int main() 
 { 
    unsigned int i = 0; 
  
    for(i=0; i< 0xFFFFFFFF;i++); 
         char *p = malloc(100); 
  
    return 0; 
 }
 ```
 The code above may cause you program to segment fault once all the heap memory is consumed.

###Referrences

* [wikipedia.org](http://en.wikipedia.org/wiki/Segmentation_fault)
* [go4expert.com](http://www.go4expert.com/articles/reasons-segmentation-fault-c-t27220/)

