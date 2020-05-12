package hackerearth;

class Main {
	
	int a = 9;
	int b =9;
	
	private int add() {
		return a+b;
	}
	
	int result() {
		return Main().add();
	}
}

public class Q3 {
	public static void main(String[] args) {
		Main a = new Main();
		System.out.println(2*a.result());
	}
}
