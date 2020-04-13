package map;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class FrequencyQueries {
	
	static void updateCountMap(int key, Map<Integer, Integer> map, Map<Integer, Integer> count_map, String op) {
		if(op.toLowerCase() == "sub") {
			if (count_map.containsKey(map.get(key))){
				count_map.put(map.get(key), count_map.get(map.get(key)) - 1);
			}
			else
			{
				count_map.put(map.get(key), 0);
			}
		}
		else {
			if (count_map.containsKey(map.get(key))){
				count_map.put(map.get(key), count_map.get(map.get(key)) + 1);
			}
			else
			{
				count_map.put(map.get(key), 1);
			}
		}
	}

	// Complete the freqQuery function below.
    static List<Integer> freqQuery(List<int[]> queries) {
    	List<Integer> result = new ArrayList<>();
    	Map<Integer,Integer> map = new HashMap<>();
    	Map<Integer,Integer> count_map = new HashMap<>();
    	    	    	
    	count_map.put(0, 0);
    	
    	int op = 0, key = 0;
    	for(int[] query: queries) {
    		op = query[0];
    		key = query[1];
    		
    		if(op == 1){
				updateCountMap(key,map,count_map, "sub");
    			if(map.containsKey(key)) {
    				map.put(key, map.get(key) + 1);
    			}
    			else {
    				map.put(key, 1);
    			}
				updateCountMap(key,map,count_map, "add");
    		}
    		else if(op == 2) {
				updateCountMap(key,map,count_map, "sub");
    			if(map.containsKey(key) && map.get(key) > 0) {
    				map.replace(key, map.get(key) - 1);

    			}
				updateCountMap(key,map,count_map, "add");
    		}
    		else if(op == 3) {
    			if(count_map.containsKey(key) && count_map.get(key) > 0) {
    				result.add(1);
    			}
    			else {
    				result.add(0);
    			}
    		}
    	}
    	return result;
    }
    
	
    public static void main(String[] args) throws IOException {
    	File file = new File("C:\\Users\\onkesh.bansal\\Desktop\\hr\\fq-3.txt");
    	BufferedReader bufferedReader = new BufferedReader(new FileReader(file)); 
    	
//    	 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());
        List<int[]> queries = new ArrayList<>(q);
        Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
        for (int i = 0; i < q; i++) {
          int[] query = new int[2];
          Matcher m = p.matcher(bufferedReader.readLine());
          if (m.matches()) {
            query[0] = Integer.parseInt(m.group(1));
            query[1] = Integer.parseInt(m.group(2));
            queries.add(query);
          }
        }
        List<Integer> ans = freqQuery(queries);

         for(int i : ans) {
        	 System.out.println(i);
         }
         
//         bufferedWriter.write(
//             ans.stream()
//                 .map(Object::toString)
//                 .collect(joining("\n"))
//             + "\n"
//         );

         bufferedReader.close();
//         bufferedWriter.close();
    }

}
