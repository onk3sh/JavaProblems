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

public class FindGeometricProgression {
	
	static long findTripletCount(Map<Long,Long> right_map, Map<Long,Long> left_map, long key, long r) {
		long res = 0, a_by_r = 0;
		
		if(right_map.containsKey(key) && right_map.get(key) > 0) {
			right_map.replace(key, right_map.get(key) - 1);
		}
		 
		a_by_r = (key%r == 0) ? key/r : -1;
		
		long left = left_map.getOrDefault(a_by_r, (long)0);
		long right = right_map.getOrDefault(key*r, (long)0);
		
		res = left*right;
		
		if(left_map.containsKey(key)){
			left_map.put(key, left_map.get(key) + 1);
        }
        else{
        	left_map.put(key, Long.valueOf(1));

        }
		
		return res;
		
	}

	 static long countTriplets(List<Long> arr, long r) {

	        Map<Long,Long> map = new HashMap<>();
	        Map<Long,Long> left_map = new HashMap<>();
	        long count = (long) 0;
	        
	        for(long i : arr){
	            if(map.containsKey(i)){
	                map.put(i, map.get(i) + 1);
	            }
	            else{
	                map.put(i, Long.valueOf(1));

	            }
	        }
	        
	        for(long key: arr) {
	        	count+= findTripletCount(map, left_map, key, r);
	        }

	        return count;
	    }

	    public static void main(String[] args) throws IOException {
	    	File file = new File("C:\\Users\\onkesh.bansal\\Desktop\\hr\\ct-f2.txt");
	    	BufferedReader bufferedReader = new BufferedReader(new FileReader(file)); 

	    	
//	    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

	        int n = Integer.parseInt(nr[0]);

	        long r = Long.parseLong(nr[1]);

	        List<Long> arr = Stream.of(bufferedReader.readLine()
	        		.replaceAll("\\s+$", "").split(" "))
	        		.map(Long::parseLong)
	        		.collect(toList());

	        long ans = countTriplets(arr, r);

	        System.out.println(ans);
	        
//	        bufferedWriter.write(String.valueOf(ans));
//	        bufferedWriter.newLine();

	        bufferedReader.close();
//	        bufferedWriter.close();
	    }

}
