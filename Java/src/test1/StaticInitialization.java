package test1;

public class StaticInitialization {

	static class Student{
		public Student(Object o, int x) {
			System.out.println("student of: " +o + " "+ x +" called");
		}
	}
	
	static class Parent{
		static final Student sf = new Student(Parent.class, 10);
		
		static Student s1 = new Student(Parent.class, 0);
		
		static {
			Student s2 = new Student(Parent.class, 1);
		}
		
		static Student s6 = new Student(Parent.class, 6);
		
		
	}
	
	static class Child extends Parent{
		static Student s1 = new Student(Child.class, 0);
		
		static {
			final Student s2 = new Student(Child.class, 1);		
			s6 = null;
		}
		
		static Student s3 = new Student(Child.class, 2);
		
	}
	
	
	public static void main(String[] args) {
		
//		Child c = new Child(); //loads all & initializes all
//		System.out.println(Child.class); //causes class loading (not initialization)
		
		System.out.println("start");
		System.out.println(Parent.s1);
//		Student s222 = Child.s1; //since s1 defined is in child also, this initializes parent & child
		/*
		 * Student s22 = Child.s6; // since s6 defined is in parent only, this only
		 * initializes parent System.out.println("***"); Student s = Parent.s6; // this
		 * will load and initialize parent only System.out.println("***"); Student s2 =
		 * Child.s6; // this will load Child but not initialize it as s6 is defined in
		 * parent only, // so it's accessed by child as if it was parent.
		 * System.out.println("***"); s2 = Child.s1; // this loads and initializes
		 * child[but not parent] to get value of s1 that is // defined in child
		 * System.out.println("***");
		 * 
		 * System.out.println("end");
		 */		
	}
	
}
