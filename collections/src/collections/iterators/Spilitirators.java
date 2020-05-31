package collections.iterators;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Spilitirators {

	public static void main(String[] args) {

		List<String> l = List.of("one", "two", "three", "four");

		Spliterator<String> sp = l.spliterator();

		while (sp.tryAdvance(i -> System.out.println(i)))
			;

		l = Stream.generate(() -> "one").limit(5000).collect(Collectors.toList());
		sp = l.spliterator();
		Spliterator<String> sp2 = sp.trySplit();

		System.out.println(sp.estimateSize() + " " + sp2.estimateSize());
		System.out.println(sp.getExactSizeIfKnown() + " " + sp2.getExactSizeIfKnown());

		System.out.println(sp.hasCharacteristics(Spliterator.NONNULL));
		System.out.println(sp.hasCharacteristics(Spliterator.SORTED));
		
		try {
			System.out.println(sp.getComparator());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		Set<String> s = new TreeSet<String>();
		try {
			System.out.println(s.spliterator().getComparator());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		s = new TreeSet<String>((x, y) -> x.length() - y.length());
		try {
			System.out.println(s.spliterator().getComparator());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(s.spliterator().hasCharacteristics(Spliterator.SORTED));
		
		/***************************************************/
		
		List<Integer> ints = List.of(1, 2, 3);
		Spliterator.OfInt sint = ints.stream().mapToInt(Integer::intValue).spliterator();
		
	}
}
