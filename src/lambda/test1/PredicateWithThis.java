package lambda.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateWithThis {

	public static void main(String[] args) {

		// Init List
		List<Person> pers = new ArrayList<>();
		pers.add(new Person("Piet", "Jansen"));
		pers.add(new Person("Kees", "Plozen"));
		// Init single Person
		Person x = new Person ("Kees", "Plozen");
	
		// using variables that contain lambdas 
		System.out.println(x.printCustom(Person.firstLast));
		System.out.println(x.printCustom(Person.lastFirst));
		
		// using lambda
		System.out.println(x.printCustom(f -> "*" + f.givenname + "*"));
		
		// using anonymous method
		System.out.println(x.printCustom(new Function<Person, String>() {
			@Override
			public String apply(Person f){
				return "=" + f.lastname + "=";
			}
		}));
			
		// using a stream
		pers.stream()
			.filter( ((Predicate<Person>) p -> p.givenname.contains("i")).or(p -> p.givenname.contains("e")))
			.forEach(p -> System.out.println("s" + p.givenname + "!"));
	}
	
}

class Person {
	String givenname, lastname;
	Person(String g, String l){
		givenname = g; lastname = l;
	}
	
	static Function<Person,String> firstLast = p -> p.givenname + " " + p.lastname;
	static Function<Person,String> lastFirst = p -> p.lastname + " " + p.givenname;
	
	public String printCustom(Function <Person, String> f){
		return f.apply(this); 
	}
}