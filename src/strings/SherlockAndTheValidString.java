package strings;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndTheValidString {

	// Sherlock And The Valid String - HackerRank
	//https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
    static String isValid(String s) {
    	Map<Character,Integer> map = new HashMap<>();
    	Map<Integer,Integer> map2 = new HashMap<>();
    	char[] arr = s.toCharArray();
    	
    	for(int i  = 0; i<s.length(); i++) {
    		if(map.containsKey(arr[i])) {
    			map.put(arr[i], map.get(arr[i]) + 1);
    		}
    		else
    			map.put(arr[i], 1);
    	}
    	
    	for(Integer v : map.values()) {
    		if(map2.containsKey(v)) {
    			map2.put(v, map2.get(v) + 1);
    		}
    		else
    			map2.put(v, 1);
    	}
    	
    	if(map2.size() > 2) return "NO";
    	else if (map2.size() == 1) return "YES";
    	else
    	{
    		int f1 = 0;
            int f2 = 0;
            int f1Count = 0;
            int f2Count = 0;
            int i = 0;
            
            for(Map.Entry<Integer, Integer> entry : map2.entrySet())
            {
                if(i == 0) {
                	f1 = entry.getKey();
                	f1Count = entry.getValue();
                	i++;
                }
                else {
                	f2 = entry.getKey();
                	f2Count = entry.getValue();
                }
            }
            
            if((f1 == 1 && f1Count == 1 ) || (f2 == 1 && f2Count == 1 ))
            	return "YES";
            else if ((Math.abs(f1 - f2)  == 1) && (f1Count == 1 || f2Count == 1))
            	return "YES";
            else
            	return "NO";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();
        String result = isValid(s);
        System.out.println(result);
        scanner.close();
    }

}
