package enums;

enum MyEnum implements EnumI{

	AHMED(1, 100){
		@Override
		public int add() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	},
	
	
	
	MOHAMED(2){
		@Override
		public int add() {
			// TODO Auto-generated method stub
			return 0;
		}
	}, 
	
	
	SARA{
		@Override
		public int add() {
			return 100;
		}
	};
	
	private int age;
	private int weight;
	
	MyEnum() {}
	
	MyEnum(int age) {
		this.age = age;
	}
	
	private MyEnum(int age, int weight) {
		this(age);
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public int getWeight() {
		return weight;
	}
	
}

interface EnumI{
	int add();
	
}

public class Main{
	
	public static void main(String[] args) {
		System.out.println(MyEnum.AHMED.add());
		System.out.println(MyEnum.SARA.add());
		System.out.println(MyEnum.MOHAMED.add());

	}
	
}