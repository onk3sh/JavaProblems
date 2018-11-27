package arrays;

import java.util.*;
import java.util.Map.Entry;

public class TestClass3 {
//	int[] arr={2,4,5,6,7,8,9,9,2,1,2,5,7,6}
//	  Find the duplicate elements and number of times they appear
//	 
//	output -> {duplicate_element, count}

	public static void main(String[] args) {
		int[] arr={2,4,5,6,7,8,9,9,2,1,2,5,7,6};
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i = 0; i<arr.length;i++) {
			if(map.containsKey(arr[i]) == false) {
				map.put(arr[i], 1);
			}
			else
				map.put(arr[i], map.get(arr[i]) + 1);
		}
		
		for(Entry<Integer,Integer> entry : map.entrySet()) {
			if(entry.getValue() > 1) {
				System.out.println(entry.getKey() + "," + entry.getValue());
			}
		}
		
	}

}
