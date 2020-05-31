package collections.classes;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queues {

	public static void main(String[] args) {
		
		Queue<Number> q1 = new PriorityQueue<Number>();
		q1.add(2);
		q1.add(7);
		q1.add(0);
		
		Iterator<Number> it = q1.iterator();
		while(it.hasNext())
			System.out.print(it.next() + " ");
		
		System.out.println();
		
		while(q1.size() > 0)
			System.out.print(q1.poll() + " ");
		
		
		System.out.println();
		q1.add(2);
		q1.add(7);
		q1.add(0);
		
		Object[] arr = q1.toArray();
		for(Object n : arr)
			System.out.print((Number)n + " ");
		
		Arrays.sort(arr);
		
		for(Object n : arr)
			System.out.print((Number)n + " ");
		
		System.out.println();
		
		q1 = new ArrayDeque<Number>();
		q1.add(2);
		q1.add(7);
		q1.add(0);
		arr = q1.toArray();
		for(Object n : arr)
			System.out.print((Number)n + " ");
		
		
	}
}
