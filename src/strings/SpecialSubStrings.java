/**
 * 
 */
package strings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

/**
 * @author onkesh.bansal
 * 
 *         https://www.hackerrank.com/challenges/special-palindrome-again/problem
 */
public class SpecialSubStrings {

	static class Pair {
		char key;
		long count;

		public Pair(char c, long n) {
			this.key = c;
			this.count = n;
		}
	}

	// Complete the substrCount function below.
	static long substrCount(int n, String s) {
		ArrayList<Pair> list = new ArrayList<>();
		long count = 0;

		for (int i = 0; i < n; i++) {
			int j = i + 1;

			while(j < n && s.charAt(j) == s.charAt(i))
				j++;

			list.add(new Pair(s.charAt(i), j - i));
			i = j - 1;
		}

		for (int i = 0; i < list.size(); i++) {
			Pair p = list.get(i);
			long count_ch = p.count;

			count += (count_ch + 1) * count_ch / 2;

			if (count_ch == 1 && i > 0 && i < list.size() - 1) {
				Pair prev = list.get(i - 1);
				Pair next = list.get(i + 1);
				if (prev.key == next.key)
					count += Math.min(prev.count, next.count);
			}

		}
        
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\onkesh.bansal\\Desktop\\hr\\splstr-3.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

		String tests = bufferedReader.readLine().replaceAll("\\s+$", "");
		int n = Integer.parseInt(tests);
		String s = bufferedReader.readLine().replaceAll("\\s+$", "");

		long startTime = System.currentTimeMillis();
		// --------------------------------
		long result = substrCount(n, s);
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
