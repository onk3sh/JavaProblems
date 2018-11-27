package numbers;

public class FibbonaciRecursive {
	
	public static int fib(int n) {
		if(n<=0) return 0;
		if(n > 0 && n < 2) return 1;
			
		return fib(n-1) + fib(n-2);
	}

	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		
		// TODO Auto-generated method stub
		for(int i = 0; i<=10; i++) {
			System.out.println(fib(i));
		}
		
		long endTime   = System.nanoTime();
		System.out.println("Execution time::"+(endTime - startTime)+" nanoseconds");

	}

}
