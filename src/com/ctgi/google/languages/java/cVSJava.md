Difference between C and Java
=============================
|Property | C | Java |
|--------|---|-------|
|type of language	|	function oriented	|	object oriented |
|language type	|	```Compiled:``` takes your code & translates it into something the machine can understand-that is to say-0's & 1's-the machine-level code. That's exactly what happens with our C code-it gets 'compiled'.  | ```Intrepreted:``` the code is first transformed to what is called the bytecode. This bytecode is then executed by the JVM(Java Virtual Machine). For the same reason, JAVA code is more portable. |
|language level | C is a low-level language(difficult interpretation for the user, closer significance to the machine-level code) |	 JAVA is a high-level language(abstracted from the machine-level details, closer significance to the program itself). |
|approach	|	```C uses the top-down {sharp & smooth} approach```	In C, formulating the program begins by defining the whole and then splitting them into smaller elements.	|```JAVA uses the bottom-up {on the rocks} approach``` JAVA(and C++ and other OOP languages) follows the bottom-up approach where the smaller elements combine together to form the whole.|
||||
|basic programming unit	|	function	|	class = ADT |
|portability of source code	|	possible with discipline	|	yes |
|portability of compiled code	|	no, recompile for each architecture	|	yes, bytecode is "write once, run anywhere" |
|security	|	limited	|	built-in to language |
|compilation	|	gcc hello.c creates machine language code	|	javac Hello.java creates Java virtual machine language bytecode |
|linking in the Math library	|	gcc -lm calculate.c	|	no special flags needed |
|joint compilation	|	gcc main.c helper1.c helper2.c	|	javac Main.java - any dependent files are automatically re-compiled if needed |
|execution	|	a.out loads and executes program	|	java Hello interprets byte code |
|hello, world	|	```#include<stdio.h> int main(void) {    printf("Hello\n");    return 0; }```	|	```public class HelloWorld {    public static void main(String[] args) {         System.out.println("Hello");    } }``` |
|integer types	|	int usually 32 bit 2's complement; long usually 32 bit 2's complement	|	int is 32 bit 2's complement; long is 64 bit 2's complement |
|floating point types	|	float usually 32 bit; double usually 64 bit	|	float is 32 bit IEEE 754 binary floating point; double is 64 bit IEEE 754 |
|boolean type	|	use int: 0 for false, nonzero for true	|	boolean is its own type - stores value true or false |
|character type	|	char is usually 8 bit ASCII	|	char is 16 bit UNICODE |
|for loops	|	for (i = 0; i < N; i++)	|	for (int i = 0; i < N; i++) |
|array declarations	|	int *a = malloc(N * sizeof(*a));	|	int[] a = new int[N]; |
|array size	|	arrays don't know their own size	|	a.length |
|strings	|	'\0'-terminated character array	|	built-in immutable String data type |
|accessing a library	|	#include <stdio.h>	|	import java.io.File; |
|accessing a library function	|	#include "math.h"x = sqrt(2.2); all function and variables names are global	|	x = Math.sqrt(2.2); functions have different namespaces |
|printing to standard output	|	printf("sum = %d", x);	|	System.out.println("sum = " + x); |
|formatted printing	|	printf("avg = %3.2f", avg);	|	System.out.printf("avg = %3.2f", avg) |
|reading from stdin	|	scanf("%d", &x);	|	Java library support, but easier to use our library int x = StdIn.readInt(); |
|memory address	|	pointer	|	reference |
|manipulating pointers	|	*, &, +	 C requires explicit handling of pointers	| no direct manipulation permitted.  Pointer go backstage in JAVA. When it comes to JAVA, we don’t need the *\’s & &\’s to deal with pointers & their addressing. More formally, there is no pointer syntax required in JAVA. In JAVA, we do create references for objects. |
|functions	|	int max(int a, int b)	|	public static int max(int a, int b) |
|pass-by-value	|	primitive data types, structs, and pointers are passed by value; array decays to pointer	|	all primitive data types and references (which includes arrays), are passed by value |
|defining a data structure	|	struct	|	class - key difference is language support for defining methods to manipulate data  |
|accessing a data structure	|	a.numerator for elements	|	a.numerator for instance variables, c = a.plus(b) for methods |
|pointer chasing	|	x->left->right	|	x.left.right |
|allocating memory	|	malloc, realloc, calloc |	new |
|de-allocating memory	|	```free``` C uses free to de-allocate chunks of memory for specific data(specified using the keyword ‘sizeof’). Hence in C, the memory is managed by the user	|	automatic garbage collection. JAVA uses a garbage collector that deletes the objects that no longer have any references to them. |
|memory allocation of data structures and arrays	|	heap, stack, data, or bss	|	heap |
|buffer overflow	|	segmentation fault, core dump, unpredicatable program	|	checked run-time error exception |
|declaring constants	|	const and #define	|	final |
|variable auto-initialization	|	not guaranteed	|	instance variables (and array elements) initialized to 0, null, or false, compile-time error to access uninitialized variables |
|data hiding	|opaque pointers and static	|	private |
|interface method	|	non-static function	|	public method |
|data type for generic item	|	void *	|	Object |
|casting	|	anything goes	|	checked exception at run-time or compile-time |
|Exception	|	In C, if there’s an error, there IS an error. |	When an error occurs in a Java program it results in an exception being thrown. It can then be handled using various exception handling techniques.|
|demotions	|	automatic, but might lose precision	|	must explicitly cast, e.g., to convert from long to int |
|polymorphism	|	union	|	inheritence |
|overloading	|	no. C does not allow overloading at all. |	yes for methods, no for operators. JAVA supports function or method overloading-that is we can have two or more functions with the same name(with certain varying parameters like return types to allow the machine to differentiate between them). That it to say, we can overload methods with the same name having different method signatures. JAVA(unlike C++), does not support Operator Overloading |
|graphics	|	use external libraries	|	Java library support, use our standard drawing library |
|null	|	NULL	|	null |
|enumeration	|	enum	|	typesafe enum |
|preprocessor	|	yes. The preprocessor directives like #include & #define, etc are considered one of the most essential elements of C programming. #include used to include files in C.|	no. There are no preprocessors in JAVA. JAVA uses other alternatives for the preprocessors. For instance, public static final is used instead of the #define preprocessor. Java maps class names to a directory and file structure instead of the #include used to include files in C. |
|variable declaration	|	at beginning of a block	|	before you use it |
|variable naming conventions	|	sum_of_squares	|	sumOfSquares |
|commenting	|/* */ or //	|	/* */ or // |
|file naming conventions	|	stack.c, stack.h	|	Stack.java - file name matches name of class |
|callbacks	|	pointers to global functions	|	use interfaces for commmand dispatching |
|variable number of arguments	|	varargs	|	String ... |
|assertions	|	assert	|	assert |
|exit and return value to OS	|	exit(1)	|	System.exit(1) |


  
###Referrences

* [princeton.edu](http://introcs.cs.princeton.edu/java/faq/c2java.html)
* [durofy.com](http://www.durofy.com/10-major-differences-between-c-and-java/)

