/**
 * 
 */
package greedy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author onkesh.bansal
 * 
 *         Greedy algorithms practice problem. Needs to be efficient in time
 *         complexity. Constraints: size of array : 2<=n<=10^5 element value :
 *         -10^9 <= arr[i] <= 10^9
 *
 */
public class MinimumAbsoluteDifference {

	// Complete the minimumAbsoluteDifference function below.
	static int minimumAbsoluteDifference(int[] arr) {

		int min = Math.abs(arr[0] - arr[1]);
		int n = arr.length;

		Arrays.sort(arr);

		for (int i = 2; i < n; i++) {
			int local_min = Math.abs(arr[i] - arr[i-1]);

			if (local_min < min) {
				min = local_min;
			}

		}

		return min;
	}

	/**
	 * @param args
	 * 
	 *             input: -59,-36,-13,1,-53,-92,-2,-96,-54,75 => output = 1
	 * 
	 *             input: 1,-3,71,68,17 => output = 3
	 * @throws IOException
	 * 
	 */
	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\onkesh.bansal\\Desktop\\hr\\min-abs-diff-1.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

		String s1 = bufferedReader.readLine();
		int n = Integer.parseInt(s1);

		String[] s2 = bufferedReader.readLine().split(" ");
		int[] arr = Stream.of(s2).mapToInt(Integer::parseInt).toArray();

		long start = System.nanoTime();
		// --------------------CODE START--------------------------
		int res = minimumAbsoluteDifference(arr);
		System.out.println(res);

		// --------------------CODE FIN----------------------------
		long end = System.nanoTime();
		long elapsed = end - start;
		System.out.println("Elapsed : " + elapsed + " nano secs");

		bufferedReader.close();
	}

}
