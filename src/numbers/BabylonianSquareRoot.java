/**
 * 
 */
package numbers;

/**
 * @author onkesh.bansal
 *
 */
public class BabylonianSquareRoot {
	
	private static double calculateSquareRoot(int n) {
		double in = n - 1;
//		if(n > 2 && n % 4 != 0) in = in/2;
		
		double out = 0;
		
		for(int i = 0; i<100; i++) {
			out = (in + n/in)/2;
			if(out % 1 == 0)
				break;
			
			in = out;
		}
		return out;
	}
	
	public static boolean isPerfectSquare(int n) {
		boolean res = false;
		if(n == 1) return true;
		
		if(n > 1) {
			if(calculateSquareRoot(n) % 1 == 0)
				res = true;
		}
		
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long start = System.nanoTime();
		for(int i = 1; i<=100; i++) {
			System.out.println(i+" : "+isPerfectSquare(i));
		}
		

		
		long end = System.nanoTime();
		long elapsed = end - start;
		System.out.println("Elapsed="+elapsed+" nano seconds");
	}

}
