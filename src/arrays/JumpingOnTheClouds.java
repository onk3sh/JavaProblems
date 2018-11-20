package arrays;

import java.util.Scanner;

public class JumpingOnTheClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
    	int jumps = 0,i = 0,n=c.length;
        while(i < n-3) //goes through all clouds up until the last jump
        {
            i += (c[i+2] == 0) ? 2 : 1;
            jumps++;                
        }
        
        jumps++;
        return jumps;
    }
    
    
    private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		 int n = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        int[] c = new int[n];

	        String[] cItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < n; i++) {
	            int cItem = Integer.parseInt(cItems[i]);
	            c[i] = cItem;
	        }

	        int result = jumpingOnClouds(c);
	        System.out.println(result);
	        scanner.close();
	}

}
