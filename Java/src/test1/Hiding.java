package test1;

import static test2.Diamond.*;
import static test2.Diamond2.*;

public class Hiding {

	int x;
    	
	public Hiding() {
	//	this(x);
	}
	
	public Hiding(int y) {
		
	}
	
	void test1() {
		test2(this.x);
	}
	
	void test2(int x) {}
	
	
	static class P{
		
		int x = 1;
		static int y = 1;
		
		static void test() {
			System.out.println("P");
		}
		
		void test2() {
			System.out.println("Pi");
		}
	}
	
	static class C extends P{
		
		int x = 2;
		int y = 2;
		
		static void test() {
			System.out.println("c");
		}
				
		void test2() {
			System.out.println("ci");
		}
	}
	
	public static void main(String[] args) {
		P p = new C();
		
		p.test2();
		P.test();
		System.out.println(p.x);
		System.out.println(p.y);
	
		C c = new C();
		System.out.println(c.x);
		System.out.println(c.y);
	
	}
	
}
