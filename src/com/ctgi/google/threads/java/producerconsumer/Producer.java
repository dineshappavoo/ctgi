/**
 * 
 */
package com.ctgi.google.threads.producerconsumer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

/**
 * @author Dany
 *
 */
public class Producer implements Runnable{


	protected BlockingQueue<String> queue= null;
	Scanner scanner=null;


	public Producer(BlockingQueue<String> queue)
	{
		this.queue=queue;

	}

	public void run()
	{
		try {
			File file = new File("/Users/Dany/Downloads/input.txt");
			scanner = new Scanner(file);
			while(scanner.hasNext()){
				queue.put(scanner.nextLine());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
