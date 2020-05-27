package hackerRankJavaTest;

import java.util.HashSet;
import java.util.Set;

public class MaxVowelSubString {

	static boolean isVowel(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
			return true;
		}
		return false;
	}

	static int getVowelCount(String str) {
		char[] arr = str.toCharArray();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (isVowel(arr[i]))
				count++;
		}
		return count;

	}

	public static String findSubstring(String s, int k) {
		// Write your code here

		String notFound = "Not found!";
		String out = null;
		Set<String> set = new HashSet<>();

		int n = s.length();

		if (k > n)
			return notFound;
		if (k == n)
			return s;

		int max = 0;

		for (int i = 0; i < s.length(); i++) {
			if (i + k > s.length()) {
				break;
			}
			String sub = s.substring(i, i + k);
			if(set.contains(sub) == false)
				set.add(sub);
		}
		
		for(String sub: set) {
			int temp = 0;
			temp = getVowelCount(sub);
			if (temp > max) {
				max = temp;
				out = sub;
			}
		}

		if (max > 0) {
			return out;
		}

		return notFound;

	}
	
	public static String findSubstringOld(String s, int k) {
		// Write your code here

		String notFound = "Not found!";
		String out = null;

		int n = s.length();

		if (k > n)
			return notFound;
		if (k == n)
			return s;

		int max = 0;

		for (int i = 0; i < s.length(); i++) {
			if (i + k > s.length()) {
				break;
			}
			String sub = s.substring(i, i + k);
			int temp = 0;
			temp = getVowelCount(sub);
			if (temp > max) {
				max = temp;
				out = sub;
			}
		}
		
		if (max > 0) {
			return out;
		}

		return notFound;

	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccccccccccccc";
		String result = MaxVowelSubString.findSubstring(s, 5);
		System.out.println(result);
		long endTime = System.nanoTime();
		long elapsed = endTime - startTime;
		System.out.println("Elapsed= "+elapsed+" nanoseconds");
	}

}
