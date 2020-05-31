package collections.interfaces;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;

public class Lists {

	public static void main(String[] args) {
		
		Comparator<Float> fc = (x, y) -> x.byteValue() - y.byteValue();
		Comparator<Object> oc = (x, y) -> x.hashCode() - y.hashCode();

		UnaryOperator<Object> o = i -> i;
		UnaryOperator<Number> n = i -> i.doubleValue()*10;
		
		List<Number> nums = new ArrayList<Number>();
		nums.add(22);
		nums.add(22.5);
		nums.add(22.5f);
	//	nums.sort(fc);
		nums.sort(oc);
		
		List<Number> n2 = nums.subList(0, 1);
		System.out.println(nums);
		n2.clear();
		System.out.println(nums);
		
		System.out.println("**************");

	//	nums.replaceAll(f);
		nums.replaceAll(n);
		System.out.println(nums);
	
		
	}
	
}
