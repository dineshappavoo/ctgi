Abstract Classes
================
An abstract class is a class that is declared using the abstract keyword. 

* An abstract class cannot be instantiated. 
* It can be used only as a super-class for those classes that extend the abstract class. 
* The default functionality of the class still exists, with its fields, methods and constructors being accessed in the same way as with the other classes.

Moreover, an abstract class may contain methods without any implementation, called ```abstract method```. The declaration of an abstract method starts with the abstract keyword and ends with a semicolon, instead of the method’s body. If a class contains an ```abstract method```, either declared or inherited, it must be declared as an abstract class.

A class that extends an abstract class must implement all its abstract methods (if any). Otherwise, the sub-class must be declared as abstract as well. Finally, any implementation of an abstract method can be overridden by additional sub-classes.

Last things to mention are that abstract classes can also implement methods, despite providing just their signature and that an abstract class may have static fields and static methods.

Grid.java abstract class

```java
public abstract class Grid {
	protected String gridId;
	
	public abstract void displaygridID();
}
```
GridVM java abstract class which extends Grid class

```java
public abstract class GridVM  extends Grid {
	protected String vmName;
}
```
And we are going to create two classes which extends GRidVM class

AssasinGame class
```java
public class AssasinGame extends GridVM {

	public AssasinGame() {
		super();
		this.gridId = "grid_12";
		this.vmName = "vm_assasin";
	}
	public AssasinGame(String gridId, String vmName) {
		super();
		this.gridId = gridId;
		this.vmName = vmName;
	}

	@Override
	public void displaygridID() {
		System.out.println("Grid Id : "+gridId+"  VM Name : "+vmName);		
	}
}
```
```java
public class NFSGame extends GridVM{

	public NFSGame() {	
		super();
		this.gridId = "grid_12";
		this.vmName = "vm_assasin";
	}
	public NFSGame(String gridId, String vmName) {
		super();
		this.gridId = gridId;
		this.vmName = vmName;
	}

	@Override
	public void displaygridID() {
		System.out.println("Grid Id : "+gridId+"  VM Name : "+vmName);
	}
}
```
And when a user request for a game , shield service can request for respective game 

```java
public class GameUser {

	public static void main(String[] args) {
		new GameUser().requestGame();
	}
	
	public void requestGame()
	{
		AssasinGame asGame = new AssasinGame();
		NFSGame nfsGame = new NFSGame();
		asGame.displaygridID();
		nfsGame.displaygridID();
		
		AssasinGame asGame1 = new AssasinGame("grid_14","vm_img_gpu13");
		NFSGame nfsGame1 = new NFSGame("grid_15","vm_img_gpu15");
		asGame1.displaygridID();
		nfsGame1.displaygridID();
		
	}
}
``` 

when we run the GameUser class the output would be,

```java
Grid Id : grid_12  VM Name : vm_assasin
Grid Id : grid_12  VM Name : vm_assasin
Grid Id : grid_14  VM Name : vm_img_gpu13
Grid Id : grid_15  VM Name : vm_img_gpu15
```

####Abstract Class vs. Interface

Java provides and supports the creation of abstract classes and interfaces. Both implementations share some common features, but they differ in the following features:

* All methods in an interface are implicitly abstract. On the other hand, an abstract class may contain both abstract and non-abstract methods.
* A class may implement a number of Interfaces, but can extend only one abstract class.
* In order for a class to implement an interface, it must implement all its declared methods. However, a class may not implement all declared methods of an abstract class. Though, in this case, the sub-class must also be declared as abstract.
* Abstract classes can implement interfaces without even providing the implementation of interface methods.
* Variables declared in a Java interface is by default final. An abstract class may contain non-final variables.
* Members of a Java interface are public by default. A member of an abstract class can either be private, protected or public.
* An interface is absolutely abstract and cannot be instantiated. An abstract class also cannot be instantiated, but can be invoked if it contains a main method

You can find the complete source code [here](https://github.com/dineshappavoo/ctgi/tree/master/src/com/ctgi/google/languages/java/code)
###Referrences

* [javacodegeeks.com](http://examples.javacodegeeks.com/java-basics/java-abstract-class-example/)

