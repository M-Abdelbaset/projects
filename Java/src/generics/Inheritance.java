package generics;

public class Inheritance {

	public static void main(String[] args) {

		y y1 = new y();
		String s = y1.test();

	}

}

class x {
	Object test() {
		return "parent";
	}
}

class y extends x {
	@Override
	String test() {
		return "sub";
	}
}

interface i<T extends x> {
}

class C<T extends y> implements i<x> {
}
