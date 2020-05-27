/**
 * 
 */
package arrays;

import java.util.*;

/**
 * @author onkesh.bansal
 *
 */
public class MigratoryBirds {

	/*
	 * Your task is to print the type number of that bird and ****if two or more
	 * types of birds are equally common, choose the type with the smallest ID
	 * number ****.
	 * 
	 * link: https://www.hackerrank.com/challenges/migratory-birds
	 */

	// Complete the migratoryBirds function below.
	static int migratoryBirds(List<Integer> arr) {
		int[] count = new int[6];
		int max = 0;

		for (int sighting : arr) {
			count[sighting]++;
		}

		for (int i = 0; i < count.length; i++) {
			max = Math.max(max, count[i]);
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] == max)
				return i;
		}

		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4 }; // output = 3
		List<Integer> list = new ArrayList<>();

		for (int i : arr)
			list.add(i);

		System.out.println(migratoryBirds(list));
	}

}
