Java Interview questions
========================
####1. Why would it be more secure to store sensitive data (such as a password, social security number, etc.) in a character array rather than in a String?
In Java, Strings are immutable and are stored in the String pool. What this means is that, once a String is created, it stays in the pool in memory until being garbage collected. Therefore, even after you’re done processing the string value (e.g., the password), it remains available in memory for an indeterminate period of time thereafter (again, until being garbage collected) which you have no real control over. Therefore, anyone having access to a memory dump can potentially extract the sensitive data and exploit it.

In contrast, if you use a mutable object like a character array, for example, to store the value, you can set it to blank once you are done with it with confidence that it will no longer be retained in memory.

####2. Describe and compare fail-fast and fail-safe iterators. Give examples.
The main distinction between fail-fast and fail-safe iterators is whether or not the collection can be modified while it is being iterated. Fail-safe iterators allow this; fail-fast iterators do not.

**Fail-fast iterators** operate directly on the collection itself. During iteration, fail-fast iterators fail as soon as they realize that the collection has been modified (i.e., upon realizing that a member has been added, modified, or removed) and will throw a ConcurrentModificationException. Some examples include ```ArrayList```, ```HashSet```, and ```HashMap``` (most JDK1.4 collections are implemented to be fail-fast).


**Fail-safe iterators** operate on a cloned copy of the collection and therefore do not throw an exception if the collection is modified during iteration. Examples would include iterators returned by ```ConcurrentHashMap``` or ```CopyOnWriteArrayList```.

####3. Tail recursion is functionally equivalent to iteration. Since Java does not yet support tail call optimization, describe how to transform a simple tail recursive function into a loop and why one is typically preferred over the other.

Here is an example of a typical recursive function, computing the arithmetic series 1, 2, 3…N. Notice how the addition is performed after the function call. For each recursive step, we add another frame to the stack.

```java
public int sumFromOneToN(int n) {
  if (n < 1) {
    return n;
  }

  return n + sumFromOneToN(n - 1);
}
```
Tail recursion occurs when the recursive call is in the tail position within its enclosing context - after the function calls itself, it performs no additional work. That is, once the base case is complete, the solution is apparent. For example:

```java
public int sumFromOneToN(int n, int a) {
  if (n < 1) {
    return a;
  }

  return sumFromOneToN(n - 1, a + n);
}
```
Here you can see that a plays the role of the accumulator - instead of computing the sum on the way down the stack, we compute it on the way up, effectively making the return trip unnecessary, since it stores no additional state and performs no further computation. Once we hit the base case, the work is done - below is that same function, “unrolled”.

```java
public int sumFromOneToN(int n) {
  int a = 0;

  while(n > 0) {
    a += n--;
  }
  
  return a;
}
```
Many functional languages natively support tail call optimization, however the JVM does not. In order to implement recursive functions in Java, we need to be aware of this limitation to avoid StackOverflowErrors. In Java, iteration is almost universally preferred to recursion.

####4. ArrayList, LinkedList, and Vector are all implementations of the List interface. Which of them is most efficient for adding and removing elements from the list? Explain your answer, including any other alternatives you may be aware of.

Of the three, ```LinkedList``` is generally going to give you the best performance. Here’s why:

```ArrayList``` and ```Vector``` each use an array to store the elements of the list. As a result, when an element is inserted into (or removed from) the middle of the list, the elements that follow must all be shifted accordingly. ```Vector``` is synchronized, so if a thread-safe implementation is not needed, it is recommended to use ```ArrayList``` rather than ```Vector```.

```LinkedList```, on the other hand, is implemented using a doubly linked list. As a result, an inserting or removing an element only requires updating the links that immediately precede and follow the element being inserted or removed.

However, it is worth noting that if performance is that critical, it’s better to just use an array and manage it yourself, or use one of the high performance 3rd party packages such as Trove or HPPC.

####5. What are anonymous classes? When, why, and how would you use them? Provide an example.
Anonymous classes are in-line expressions, often single-use classes for convenience, that help make your code more concise. The following example instantiates a new ActionListener to handle events associated with a button:

```java
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        /* do something in response to button action event */
    }
});
```
This makes sense since the class isn’t used elsewhere and doesn’t need a name. However, if you pass an anonymous class to a registration method, for instance, you may want to keep track of its reference, in order to be able to unregister it later. Let’s extend the above example to demonstrate this:

```java
ActionListener listener = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        /* do something in response to button action event */
    };
button.addActionListener(listener);

/* some time later... */

button.removeActionListener(listener);
```

####6. What are abstract classes? When, why, and how would you use them? Provide an example.
Abstract classes are useful for defining abstract template methods that concrete subclasses must implement. All concrete subclasses are therefore guaranteed to honor the API specified by the abstract methods in the abstract class they inherit from. This is somewhat similar to the way in which a Java interface specifies an API for all classes that implement it.

The common use case is where there is a category of objects that have a common behavior (e.g., all shapes have an area), but the details of calculating or performing those functions varies from one object to another. For example:

```java
 public abstract class Shape {
     public abstract double area();
 }
 
 public class Circle extends Shape {
     private double radius;
     
     public Circle(double radius) {
         this.radius = radius;
     }
     public double area() { return Math.PI * Math.pow(this.radius,2); }
 }
 
 public class Rectangle extends Shape {
     private double width, height;
     
     public Rectangle(double width, double height) {
         this.width = width;
         this.height = height;
     }
     public double area() { return this.width * this.height; }
 }
 ```
 A couple of things worth noting:

Abstract classes may not be instantiated directly; only their concrete subclasses are instantiable.
A class may be declared abstract even if it has no abstract methods. This will preclude that class from being instantiated. This can be useful, for example, if a base class in a class hierarchy has no abstract methods but is not itself meant to be instantiated.

####7. Compare and contrast checked and unchecked exceptions. Provide examples.
```Unchecked exceptions``` are exceptions that are not considered to be recoverable. Java doesn’t force you to catch or handle these because they indicate abnormal, unexpected problems with your code such as ```NullPointerException```, ```ArithmeticException``` and ```IndexOutOfBoundsException```. That is, these are problems you need to fix or prevent. ```Unchecked exceptions``` all derive either from Error or from RuntimeException.

```Checked exceptions``` are exceptions that are considered to be recoverable. Checked exceptions must explicitly be specified as part of a method’s API; that is, a method that may throw one or more checked exceptions must list those potential exceptions as part of its method declaration (the Java compiler will actually enforce this).

When calling a method that throws exceptions, the caller must either handle (i.e., catch) those exceptions or must throw them itself. For example, if a method throws a checked exception, the caller might decide to ignore the error and continue (swallow it), display a dialog to the user, or rethrow the exception to let a method higher up the call chain handle it (in which case it must also declare that it throws the checked exception).

For example:

```java
public void readFile(File file) throws IOException, MyReadFileException {
    try {
        FileInputStream fis = new FileInputStream(file);
    } catch(FileNotFoundException e) {
        // We catch the FileNotFoundException and instead throw an IOException,
        // so we don't include FileNotFoundException in our "throws" clause above. 
        throw new IOException();
    }
    
    if (somethingBadHappened) {
        // We explicitly throw our own MyReadFileException here,
        // so we do include it in our "throws" clause above.
        throw new MyReadFileException();
    }
}
```
Checked exceptions clearly communicate and enforcing handling of error conditions. However, it can also be a pain for developers to continually need to include try/catch blocks to handle all known exceptions from the methods that they call. Although numerous checked exceptions are certainly permissible in Java, things can get a bit unwieldly. For example:

```java
public void sillyMethod() throws DataFormatException, InterruptedException, 
	IOException, SQLException, TimeoutException, ParseException {
...
}
```
Accordingly, there has been raging debate for years on whether to use checked or unchecked exceptions when writing libaries, for example. As is true with many such debates, the truth is that there really is no one-size-fits-all, across-the-board correct answer. Checked and unchecked exceptions each have their own advantages and disadvantages, so the decision about which to use largely depends on the situation and context.

####8. Describe Generics and provide examples of generic methods and classes in Java.

Java ```generics``` enable programmers to specify, with a single method or class declaration, functionality that can be applied to multiple different data types.```Generics``` also provide compile-time type safety that allows programmers to catch invalid types at compile time.

Here, for example, is a generic method that uses <E> as the placeholder for a generic type:

```java
public <E> void printArray( E[] inputArray ) {
    // Display array elements              
    for ( E element : inputArray ) {        
        System.out.printf( "%s ", element );
    }
    System.out.println();
}
```
The above method could then be invoked with various types of arrays and would handle them all appropriately; e.g.:
```java
// invoke generic printArray method with a Double array
Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
printArray(doubleArray);

// invoke generic printArray method with a Character array
Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
printArray(charArray);
```
There may be times, though, when you want to restrict the kinds of types that are allowed to be passed to a generic type parameter. For example, a method that operates on numbers might only want to accept instances of Number or its subclasses. This is accomplished in generic using a bounded type parameter, which list the type parameter’s name followed by the extends keyword. For example:

```java
// determines the largest of three Comparable objects
public static <T extends Comparable<T>> T maximum(T x, T y, T z) {                      
  T max = x; // assume x is initially the largest       
  if ( y.compareTo( max ) > 0 ) {
     max = y; // y is the largest so far
  }
  if ( z.compareTo( max ) > 0 ) {
     max = z; // z is the largest now                 
  }
  return max; // returns the largest object   
}
```
As with generic methods, the type parameter section of a generic class can have one or more type parameters separated by commas. For example:

```java
public class Cell<T> {
  private T val;

  public void set(T val) { this.val = val; }

  public T get() { return val; }

  public static void main(String[] args) {
     Cell<Integer> integerCell = new Box<Integer>();
     Cell<String> stringCell = new Box<String>();
    
     integerCell.add(new Integer(10));
     stringCell.add(new String("Hello World"));

     System.out.printf("Integer Value :%d\n\n", integerCell.get());
     System.out.printf("String Value :%s\n", stringCell.get());
  }
}
```

####9. What is multiple inheritance? What are some potential problems with it and why has Java traditionally not supported it? How has this changed with the release of Java 8?
Multiple inheritance is a feature of some object-oriented computer programming languages in which an object or class can inherit characteristics and features from more than one parent object or parent class. It is distinct from single inheritance, where an object or class may only inherit from one particular object or class.

Until Java 8, Java only supported single inheritance. We’ll discuss Java 8’s quasi-support for multiple inheritance shortly, but first let’s understand what problems can result from multiple inheritance and why it has been so heavily avoided in Java.

The main argument against multiple inheritance is the complexity, and potential ambiguity, that it can introduce. This is most typically exemplified by the commonly cited “diamond problem”, whereby classes B and C inherit from class A, and class D inherits from both classes B and C. Ambiguity arises if there is a method in A that both B and C have overridden. If D does not override it, then which version of the method does it inherit; that of B, or that of C?

Let’s consider a simple example. A university has people who are affiliated with it. Some are students, some are faculty members, some are administrators, and so on. So a simple inheritance scheme might have different types of people in different roles, all of whom inherit from one common “Person” class. The Person class could define an abstract getRole() method which would then be overridden by its subclasses to return the correct role type, i.e.:

![ctgi](https://github.com/dineshappavoo/ctgi/blob/master/src/com/ctgi/images/multiple-inheritance1.png"multiple inheritance classes")


But now what happens if we want to model a the role of a Teaching Assistant (TA)? Typically, a TA is both a grad student and a faculty member. This yields the classic diamond problem of multiple inheritance and the resulting ambiguity regarding the TA’s getRole() method:

![ctgi](https://github.com/dineshappavoo/ctgi/blob/master/src/com/ctgi/images/multiple-inheritance2.png"multiple inheritance")


(Incidentally, note the diamond shape of the above inheritance diagram, which is why this is referred to as the “diamond problem”.)

Which getRole() implementation should the TA inherit? That of the Faculty Member or that of the Grad Student? The simple answer might be to have the TA class override the getRole() method and return newly-defined role called “TA”. But that answer is also imperfect as it would hide the fact that a TA is, in fact, both a faculty member and a grad student. There are multiple design approaches and patterns for addressing this type of situation without multiple inheritance, which is why some languages (Java being one of them) have made the decision to simply steer clear of multiple inheritance.

Java 8, however, introduces a form of quasi-support for multiple inheritance by allowing default methods to be specified on interfaces (prior to Java 8, only method signatures, not method definitions, were allowed on interfaces). Since Java does allow a single class to implement multiple interfaces (whereas a single class can only extend a single parent class), the allowance in Java 8 for method definitions in an interface introduces the potential for the diamond problem in Java for the first time.

For example, if A, B, and C are interfaces, B and C can each provide a different implementation to an abstract method of A, causing the diamond problem for any class D that implements B and C. Either class D must reimplement the method (the body of which can simply forward the call to one of the super implementations), or the ambiguity will be rejected as a compile error.

####10. How can null be problematic and how can you avoid its pitfalls?

For one thing, ```null``` is often ambiguous. It might be used to indicate success or failure. Or it might be used to indicate absence of a value. Or it might actually be a valid value in some contexts.

And even if one knows the meaning of ```null``` in a particular context, it can still cause trouble if the hapless developer forgets to check for it before de-referencing it, thereby triggering a ```NullPointerException```.

One of the most common and effective techniques for avoiding these issues is to use meaningful, ```non-null``` defaults. In other words, simply avoid using ```null``` to the extent that you can. Avoid setting variables to null and avoid returning ```null``` from methods whenever possible (e.g., return an empty list rather than ```null```).

In addition, as of JDK 8, Java has introduced support for the ```Optional<T>``` class (or if you’re using an earlier version of Java, you can use the ```Optional<T>``` class in the ```Guava``` libraries. Optional<T> represents and wraps absence and presence with a value. While Optional adds a bit more ceremony to your code, by forcing you to unwrap the Optional to obtain the ```non-null``` value, it avoids what might otherwise result in a ```NullPointerException```.

####11. What is “boxing” and what are some of its problems to beware of?

Java’s primitive types are long, int, short, float, double, char, byte and boolean. Often it’s desirable to store primitive values as objects in various data structures that only accept objects such as ArrayList, HashMap, etc. So Java introduced the concept of “boxing” which boxes up primitives into object class equivalents, e.g., Integer for int, Float for float, and Boolean for boolean. Of course, as objects, they incur the overhead of object allocation, memory bloat and method calls, but they do achieve their purpose at some expense.

“Autoboxing” is the automatic conversion by the compiler of primitives to boxed objects and vice versa. This is simply a convenience, e.g.:

```java
ArrayList<Integer> ints = new ArrayList<Integer>();

// Autoboxing.  Compiler automatically converts "35" into a boxed Integer.
ints.add(35); 

// So the above is equivalent to:  ints.add(new Integer(35));
```
Despite their convenience, though, boxed objects are notorious for introducing gnarly bugs, especially for less experienced Java developers.

For one thing, consider this:

```java
System.out.println(new Integer(5) == new Integer(5));   // false
```
In the above line of code, we are comparing the identity of two Integer objects. Since each new Integer(5) creates a new object, one new Integer(5) will not equal another new Integer(5).

But even more troubling is the following seemingly inexplicable distinction:

```java
System.out.println(Integer.valueOf(127) == Integer.valueOf(127));   // true
System.out.println(Integer.valueOf(128) == Integer.valueOf(128));   // false
```
Huh? How can one of those be true and the other be false? That doesn’t seem to make any sense. Indeed, the answer is quite subtle.

As explained in an easily overlooked note in the Javadoc for the Integer class, the valueOf() method method caches Integer objects for values in the range -128 to 127, inclusive, and may cache other values outside of this range as well. Therefore, the Integer object returned by one call to Integer.valueOf(127) will match the Integer object returned by another call to Integer.valueOf(127), since it is cached. But outside the range -128 to 127, Integer.valueOf() calls, even for the same value, will not necessarily return the same Integer object (since they are not necessarily cached).

It’s also important to note that computation using boxed objects can take around 6 times longer than using primitives, as can be evidenced by way of the following benchmarking code:

```java
void sum() {
	Long sum = 0L; // Swap "Long" for "long" and speed dramatically improves.
	for (long i = 0; i <= Integer.MAX_VALUE; i++) {
		sum += i;
	}
}
```
Executing the above code with sum declared as Long took 9194ms whereas the same code with sum declared as long (i.e., the primitive type) took only 979ms.

You can find the code [here](https://github.com/dineshappavoo/ctgi/blob/master/src/com/ctgi/google/languages/java/codeJavaTest.java)


###Referrences

* [toptal.com](http://www.toptal.com/java/)

