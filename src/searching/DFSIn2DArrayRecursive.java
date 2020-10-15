/**
 * 
 */
package searching;

/**
 * @author onkesh.bansal
 *	1. Initialize the visited boolean 2D array
 *	2. Call the DFS utility function with arguments as array, starting row, starting col, visited array.
 *	3. Inside the DFS utility function:
 *		3.1 get length as arr length and breadth as arr[0].length;
 *		3.2 check that if the row/col are less than 0 or row>=length or col>=breadth or visited then return;
 *		3.3 Set the visited value for row and col as visited and print value/do operation
 *		3.4 Now do recursive calls as up, down, right left;
 */
public class DFSIn2DArrayRecursive {

	public void search(int[][] arr) {
		int l = arr.length;
		if (l == 0)
			return;

		int b = arr[0].length;
		boolean[][] visited = new boolean[l][b];

		System.out.println("Starting DFS:");

		DFSUtil(arr, 0, 0, visited);
	}

	private void DFSUtil(int[][] arr, int row, int col, boolean[][] visited) {
		int l = arr.length;
		int b = arr[0].length;

		if (row < 0 || col < 0 || row >= l || col >= b || visited[row][col])
			return;

		visited[row][col] = true;
		System.out.print(arr[row][col] + ",");

		DFSUtil(arr, row + 1, col, visited);
		DFSUtil(arr, row - 1, col, visited);
		DFSUtil(arr, row, col + 1, visited);
		DFSUtil(arr, row, col - 1, visited);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] grid = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		DFSIn2DArrayRecursive obj = new DFSIn2DArrayRecursive();
		obj.search(grid);

	}

}
