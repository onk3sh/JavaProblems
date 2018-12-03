package stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * Function Description
 * Complete the function isBalanced in the editor below. It must return a string: YES if the sequence is balanced or NO if it is not.
 * 
 * isBalanced has the following parameter(s):
 * 
 * s: a string of brackets
 * 
 * Input Format
 * 
 * The first line contains a single integer , the number of strings. 
 * Each of the next  lines contains a single string , a sequence of brackets.
 * 
 * Constraints, 
 * 
 * where  is the length of the sequence.
 * All chracters in the sequences ∈ { {, }, (, ), [, ] }.
 * 
 * Output Format
 * For each string, return YES or NO.
*/

public class BalancedBrackets {
	
	static Boolean isBalanced(String s) {
		if(s.isEmpty()) 
			return false;

		Stack<Character> stack = new Stack<>();
		for(int i = 0; i<s.length(); i++) {
			if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
			}
			else if(s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i) == ']') {
				if(stack.isEmpty()) 
					return false;
				else {
					if(!isMatchingPair(stack.pop(), s.charAt(i)))
						return false;
				}
			}
		}
		if(!stack.isEmpty()) return false;
		return true;
    }
	
	public static String checkIsBalanced(String s) {
		Boolean res = isBalanced(s);
		if(res)
			return "YES";
		else
			return "NO";
	}
	
	static Boolean isMatchingPair(Character c1, Character c2) {
		if(c1 == '{' && c2 == '}')
			return true;
		else if(c1 == '(' && c2 == ')')
			return true;
		else if (c1 == '[' && c2 == ']')
			return true;
		
		return false;
	}

    private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] result = new String[t];
        for (int i = 0; i < t; i++) {
            result[i] = checkIsBalanced(scanner.nextLine());
        }
        
        for(String s : result) {
        	System.out.println(s);
        }
        
        scanner.close();
	}

}
