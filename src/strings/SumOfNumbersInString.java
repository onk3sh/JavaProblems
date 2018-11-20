package strings;

import java.util.Scanner;

public class SumOfNumbersInString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int count = 0;
		
		for(int i = 0; i<s.length();i++) {
			if(s.charAt(i) - '0' < 9) {
				count+=Character.getNumericValue(s.charAt(i));
			}
		}
		
		System.out.println(count);
		scan.close();
	}

}
