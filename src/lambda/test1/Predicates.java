package lambda.test1;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Create lambda functions using predicates
 * 
 * @author leandro
 *
 */

public class Predicates {

	static String[] myarr = { "Abel", "Piet", "Keesje", "Jan", "Truus" };

	public static void main(String[] args) {

		printArray(myarr, a -> a.length() < 5, a -> System.out.println(a));

		printArrayBi(myarr, a -> a.contains("s"), (b, c) -> System.out.println(b + " - " + c));

		new ArrayList<String>(Arrays.asList(myarr)).forEach(p -> {
			System.out.print("-+- ");
			System.out.println(p);
		});

		printArrayStream(myarr);
	}

	static void printArray(String[] arr, Predicate<String> select, Consumer<String> doit) {
		for (String s : arr)
			if (select.test(s))
				doit.accept(s);
	}

	static void printArrayBi(String[] arr, Predicate<String> select, BiConsumer<String, String> doit) {
		for (String s : arr)
			if (select.test(s))
				doit.accept("Biconsume", s);
	}

	static void printArrayStream(String[] arr) {
		new ArrayList<String>(Arrays.asList(arr)).
		forEach(p -> {
			System.out.print("+++ ");
			System.out.println(p);
		});

	}

}
