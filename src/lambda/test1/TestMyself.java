package lambda.test1;

import java.util.function.BiFunction;

public class TestMyself {

	public static void main(String[] args) {
		
		BiFunction<Integer, Integer, Integer> f = (x, y) -> x + y;
		System.out.println("Sum: " + mathOp(2, 3, f));

		BiFunction<String, String, String> c = (x, y) -> x + y;
		System.out.println("Concat: " + mathOp("Hal", "lo", c));

		BiFunction<Integer, Integer, String> a = (x, y) -> {return x.toString() + y.toString();};
		System.out.println("Concat: " + mathOp(3, 5, a));
	}
	
	static <R, S, T> T mathOp(R a, S b, BiFunction<R, S, T> op) {
		return op.apply(a, b);
		
	}
}
