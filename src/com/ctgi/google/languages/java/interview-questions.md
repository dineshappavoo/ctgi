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
 

###Referrences

* [gribblelab.org](http://gribblelab.org/CBootcamp/7_Memory_Stack_vs_Heap.html)

