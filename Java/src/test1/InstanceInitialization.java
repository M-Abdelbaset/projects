package test1;

public class InstanceInitialization {

	static class Student{
		public Student(Object o, int x) {
			System.out.println(o + " "+ x +" called");
		}
	}
	
	static class Parent{
		
		public Parent() {
			//constructor does not create object, it initializes it.
			//new does create the object
			
			System.out.println("parent constructor");
		}
		
		{
			Student s3 = new Student(Parent.class, 3);
			System.out.println(this);
		}
		Student s1 = new Student(Parent.class, 1);
		Student s2 = new Student(Parent.class, 2);
		
	}
	
	static class Child extends Parent{
		
		public Child() {
			System.out.println("child constructor");
		}
		
		Student s1 = new Student(Child.class, 1);
		Student s2 = new Student(Child.class, 2);
		{
			Student s3 = new Student(Child.class, 3);
		}
	}
	
	public static void main(String[] args) {
		new Parent();
		System.out.println("*******");
		new Child();
		System.out.println("*******");
		new Child();
	}
	
}
