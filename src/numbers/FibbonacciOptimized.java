package numbers;

import java.util.HashMap;
import java.util.Map;

public class FibbonacciOptimized {
	
	public static void fib(int n) {
		Map<Integer,Long> m = new HashMap<Integer,Long>();
		m.put(0, (long) 0);
		m.put(1, (long) 1);
		for(int i = 2; i<=n; i++) {
			if(!m.containsKey(i)){
				m.put(i, m.get(i-1) + m.get(i-2));
			}
		}
		
		for(int i = 0; i<=n;i++)
			System.out.println(m.get(i));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
		fib(11);
		long endTime   = System.nanoTime();
		System.out.println("Execution time::"+(endTime - startTime)+" nanoseconds");
	}

}
