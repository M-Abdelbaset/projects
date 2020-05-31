package collections.legacy;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;

public class Legacy {

	public static void main(String[] args) {
		
		Vector<String> vec = new Vector<String>();
		vec.add("one");
		vec.add("two");
		vec.add("three");
		
		Enumeration<String> en = vec.elements();
		while(en.hasMoreElements()) {
			String nxt = en.nextElement();
			System.out.println(nxt);
			if(nxt == "two")
				break;
		}
		
		Iterator<String> it = en.asIterator();
		while(it.hasNext())
			System.out.println(it.next());
		
		Dictionary<Student, String> dic = new Hashtable<Student, String>();
		dic.put(new Student(1), "1");
	//	dic.put(new Student(1), null);
		System.out.println(dic);
		
		System.out.println(new Student(1).hashCode());
		
		Properties props = new Properties();
		Set<Object> keys = props.keySet();
		
	}
}

class Student {
	
	public int age;
	
	public Student() {}
	
	public Student(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student [age=" + age + "]";
	}
	
	
}
