/**
 * 
 */
package dp;

/**
 * @author onkesh.bansal
 *
 */
public class LongestCommonSubstring {
	
	// program to calculate the length of the longest common substring.
	// Outputs the max length of the longest common substring between 2 strings
	static int find(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		int n = Math.max(n1, n2);
		
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		
		int[][] dp = new int[n+1][n+1];
		
		for(int i = 1; i<=n1; i++) {
			for(int j = 1; j<=n2; j++) {
				int diag = dp[i-1][j-1];
				int up = dp[i-1][j];
				int back = dp[i][j-1];
				
				if(arr1[i] == arr2[j]) {
					dp[i][j] = diag + 1;
				}
			}
		}
		
		int temp = dp[1][1];
		int count = 0;
		for(int i = n1; i>0; i++) {
			for(int j = n2; j>0; j++) {
				int diag = dp[i][j];
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
