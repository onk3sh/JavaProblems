/**
 * 
 */
package leetcode;

import java.util.Stack;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * @author onkesh.bansal
 *
 */
public class CountIntervals {

	public int removeCoveredIntervals(int[][] intervals) {
		int n = intervals.length;
		Stack<Integer> start = new Stack<>();
		Stack<Integer> end = new Stack<>();

		for (int i = 0; i < n; i++) {
			int[] temp = intervals[i];
			int s = temp[0];
			int e = temp[1];

			if (start.isEmpty() && end.isEmpty()) {
				start.push(s);
				end.push(e);
			} else {
				if (start.peek() < s)
					start.push(s);

				if (end.peek() > e)
					end.push(e);

				if (start.peek() > s) {
					while (!start.isEmpty() && start.peek() > s) {
						start.pop();
					}
					start.push(s);
				} else if (end.peek() < e) {
					while (!end.isEmpty() && end.peek() < e) {
						end.pop();
					}
					end.push(e);
				}
			}
		}

		return Math.max(start.size(), end.size());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[][] arr = { { 1, 4 }, { 3, 6 }, { 2, 8 } };
		int[][] arr = { { 1, 2 }, { 1, 4 }, { 3, 4 } };

		CountIntervals obj = new CountIntervals();
		System.out.println(obj.removeCoveredIntervals(arr));

	}

}
