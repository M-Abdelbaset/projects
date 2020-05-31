package test1;

public class Initialization {

	static class Student{
		public Student(Object o, int x) {
			System.out.println(o + " "+ x +" called");
		}
	}
	
	static class Parent{
		
		public Parent() {
			System.out.println("parent constructor");
		}
		
		{
			Student o3 = new Student(Parent.class, 7);
		}
		Student o1 = new Student(Parent.class, 8);
		Student o2 = new Student(Parent.class, 9);
		
		static Student s1 = new Student(Parent.class, 0);
		
		static {
			Student s2 = new Student(Parent.class, 1);
		}
		
		static Student s6 = new Student(Parent.class, 6);
		
	}
	
	static class Child extends Parent{
		
		public Child() {
			System.out.println("child constructor");
		}
		
		Student o1 = new Student(Child.class, 3);
		Student o2 = new Student(Child.class, 4);
		{
			Student o3 = new Student(Child.class, 5);
		}
		
		static Student s1 = new Student(Child.class, 0);
		
		static {
			final Student s2 = new Student(Child.class, 1);		
			s6 = null;
		}
		
		static Student s3 = new Student(Child.class, 2);
		
	}
	
	public static void main(String[] args) {
/*
		new Parent();
		System.out.println("*******");
		new Child(); //will not re-initialize static fields of parent as it has been initialized.
		System.out.println("*******");
		new Child(); //no static initialization at all!
*/	
		/***********************************************/
		
		Student p = Parent.s1; //initialize Parent static members only
		System.out.println("*******");
		Student c = Child.s6; //does nothing!
		System.out.println("*******");
		c = Child.s1; //initialize Child static members only
	}

}
