package concurrency;

public class Synchronization {

	public static void main(String[] args) throws InterruptedException {
		
	//	instance();
	//	statics();
		block();
	}

	private static void instance() throws InterruptedException {
		Counter counter1 = new Counter();
		Counter counter2 = new Counter();
		
		new UITask(1, () -> counter1.increase()).t.start();
		new UITask(2, () -> counter2.increase()).t.start();
		counter1.increase();
	}
	
	private static void block() throws InterruptedException {
		Counter counter = new Counter();
		
	//	Object mutex1 = new Object();
	//	Object mutex2 = new Object();
		
		Object mutex1 = "hello";
		Object mutex2 = "hello";
	
		UITask uiTask1 = new UITask(1, () -> counter.block(mutex1));
		uiTask1.t.join(); uiTask1.t.start();
		
		UITask uiTask2 = new UITask(2, () -> counter.block(mutex2));
		uiTask2.t.join(); uiTask2.t.start();

		counter.block(mutex1);
	}
	
	private static void statics() throws InterruptedException {
		new UITask(1, () -> Counter.staticIncrease()).t.start();

		new UITask(2, () -> Counter.staticIncrease()).t.start();
		
		Counter.staticIncrease();
	}

}

class UITask implements Runnable {
	
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

class Counter {
	
	synchronized void increase() {
		code();
	}
	
	void block(Object o) {
		synchronized (o) {
			code();
		}
	}

	synchronized static void staticIncrease() {
		code();
	}
	
	private static void code() {
		String name = Thread.currentThread().getName();
		System.out.println("Thread " + name + " has started");
		try {
			if(name.equals("ui-task:1") || name.equals("main"))
				Thread.sleep(7000);
			else
				Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread " + name + " is done");
	}
}

