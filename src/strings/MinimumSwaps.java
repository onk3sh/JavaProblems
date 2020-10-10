/**
 * 
 */
package strings;

import java.util.*;

/**
 * @author onkesh.bansal
 *
 */
public class MinimumSwaps {
	
	static int countSwaps(Stack<Character> stk) {
		int count = 0;
		char r = 'R';
		char s = 'S';
		
		while(stk.isEmpty() == false) {
			char temp = stk.pop();
			if(stk.isEmpty()) break;
			
			if(temp == r && stk.peek() != s) {
				stk.pop();
				stk.push(s);
				count++;
			}
			
			if(temp == s && stk.peek() != r) {
				stk.pop();
				stk.push(r);
				count++;
			}
		}
		return count;
	}
	
	 public static int minimumSwaps(String status) {
		 int res = 0;
		 int n = status.length();
		 if(n == 1) return 0;
		 
		 Stack<Character> stk = new Stack<>();
		 Stack<Character> stkRev = new Stack<>();
		 
		 for(int i = 0; i<n; i++) {
			 stk.push(status.charAt(i));
		 }
		 
		 for(int i = n-1; i>0; i--) {
			 stkRev.push(status.charAt(i));
		 }
		
		 res = Math.min(countSwaps(stk), countSwaps(stkRev));
		 
		 return res;
	 }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int result = minimumSwaps("RSSRSSRRRSRRRSSSRRR");
		System.out.println(result);
		
	}

}
