package hackerRankJavaTest;

import java.util.*;

public class ActiveTraders {
	
	public static List<String> mostActive(List<String> customers) {
    	// Write your code here
        
		int n = customers.size();
        List<String> res = new ArrayList<>();
        
		Map<String, Integer> map = new TreeMap<>();
        for(String s : customers){
            if(map.containsKey(s)){
                map.put(s, map.get(s) + 1);
            }
            else
                map.put(s, 1);
        }
        
        for(String key: map.keySet()) {
        	int temp = map.get(key);
        	float tempPerCent = (100*temp/n);
        	if(tempPerCent > 5.0) {
        		res.add(key);
        	}
        }
        return res;
    }

	public static void main(String[] args) {
		String[] arr = {"D", "D", "A", "B", "B", "C", "B", "B", "A", "C","A", "B", "B", "C", "B", "B", "A", "C","A", "B", "B", "C", "B", "B", "A", "C","A", "B", "B", "C", "B", "B", "A", "C","A", "B", "B", "C", "B", "B", "A", "C","A", "B", "B", "C", "B", "B", "A", "C"};
		List<String> customers = Arrays.asList(arr);
		List<String> res = mostActive(customers);
		
		for(String str: res) {
			System.out.println(str);
		}
	}

}
