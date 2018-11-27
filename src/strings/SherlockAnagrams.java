package strings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SherlockAnagrams {
	
	static int MAX = 256;

	public static int sherlockAndAnagrams(String s) {
		int count = 0;
		Map<Integer,List<String>> subStrings = getSubStrings(s);

		for(Map.Entry<Integer, List<String>> entry : subStrings.entrySet()) {
				count+= getNumOfAnagramPairs(entry.getValue());
		}
		
		
		return count;
    }
	
	public static int getNumOfAnagramPairs(List<String> l) {
		int count = 0;
		for(int i = 0; i<l.size();i++) {
			for(int j = i+1; j<l.size();j++) {
				if(checkForAnagram(l.get(i), l.get(j))) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static Map<Integer,List<String>> getSubStrings(String s){
		int n = s.length(),i=0,j=0;
		String temp = "";
		Map<Integer,List<String>> subStrings = new HashMap<Integer,List<String>>();
		for(i = 0; i<n;i++) {
			for(j = i+1; j<=n;j++){
				temp = s.substring(i, j);
				if(subStrings.get(j-i)==null) {
					List<String> l = new ArrayList<String>();
					l.add(temp);
					subStrings.put(j-i, l);
				}
				else
					subStrings.get(j-i).add(temp);
			}
		}
		return subStrings;
	}
	
	public static Boolean checkForAnagram(String s1, String s2) {
		if(s1.length()!=s2.length())
			return false;
		
		int[] count = new int[MAX];
		for(int i =0; i<s1.length() && i <s2.length(); i++) {
			count[s1.charAt(i)]++;
			count[s2.charAt(i)]--;
		}
		
		for(int i = 0; i<MAX; i++) {
			if(count[i]!=0)
				return false;
		}
		
		return true;
	}
	
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int[] result = new int[q];
        for (int qItr = 0; qItr < q; qItr++) {
        	String s = scanner.nextLine();
            result[qItr] = sherlockAndAnagrams(s);
        }
        for (int qItr = 0; qItr < q; qItr++) {
            System.out.println(result[qItr]);
        }
        scanner.close();
    }

}
