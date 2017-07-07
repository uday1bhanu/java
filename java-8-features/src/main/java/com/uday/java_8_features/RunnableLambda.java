/**
 * 
 */
package com.uday.java_8_features;

/**
 * @author udaybhanuprasad
 *
 */
public class RunnableLambda {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = () -> {
			for(int i=0; i<3; i++){
				System.out.println("Hello world from thread ["+ Thread.currentThread().getName()+"]");
			}
		};
		Thread t = new Thread(runnable);
		t.start();
		t.join();
	}

}
