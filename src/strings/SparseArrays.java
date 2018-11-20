package strings;

import java.io.*;
import java.util.*;

public class SparseArrays {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
    	int[] res = new int[queries.length];
    	int i;
    	Map<String, Integer> map = new HashMap<String,Integer>();
    	for(i = 0; i<strings.length; i++) {
    		if(map.containsKey(strings[i])) {
    			map.put(strings[i], map.get(strings[i]) + 1);
    		}
    		else
    			map.put(strings[i], 1);
    	}
    	
    	for(i = 0;i < queries.length; i++) {
    		res[i] = 0;
    	}
    	
    	for(i = 0; i<queries.length; i++) {
    		if(map.containsKey(queries[i])) {
    			res[i] = map.get(queries[i]);
    		}
    	}
    	return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            System.out.print(String.valueOf(res[i]));

            if (i != res.length - 1) {
                System.out.print("\n");
            }
        }

//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}