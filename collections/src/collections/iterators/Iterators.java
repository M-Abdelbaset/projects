package collections.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Iterators {

	public static void main(String[] args) {
		
		List<String> l = new ArrayList<String>();
		l.add("one");
		l.add("two");
		l.add("three");
		
		Iterator<String> i = l.iterator();
		
		i.forEachRemaining(item -> System.out.print(item + " "));
		
		while(i.hasNext()) {
			if(i.next() == "one") i.remove();
		}
		
		System.out.println(l);
		
		ListIterator<String> li = l.listIterator();
		
		
		System.out.println(l);
		while(li.hasNext()) {
			System.out.print(li.nextIndex() + " ");
			System.out.print(li.previousIndex() + " ");
			li.set(li.next() + " + ");
			System.out.println();
		}
		
		li.add("one");
//		l.remove(0);
		/*
		li = l.listIterator();
		li.next();
		li.remove();
		*/
		while(li.hasPrevious()) {
			System.out.print(li.previous() + " ");
		}
		
		for(int j = 0; j < l.size(); j++)
			l.add(j+"");
	
	//	li = l.listIterator();
		li.forEachRemaining(ii -> li.add(ii+"*"));
	}
	
}



