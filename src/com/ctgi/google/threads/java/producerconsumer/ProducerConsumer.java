/**
 * 
 */
package com.ctgi.google.threads.producerconsumer;

import java.io.FileNotFoundException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Dany
 *
 */
public class ProducerConsumer {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		new ProducerConsumer().startProducerConsumerThread();
	}

	public void startProducerConsumerThread() throws FileNotFoundException
	{
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);
		Producer producer = new Producer(queue);
		Consumer consumerOne = new Consumer(queue);
		Consumer consumerTwo = new Consumer(queue);
		try {
			new Thread(producer).start();
			new Thread(consumerOne).start();
			new Thread(consumerTwo).start();
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
