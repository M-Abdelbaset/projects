package concurrency;

import java.util.concurrent.Semaphore;

public class UsingSemaphores {

	static Semaphore semaphore = new Semaphore(0);
	static Thread main = Thread.currentThread();
	
	public static void main(String[] args) {
		
		new Thread(new Releaser()).start();
		
		try {
			semaphore.acquire(2);
			System.out.println("main accessed");
			semaphore.acquire();
			System.out.println("main accessed");
			new Thread(new Accessor()).start();
			new Thread(new Accessor()).start();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	static class Releaser implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(7000);
				//main.interrupt();
				semaphore.release(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class Accessor implements Runnable {

		@Override
		public void run() {
			try {
				semaphore.acquire();
				System.out.println("hello from accessor");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
