/**
 * 
 */
package com.ctgi.google.languages.java.code;

/**
 * @author Dany
 *
 */
public class JavaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaTest testJava = new JavaTest();
		testJava.testBoxing();
		long startTime = System.currentTimeMillis();
		testJava.boxingBenchMarking();
		long endTime = System.currentTimeMillis();
		System.out.println("Time Taken for boxing data type: "+(endTime-startTime));
		
		startTime = System.currentTimeMillis();
		testJava.primitiveBenchMarking();
		endTime = System.currentTimeMillis();
		System.out.println("Time Taken for primitive data type: "+(endTime-startTime));

	}

	public void testBoxing()
	{
		System.out.println(new Integer(5) == new Integer(5));

		System.out.println(Integer.valueOf(127) == Integer.valueOf(127));   // true
		System.out.println(Integer.valueOf(128) == Integer.valueOf(127));   // false
	}

	public void boxingBenchMarking()
	{
		Long sum = 0L; // Swap "Long" for "long" and speed dramatically improves.
		for (long i = 0; i <= Integer.MAX_VALUE; i++) {
			sum += i;
		}
	}
	
	public void primitiveBenchMarking()
	{
		long sum = 0L; // Swap "Long" for "long" and speed dramatically improves.
		for (long i = 0; i <= Integer.MAX_VALUE; i++) {
			sum += i;
		}
	}

}
