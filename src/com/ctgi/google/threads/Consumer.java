/**
 * 
 */
package com.ctgi.google.threads;

import java.util.concurrent.BlockingQueue;

/**
 * @author Dany
 *
 */
public class Consumer implements Runnable{

	
	BlockingQueue<String> queue = null;
	
	public Consumer(BlockingQueue<String> queue)
	{
		this.queue = queue;
	}
	public void run()
	{
		try {
			System.out.println(queue.take());
			System.out.println(queue.take());
			System.out.println(queue.take());

		} catch (InterruptedException e) {
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
