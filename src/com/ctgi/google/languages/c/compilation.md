C Language - Compilation
=====================
You write a C program, use gcc to compile it, and you get an executable. It is pretty simple. Right?

Have you ever wondered what happens during the compilation process and how the C program gets converted to an executable?

There are four main stages through which a source code passes in order to finally become an executable.

The four stages for a C program to become an executable are the following:
```
Pre-processing
Compilation
Assembly
Linking
```
In Part-I of this article series, we will discuss the steps that the gcc compiler goes through when a C program source code is compiled into an executable.

Before going any further, lets take a quick look on how to compile and run a ÔCÕ code using gcc, using a simple hello world example.
```c
$ vi print.c
#include <stdio.h>
#define STRING "Hello World"
int main(void)
{
/* Using a macro to print 'Hello World'*/
printf(STRING);
return 0;
}
```
Now, lets run gcc compiler over this source code to create the executable.
```c
$ gcc -Wall print.c -o print
```
In the above command:

gcc Ð Invokes the GNU C compiler
-Wall Ð gcc flag that enables all warnings. -W stands for warning, and we are passing ÒallÓ to -W.
print.c Ð Input C program
-o print Ð Instruct C compiler to create the C executable as print. If you donÕt specify -o, by default C compiler will create the executable with name a.out
Finally, execute print which will execute the C program and display hello world.

```c
$ ./print
Hello World
```
Note: When you are working on a big project that contains several C program, use make utility to manage your C program compilation as we discussed earlier.

Now that we have a basic idea about how gcc is used to convert a source code into binary, weÕll review the 4 stages a C program has to go through to become an executable.

###PRE-PROCESSING

This is the very first stage through which a source code passes. In this stage the following tasks are done:

```
Macro substitution
Comments are stripped off
Expansion of the included files
```
To understand preprocessing better, you can compile the above Ôprint.cÕ program using flag -E, which will print the preprocessed output to stdout.
```c
$ gcc -Wall -E print.c
```
Even better, you can use flag Ô-save-tempsÕ as shown below. Ô-save-tempsÕ flag instructs compiler to store the temporary intermediate files used by the gcc compiler in the current directory.
```c
$ gcc -Wall -save-temps print.c -o print
```
So when we compile the program print.c with -save-temps flag we get the following intermediate files in the current directory (along with the print executable)
```c
$ ls
print.i
print.s
print.o
```
The preprocessed output is stored in the temporary file that has the extension .i (i.e Ôprint.iÕ in this example)

Now, lets open print.i file and view the content.
```c
$ vi print.i
......
......
......
......
# 1 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/stdio.h" 1 3 4
# 64 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/stdio.h" 3 4
# 1 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/sys/cdefs.h" 1 3 4
# 484 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/sys/cdefs.h" 3 4
# 1 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/sys/_symbol_aliasing.h" 1 3 4
# 485 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/sys/cdefs.h" 2 3 4
# 550 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/sys/cdefs.h" 3 4
# 1 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/sys/_posix_availability.h" 1 3 4
# 551 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/sys/cdefs.h" 2 3 4
# 65 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/stdio.h" 2 3 4
# 1 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/Availability.h" 1 3 4
# 148 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/Availability.h" 3 4
# 1 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/AvailabilityInternal.h" 1 3 4
# 149 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/Availability.h" 2 3 4
# 66 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/stdio.h" 2 3 4

# 1 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/_types.h" 1 3 4
# 27 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/_types.h" 3 4
# 1 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/sys/_types.h" 1 3 4
# 33 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/sys/_types.h" 3 4
# 1 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/machine/_types.h" 1 3 4
# 32 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/machine/_types.h" 3 4
# 1 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/i386/_types.h" 1 3 4
# 37 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/usr/include/i386/_types.h" 3 4
typedef signed char __int8_t;

int main(void)
{
printf("Hello World");
return 0;
}
```
In the above output, you can see that the source file is now filled with lots and lots of information, but still at the end of it we can see the lines of code written by us. Lets analyze on these lines of code first.

The first observation is that the argument to printf() now contains directly the string ÒHello WorldÓ rather than the macro. In fact the macro definition and usage has completely disappeared. This proves the first task that all the macros are expanded in the preprocessing stage.
The second observation is that the comment that we wrote in our original code is not there. This proves that all the comments are stripped off.
The third observation is that beside the line Ô#includeÕ is missing and instead of that we see whole lot of code in its place. So its safe to conclude that stdio.h has been expanded and literally included in our source file. Hence we understand how the compiler is able to see the declaration of printf() function.
When I searched print.i file, I found, The function printf is declared as:

extern int printf (__const char *__restrict __format, ...);
The keyword ÔexternÕ tells that the function printf() is not defined here. It is external to this file. We will later see how gcc gets to the definition of printf().

You can use gdb to debug your c programs. Now that we have a decent understanding on what happens during the preprocessing stage. let us move on to the next stage.

###COMPILING

After the compiler is done with the pre-processor stage. The next step is to take print.i as input, compile it and produce an intermediate compiled output. The output file for this stage is Ôprint.sÕ. The output present in print.s is assembly level instructions.

Open the print.s file in an editor and view the content.

```c
$ vi print.s
.file "print.c"
.section .rodata
.LC0:
.string "Hello World"
.text
.globl main
.type main, @function
main:
.LFB0:
.cfi_startproc
pushq %rbp
.cfi_def_cfa_offset 16
movq %rsp, %rbp
.cfi_offset 6, -16
.cfi_def_cfa_register 6
movl $.LC0, %eax
movq %rax, %rdi
movl $0, %eax
call printf
movl $0, %eax
leave
ret
.cfi_endproc
.LFE0:
.size main, .-main
.ident "GCC: (Ubuntu 4.4.3-4ubuntu5) 4.4.3"
.section .note.GNU-stack,"",@progbits
```
Though I am not much into assembly level programming but a quick look concludes that this assembly level output is in some form of instructions which the assembler can understand and convert it into machine level language.

###ASSEMBLY

At this stage the print.s file is taken as an input and an intermediate file print.o is produced. This file is also known as the object file.

This file is produced by the assembler that understands and converts a Ô.sÕ file with assembly instructions into a Ô.oÕ object file which contains machine level instructions. At this stage only the existing code is converted into machine language, the function calls like printf() are not resolved.

Since the output of this stage is a machine level file (print.o). So we cannot view the content of it. If you still try to open the print.o and view it, you will see something that is totally not readable.

```c
$ vi print.o
^?ELF^B^A^A^@^@^@^@^@^@^@^@^@^A^@>^@^A^@^@^@^@^@^@^@^@^@^@^@^@^@^@^@^@^@^@^@0^
^@UH<89>Œü^@^@^@^@H<89>‚üHello World^@^@GCC: (Ubuntu 4.4.3-4ubuntu5) 4.4.3^@^
T^@^@^@^@^@^@^@^AzR^@^Ax^P^A^[^L^G^H<90>^A^@^@^\^@^@]^@^@^@^@A^N^PC<86>^B^M^F
^@^@^@^@^@^@^@^@.symtab^@.strtab^@.shstrtab^@.rela.text^@.data^@.bss^@.rodata
^@.comment^@.note.GNU-stack^@.rela.eh_frame^@^@^@^@^@^@^@^@^@^@^@^
...
...
```
The only thing we can explain by looking at the print.o file is about the string ELF.

ELF stands for executable and linkable format.

This is a relatively new format for machine level object files and executable that are produced by gcc. Prior to this, a format known as a.out was used. ELF is said to be more sophisticated format than a.out (We might dig deeper into the ELF format in some other future article).

Note: If you compile your code without specifying the name of the output file, the output file produced has name Ôa.outÕ but the format now have changed to ELF. It is just that the default executable file name remains the same.

###LINKING

This is the final stage at which all the linking of function calls with their definitions are done. As discussed earlier, till this stage gcc doesnÕt know about the definition of functions like printf(). Until the compiler knows exactly where all of these functions are implemented, it simply uses a place-holder for the function call. It is at this stage, the definition of printf() is resolved and the actual address of the function printf() is plugged in.

The linker comes into action at this stage and does this task.

The linker also does some extra work; it combines some extra code to our program that is required when the program starts and when the program ends. For example, there is code which is standard for setting up the running environment like passing command line arguments, passing environment variables to every program. Similarly some standard code that is required to return the return value of the program to the system.

The above tasks of the compiler can be verified by a small experiment. Since now we already know that the linker converts .o file (print.o) to an executable file (print).

So if we compare the file sizes of both the print.o and print file, weÕll see the difference.

```c
$ size print.o
   text	   data	    bss	    dec	    hex	filename
     97	      0	      0	     97	     61	print.o 

$ size print
   text	   data	    bss	    dec	    hex	filename
   1181	    520	     16	   1717	    6b5	print
```
Through the size command we get a rough idea about how the size of the output file increases from an object file to an executable file. This is all because of that extra standard code that linker combines with our program.

Now you know what happens to a C program before it becomes an executable. You know about Preprocessing, Compiling, Assembly, and Linking stages There is lot more to the linking stage, which we will cover in our next article in this series.
  
###Referrences

* [thegeekstuff.com](http://www.thegeekstuff.com/2011/10/c-program-to-an-executable/)

