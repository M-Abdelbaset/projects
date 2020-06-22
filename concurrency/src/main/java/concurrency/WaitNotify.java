package concurrency;

import java.util.UUID;

public class WaitNotify {

	public static void main(String[] args) throws InterruptedException {
		
		Counter counter = new Counter();
		
		UITask uiTask1 = new UITask(0, () -> counter.waits());
		uiTask1.t.start();
		new UITask(1, () -> counter.waits()).t.start();
		new UITask(2, () -> counter.waits()).t.start();
		
		Thread.sleep(5000);
		counter.notifies();
	}

	static class UITask implements Runnable {

		Thread t;
		MyRunner myRunner;

		public UITask(int id, MyRunner myRunner) {
			this.myRunner = myRunner;
			t = new Thread(this, "ui-task:" + id);
		}

		public void run() {
			myRunner.run();
		}
	}

	interface MyRunner {
		void run();
	}

	static class Counter {
		void waits() {
			String name = Thread.currentThread().getName() + " " + UUID.randomUUID().toString();
			System.out.println("blocked:" + name);
			synchronized (this) {
				System.out.println(name + " acquired the monitor");
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("done:" + name);
		}
		
		void notifies() {
			System.out.println("notifies");
			synchronized (this) {
				notifyAll();
			}
		}
		
		void access() {
			System.out.println("accessed by " + Thread.currentThread().getName());
		}
		
		synchronized void accessSynch() {
			System.out.println("accessed by " + Thread.currentThread().getName());
		}
	}
	
}
