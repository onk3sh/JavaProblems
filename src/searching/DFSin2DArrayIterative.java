/**
 * 
 */
package searching;

import java.util.Stack;

/**
 * @author onkesh.bansal
 *	Depth first search in 2D array - iterative approach
 *
 *	1. Initialize stack
 *	2. Initialize 2D boolean array of same size of the original array
 *	3. Push first position into the stack as (0,0)
 *	4. Now, loop until empty
 *		4.1 pop the position from the stack
 *		4.2 split the position by ',' such that row and col are found
 *		4.3 if indexes are valid and not visited in the array, perform operation such as print
 *		4.4 else continue
 *		4.5 Mark the element visited in the visited array
 *		4.6 Add elements from top, left, right and bottom to stack 
 *	
 */
public class DFSin2DArrayIterative {
	
	public void search(int[][] arr)
	{
		int l = arr.length;
		if(l == 0) return;

		int b = arr[0].length;
		boolean[][] visited = new boolean[l][b];
		Stack<String> stk = new Stack<>();
		stk.push("0,0");
		
		System.out.println("Starting DFS:");
		
		while(stk.isEmpty() == false)
		{
			String[] cord = stk.pop().split(",");
			int row = Integer.parseInt(cord[0]);
			int col = Integer.parseInt(cord[1]);
			
			if(row < 0 || col < 0 || row >=l || col >= b || visited[row][col])
				continue;
			
			visited[row][col] = true;
			
			System.out.print(arr[row][col]+",");
			
			stk.push(row+","+(col-1));
			stk.push(row+","+(col+1));
			stk.push((row-1)+","+col);
			stk.push((row+1)+","+col);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] grid = new int[][] {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}};
        DFSin2DArrayIterative obj = new DFSin2DArrayIterative();
        obj.search(grid);
	}


}
