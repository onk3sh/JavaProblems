package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class October2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Integer> q = new LinkedList<>();

		int i;
		int last_added = -1;
		for (i = 1; i < 11; i++) {
			q.add(i);
			last_added = i;
		}
		System.out.println(q);

		int current_head = q.peek();

		System.out.println(current_head + "," + last_added);
	}
}
