/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author onkesh.bansal
 *
 */
public class October1 {

	private static int absDiff(int a, int b) {
		if (a > b)
			return a - b;
		return b - a;
	}

	public static int maxDistance(List<List<Integer>> arrays) {
		int n = arrays.size();
		int res = Integer.MIN_VALUE;

		List<Integer> l1 = arrays.get(0);
		int min = l1.get(0);
		int max = l1.get(l1.size() - 1);

		for (int i = 1; i < n; i++) {
			List<Integer> l2 = arrays.get(i);

			int min2 = l2.get(0);
			int max2 = l2.get(l2.size() - 1);

			if (res < absDiff(min2, max))
				res = absDiff(min2, max);
			if (res < absDiff(max2, min))
				res = absDiff(max2, min);

			max = Math.max(max, max2);
			min = Math.min(min, min2);
		}

		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> temp1 = Arrays.asList(1, 2, 3);
		List<Integer> temp2 = Arrays.asList(4, 5);
		List<Integer> temp3 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> temp4 = Arrays.asList(1, 4);
		List<Integer> temp5 = Arrays.asList(0, 5);

		list.add(temp1);
		list.add(temp2);
		list.add(temp3);
//		list.add(temp4);list.add(temp5);

		System.out.println(October1.maxDistance(list));
	}

}
