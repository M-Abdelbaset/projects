package generics;

import java.util.List;

public interface GenInt<T extends Comparable<T>> {

	T get();

}

interface GenInt2<T> {

	T get();

}

interface GenInt3<Number> {

	void get();

}

//
class GenIntImpl<T extends Comparable<T>> implements GenInt<T> {

	@Override
	public T get() {
		final var x = 9;
		int var = x;
		return null;
	}

}

class GenIntImpl5<T extends Comparable<T>> implements GenInt<T> {

	@Override
	public T get() {
		return null;
	}

}

//you can specify the type more if it was general in the interface
class GenIntImpl2<T extends Comparable<T>> implements GenInt2<T> {

	@Override
	public T get() {
		return null;
	}

}


class GenIntImpl3<T extends Comparable<T>> implements GenInt3 {

	@Override
	public void get() {
		
	}

}
