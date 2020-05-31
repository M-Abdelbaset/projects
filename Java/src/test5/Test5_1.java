package test5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Test5_1 {

	static int X = 1;
	static boolean a,b,c;
	
	public static void main(String[] args) throws IOException {

		boolean b = (1 > 2) ? true : false;

		File f = new File("");
//		FileInputStream fis = new FileInputStream(f);

		try (FileInputStream fis = new FileInputStream(f)) {

		}catch(Exception ex) {
		}
		finally {

		}
		
		Test5_1 t = null;
		System.out.println(t.X);
		boolean b2 = (a=true)||(b=true)&&(c=true);
		System.out.println(a + " " + b + " " + c);
	}

	static class Base {

		public <T> Collection<T> transform(Collection<T> list) {
			return new ArrayList<T>();
		}
	}

	static class Derived extends Base {
		// public <T> Collection<T> transform(Collection<T> list) { return new HashSet<String>(); }; //1

		// public <T> Collection<T> transform(Stream<T> list) { return new HashSet<T>();}; //2

		//@Override
		// public <T> List<T> transform(Collection<T> list) { return new ArrayList<T>();}; //3
		
		//@Override
		// public <X> Collection<X> transform(Collection<X> list) { return new HashSet<X>();}; //4

//		 public Collection<CharSequence> transform(Collection<CharSequence> list) {return new HashSet<CharSequence>();}; //5

	}

}
