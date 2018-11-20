package numbers;

public class FibbonacciSimple {
	
	//Iterative method
	public static void fib(int n) {
		int[] res = new int[25];
		res[0] = 0; 
		res[1] = 1; 
		for(int i=0;i<=n;i++) {
			res[i+2] = res[i+1] + res[i];
		}
		
		if(n>0) {
			for(int i = 0;i<n;i++)
				System.out.println(res[i]);
		}
		else if (n<=0){
			System.out.println("Length of seris can't be Zero or Negative");
		}	
	}
	
	public static void main (String[] args){
		long startTime = System.nanoTime();
		fib(11);
		long endTime   = System.nanoTime();
		System.out.println("Execution time::"+(endTime - startTime)+" nanoseconds");
	}
}
