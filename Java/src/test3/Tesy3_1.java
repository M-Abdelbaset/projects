package test3;

public class Tesy3_1 {

	static class Speak {
		public static void main(String[] args) {
			Speak s = new GoodSpeak();
			((Tone)s).up();
		}
	}

	static class GoodSpeak extends Speak implements Tone {
		public void up() {
			System.out.println("UP UP UP");
		
			int x;
			 Integer ii = new Integer(5);
			switch(ii){
		//	case ii: for(x = 0;;);
			
			}
		}
		
		int get() {
			return(1);
		}
		
		
	}

	static interface Tone {
		void up();
	}
	
	
	class X{
		public void test() {}
	}
	class Y extends X{
	//	public static void test() {}
	}
	
	public static void main(String[] args) {
		
		Object o = new Object();
		String s = (String) o;
		
		
	}
	
	
}
