/**
 * 
 */
package numbers;

import java.util.HashSet;
import java.util.Set;

/**
 * @author onkesh.bansal
 * Problem : https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3284/
 * Happy Number calculation:
 * 		Input: 19
		Output: true
		Explanation: 
		1^2 + 9^2 = 82
		8^2 + 2^2 = 68
		6^2 + 8^2 = 100
		1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {
	
	static Set<Integer> cycle = new HashSet<>();
	
	static int digitSumOfSquares(int num) {
		int sum = 0;
		while(num > 0) {
			int d = num%10;
			sum+= d*d;
			num/=10;
		}
		return sum;
	}
	
	public static boolean isHappy(int n) {		
		if(cycle.isEmpty())
			cycle.add(n);
		
		int temp = digitSumOfSquares(n);
		if(temp == 1) {
			cycle.clear();
			return true;
		}
		
		if(cycle.contains(temp)) {
			cycle.clear();
			return false;
		}
		else {
			cycle.add(temp);
			return isHappy(temp);
		}
    }
	
	public static boolean isHappyFast(int n) {
		while(true) {
			n = digitSumOfSquares(n);
			if(n == 1 || n == 7)
				return true;
			if(n < 10)
				return false;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isHappy(1));
		System.out.println(isHappy(2));
		System.out.println(isHappy(7));
		System.out.println(isHappy(13));
		System.out.println(isHappy(19));
		System.out.println(isHappy(68));
		System.out.println("------------------------------------------------------");
		System.out.println(isHappyFast(1));
		System.out.println(isHappyFast(2));
		System.out.println(isHappyFast(7));
		System.out.println(isHappyFast(13));
		System.out.println(isHappyFast(19));
		System.out.println(isHappyFast(68));
	}

}
