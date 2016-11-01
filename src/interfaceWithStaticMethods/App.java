package interfaceWithStaticMethods;

public class App {
	public static void main(String[] args) {
		
		Interf.m1();
		System.out.println("Value of i1: " + Interf.i1);
		
	}

}

interface Interf {
	static int i1 = 1;
	static void m1() {System.out.println("In static interface");}
	
}
