package strings;

import java.io.IOException;
import java.util.*;

public class TwoStrings {

	public static String twoStrings(String s1, String s2) {
		int count = 0;
		Map<Character,Integer> string1 = new HashMap<Character,Integer>();
		for(int i = 0; i<s1.length();i++) {
			if(string1.containsKey(s1.charAt(i))) {
				string1.put(s1.charAt(i), string1.get(s1.charAt(i)) + 1);
			}
			else
				string1.put(s1.charAt(i), 1);
		}
		
		for(int i = 0; i<s2.length(); i++) {
			if(string1.containsKey(s2.charAt(i))){
				count++;
			}
		}
		
		if(count > 0) return "YES";
		return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            System.out.println(result);
        }

        scanner.close();
    }

}
