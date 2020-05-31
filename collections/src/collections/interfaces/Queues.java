package collections.interfaces;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Queues {

	public static void main(String[] args) {
		
		Queue<Number> q1 = new ArrayDeque<Number>();
		q1.add(1);
		q1.add(2);
		q1.add(3);
		
		System.out.println(q1.element());
		
		System.out.println(q1.offer(4));
		System.out.println(q1.add(4));
		
		q1.poll();
		System.out.println(q1);
		q1.peek();
		System.out.println(q1);
		
		q1.clear();
		q1.poll();
		q1.peek();
		//q1.remove();
		
		Deque<Number> q2 = new ArrayDeque<Number>();
		q2.add(1);
		q2.add(4);
		q2.add(2);
		q2.add(1);
		q2.add(3);
		q2.removeFirstOccurrence(1);
		System.out.println(q2);
		q2.removeLastOccurrence(1);
		System.out.println(q2);
	}
	
}
