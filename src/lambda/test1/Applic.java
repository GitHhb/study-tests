package lambda.test1;

import java.util.function.Predicate;

public class Applic {
	
	static String[] myarr = {"Abel", "Piet", "Keesje", "Jan", "Truus"};
	
	public static void main(String[] args) {
		System.out.println("=== Anonymous class ===");
		// anonymous class
		printArray(myarr, new Selection(){
			@Override
			public boolean criteria(String s){
				if (s.compareTo("K") >= 0)
					return false;	
				return true;
			}
		});
		
		System.out.println("=== Lambda expression ===");
		// lambda expression
		printArray(myarr,
			(String s) -> (s.length() > 4) ? true : false
		);
		
		System.out.println("=== Lambda expression ===");
		// lambda expression
		printArray(myarr,
			x -> (x.length() <= 4) ? true : false
		);
		
		System.out.println("=== Lambda expression with extern definition ===");
		Selection tooLong = k -> (k.length() > 4) ? true : false;
		// lambda expression
		printArray(myarr, tooLong);
		
		System.out.println("=== Lambda expression with extern definition and Predicate ===");
		Predicate<String> pred = s -> s.contains("e");
		printArray1(myarr, pred);
		
	}
	
	static void printArray(String[] arr, Selection select){
		for (String s: myarr) {
			if (select.criteria(s))
			System.out.println(s);
		}
	}
	
	static void printArray1(String[] arr, Predicate<String> select){
		for (String s: myarr) {
			if (select.test(s))
			System.out.println(s);
		}
	}
	

}

interface Selection {
	boolean criteria(String s);
}
