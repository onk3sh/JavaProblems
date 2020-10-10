/**
 * 
 */
package arrays;

import java.util.*;

/**
 * @author onkesh.bansal
 * 
 *         The following program calculates the largest sequence of GCD for a
 *         given list of integers. And returns the list subsequence for the size
 *         that's greater than or equal to k where k is provided by the user as
 *         the output size of the list.
 *
 */
public class GCDSubsequence {

	static Map<Integer, List<Integer>> getFactors(int[] arr) {

		Arrays.sort(arr);
		Map<Integer, List<Integer>> map = new LinkedHashMap<>();

		for (int i = arr.length - 1; i >= 0; i--) {
			List<Integer> temp = new ArrayList<>();
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] % arr[i] == 0)
					temp.add(arr[j]);
			}
			map.put(arr[i], temp);
		}

		return map;
	}

	public static List<Integer> findSubsequence(List<Integer> numbers, int k) {
		List<Integer> res = new ArrayList<>();
		int[] arr = new int[numbers.size()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = numbers.get(i);
		}

		Map<Integer, List<Integer>> map = getFactors(arr);

		for (List<Integer> list : map.values()) {
			if (list.size() >= k) {
				return list;
			}
		}

		return res;

	}

	/**
	 * @param args
	 * 
	 *             Sample input1 = 6,24,12,1 : k >= 4 output = 6,24,12,1
	 * 
	 *             sample input = 1,2,8,5,6 : k >= 2 output = 2,8,6
	 */
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 8, 5, 6);
		System.out.println(findSubsequence(list, 2));

		list = Arrays.asList(6, 24, 12, 1);
		System.out.println(findSubsequence(list, 2));

	}
}
