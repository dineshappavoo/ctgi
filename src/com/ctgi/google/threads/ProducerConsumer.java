/**
 * 
 */
package com.ctgi.google.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Dany
 *
 */
public class ProducerConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ProducerConsumer().startProducerConsumerThread();
	}

	public void startProducerConsumerThread()
	{
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		try {
			new Thread(producer).start();
			new Thread(consumer).start();
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
