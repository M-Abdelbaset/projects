package collections.classes;

import java.util.ArrayList;
import java.util.List;

public class Lists {

	public static void main(String[] args) {
		
		ArrayList<String> l = new ArrayList<String>();
		l.ensureCapacity(5);
		System.out.println(l.size());
		
		List<Number> l2 = new ArrayList<Number>();
		l2.add(1);
		l2.add(0.5);
	}
	
}
