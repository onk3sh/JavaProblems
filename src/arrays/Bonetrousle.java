package arrays;

import java.io.IOException;
import java.util.Scanner;

public class Bonetrousle {
	
	static long[] bonetrousle(long n, long k, int b) {
//		n = expected_number_of_spagetti;
//		k = total_boxes_in_store;
//		b = number_of_boxes_to_buy;
		boolean possible = true;
		long sum_min = (b*(b+1))/2;
		long sum_max = (b*((2*k)-b+1))/2;
		
		if(n < sum_min || n > sum_max)
			possible = false;
		
		long[] res = new long[b];
		
		if(!possible) {
			long[] res_fail = {-1};
			return res_fail;
		}
		
		return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nkb = scanner.nextLine().split(" ");

            long n = Long.parseLong(nkb[0].trim());
            long k = Long.parseLong(nkb[1].trim());
            int b = Integer.parseInt(nkb[2].trim());

            long[] result = bonetrousle(n, k, b);

            for (int resultItr = 0; resultItr < result.length; resultItr++) {
                System.out.print(String.valueOf(result[resultItr]));

                if (resultItr != result.length - 1) {
                	System.out.print(" ");
                }
            }

            System.out.println();
        }

    }

}
