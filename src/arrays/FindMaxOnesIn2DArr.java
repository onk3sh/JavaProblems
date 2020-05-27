/**
 * 
 */
package arrays;

import java.time.Duration;
import java.time.Instant;

/**
 * @author onkesh.bansal
 *
 */
public class FindMaxOnesIn2DArr {

	private static int customBinarySearch(int[] arr, int start, int end) {
		if (start <= end) {
			int mid = start + (end - start) / 2;

			if ((mid == end || arr[mid + 1] == 1) && (arr[mid] == 0)) {
				return mid + 1;
			}

			if (arr[mid] == 0) {
				return customBinarySearch(arr, mid + 1, end);
			}

			return customBinarySearch(arr, start, mid - 1);
		}

		return -1;
	}

	public static int maxOnes(int[][] arr) {
		int max = -1;
		int temp_max = -1;
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			int[] temp = new int[n];
			for (int j = 0; j < n; j++) {
				temp[j] = arr[i][j];
			}
			temp_max = customBinarySearch(temp, 0, arr.length - 1);
			max = Math.max(max, n - temp_max);
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] arr = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 1 }, { 0, 1, 1, 1, 1 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 1 } };

		Instant start = Instant.now();
		// CODE HERE
		System.out.println(maxOnes(arr));
		// CODE HERE
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println("Time elapsed=" + timeElapsed + " ms");
	}
}
