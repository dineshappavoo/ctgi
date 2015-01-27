/**
 * 
 */
package com.ctgi.google.threads;

import java.util.concurrent.BlockingQueue;

/**
 * @author Dany
 *
 */
public class Producer implements Runnable{


	protected BlockingQueue<String> queue= null;

	public Producer(BlockingQueue<String> queue)
	{
		this.queue=queue;
	}

	public void run()
	{
		try {
			while(true)
			{
				queue.put("a");
				Thread.sleep(1000);
				queue.put("b");
				Thread.sleep(1000);
	            queue.put("c");

			}

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
