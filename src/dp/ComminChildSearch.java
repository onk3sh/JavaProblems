/**
 * 
 */
package dp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author onkesh.bansal ----- Longest common subsequence
 */
public class ComminChildSearch {
	// DP Solution:
	// time -> O(m*n)
	// space -> O(n)
	static int LongestCommonSubsequence(char[] X, char[] Y, int m, int n) {
		int[] memo = new int[n+1];
		
		for(int i = 1; i<=m; i++) {
			int prev = 0;
			for(int j = 1; j<=n; j++) {
				int temp = memo[j];
				if(X[i-1] == Y[j-1]) {
					memo[j] = prev+1;
				}
				else {
					memo[j] = Math.max(memo[j], memo[j-1]);
				}
				prev = temp;
			}
		}
	}
	
	static void backTrack(char[] arr, int[][] dp) {
		int m = dp.length;
		int n = m-1;
		Stack<Integer> stack = new Stack<>();
		int i = n;
		int j = n;
		int temp = dp[i][j];
		
		while(i > 1 && j > 1) {

			if(temp == dp[i-1][j]) {
				temp = dp[i-1][j];
				i--;
			}

			
			else if(temp == dp[i][j-1]) {
				temp = dp[i][j-1];
				j--;
			}
			
			else if(temp == dp[i-1][j-1] + 1) {
				stack.push(i);
				temp = dp[i-1][j-1];
			}
			
		}
		
		String res = "";
		
		while(!stack.isEmpty()) {
			int k = stack.pop();
			res+=arr[k-1];
		}
			
		
		System.out.println(res);
		
	}

	// Complete the commonChild function below.
	static int commonChild(String s1, String s2) {
		int n = s1.length();
		if (s2.length() != n)
			return 0;
		
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();

		int[][] dp = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int diag = dp[i - 1][j - 1];
				int up = dp[i - 1][j];
				int back = dp[i][j - 1];

				if (a2[j - 1] == a1[i - 1]) {
					dp[i][j]+=diag+1;
				}
				else
					dp[i][j] = Math.max(up, back);
			}
		}
		
		backTrack(a1, dp);

		return dp[n][n];

	}

	private static final Scanner scanner = new Scanner(System.in);

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\onkesh.bansal\\Desktop\\hr\\cc-1.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

		String s1 = bufferedReader.readLine();
		String s2 = bufferedReader.readLine();

		long startTime = System.currentTimeMillis();
		// --------------------------------
		int result = commonChild(s1, s2);
		System.out.println(result);
		// --------------------------------
		long endTime = System.currentTimeMillis();

		// calculate time difference
		long timeDiff = endTime - startTime;
		System.out.println("Elapsed time: " + timeDiff + " ms");
		bufferedReader.close();
		scanner.close();

	}

}
