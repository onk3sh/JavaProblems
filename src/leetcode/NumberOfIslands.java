/**
 * 
 */
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author onkesh.bansal
 * Problem: https://leetcode.com/problems/number-of-islands/
 * 
 * Solutions - BFS or DFS or Disjoint Set union

 */
public class NumberOfIslands {
	    
	    // Implementation using BFS - queue and iteration over the 2D matrix
	    public int numIslandsBFS(char[][] grid) {
	        if(grid.length == 0 || grid[0].length == 0) return 0;
	        
	        int L = grid.length;        
	        int W = grid[0].length;
	        int ans = 0;
	        boolean[][] visited = new boolean[L][W];        
	        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
	        Queue<String> q = new LinkedList<>();
	        
	        for(int row = 0; row<L; row++)
	            for(int col = 0; col<W; col++){
	                if(!visited[row][col] && grid[row][col] == '1'){
	                    ans++;
	                    q.add(row+","+col);
	                    visited[row][col] = true;
	                    
	                    while(!q.isEmpty()){
	                        String[] str = q.peek().split(",");
	                        q.remove();

	                        int r = Integer.parseInt(str[0]);
	                        int c = Integer.parseInt(str[1]);
	                        
	                        for(int[] dir : directions){
	                            r += dir[0];
	                            c += dir[1];
	                            // System.out.println(inside(r,c,L,W) + "&&" + !visited[r][c] + "&&" + (grid[r][c] == "1"));
	                            
	                            if((0<=r && r < L && 0 <= c && c < W) && !visited[r][c] && grid[r][c] == '1'){
	                                q.add(r +","+ c);
	                                visited[r][c] = true;
	                            }
	                        }
	                        
	                    }

	                }
	            }
	        return ans;
	    }

	    
	    void dfs(char[][] grid, int r, int c){
	        int nr = grid.length;
	        int nc = grid[0].length;
	        
	        if(r < 0 || c < 0 || r >=nr || c >=nc || grid[r][c] == '0')
	            return;
	        
	        grid[r][c] = '0';
	        dfs(grid, r - 1, c);
	        dfs(grid, r + 1, c);
	        dfs(grid, r, c - 1);
	        dfs(grid, r, c + 1);
	    }
	    
	    // Solutions - BFS or DFS or Disjoint Set union
	    // Implementation using DFS - recursive iteration over the 2D matrix
	    public int numIslandsDFS(char[][] grid) {
	        if(grid.length == 0 || grid[0].length == 0) return 0;
	        
	        int L = grid.length;        
	        int W = grid[0].length;
	        int ans = 0;
	        
	        for(int row = 0; row<L; row++)
	            for(int col = 0; col<W; col++){
	                if(grid[row][col] == '1'){
	                    ans++;
	                    dfs(grid, row, col);
	                }
	            }
	        return ans;
	    }
	    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] grid ={{'1','1','0','0','1'},
						{'1','1','0','0','0'},
						{'0','0','1','0','0'},
						{'1','0','0','1','1'}};
		
		NumberOfIslands obj = new NumberOfIslands();
		System.out.println(obj.numIslandsBFS(grid));
		System.out.println(obj.numIslandsDFS(grid));
	

	}

}
