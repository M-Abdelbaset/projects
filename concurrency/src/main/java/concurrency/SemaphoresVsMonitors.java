package concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoresVsMonitors {

	public static void main(String[] args) {
		Resource1 r1 = new Resource1();
		r1.a();
		Resource2 r2 = new Resource2();
		r2.a();
		
	}
	
	static class Resource1 {
		synchronized void a() {
			System.out.println("A");
			b();
		}
		
		synchronized void b() {
			System.out.println("B");
		}
	}
	
	static class Resource2 {
		Semaphore s = new Semaphore(1);
		
		void a() {
			try {
				s.acquire();
				System.out.println("A");
				b();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		void b() {
			try {
				s.acquire();
				System.out.println("B");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
