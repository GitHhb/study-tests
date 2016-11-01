package lambda.test1;

import java.util.function.BiFunction;

public class TestMyself {

	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> f = (x, y) -> x + y;
		System.out.println("Sum: " + mathOp(2, 3, f));
	}
	
	static <T> T mathOp(T a, T b, BiFunction<T, T, T> op) {
		return op.apply(a, b);
		
	}
}
