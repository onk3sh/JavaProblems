/**
 * 
 */
package searching;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author onkesh.bansal
 *
 */
public class BFSIn2DArrayIterative {

	public void search(int[][] arr) {
		int l = arr.length;
		if (l == 0)
			return;
		int b = arr[0].length;

		boolean[][] visited = new boolean[l][b];
		Queue<String> q = new LinkedList<>();
		q.add("0,0");

		System.out.println("Starting BFS:");
		
		while (q.isEmpty() == false) {
			String[] cord = q.poll().split(",");
			int row = Integer.parseInt(cord[0]);
			int col = Integer.parseInt(cord[1]);

			if (row < 0 || col < 0 || row >= l || col >= b || visited[row][col])
				continue;

			visited[row][col] = true;
			System.out.print(arr[row][col] + ",");

			q.add((row + 1) + "," + col);
			q.add((row - 1) + "," + col);
			q.add(row + "," + (col + 1));
			q.add(row + "," + (col - 1));
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] grid = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		BFSIn2DArrayIterative obj = new BFSIn2DArrayIterative();
		obj.search(grid);
	}

}
