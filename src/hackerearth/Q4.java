package hackerearth;

public class Q4 {
	
	private static int x=10;
	private static int y=10;
	
	private Q4() {
		this(5);
	}
	
	private Q4(int x) {
		this(x,y);
	}
	
	private Q4(int x, int y) {
		System.out.println(x*y);
	}
	
	public static void main(String[] args) {
		Q4 a = new Q4();
	}

}
