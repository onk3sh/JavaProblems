package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class KDiffArray {

    private int absDiff(int a, int b){
        if (b > a) return b-a;
        return a - b;
    }
    
public int findPairs(int[] nums, int k) {
		int counter = 0;
		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++)
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

		for (Entry<Integer,Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int val = entry.getValue();

			if (k > 0 && map.containsKey(key + k))
				counter++;
			else if (k == 0 && val > 1) {
				counter++;
			}
		}

		return counter;
    }

	public static void main(String[] args) {
//		int[] arr = { 1, 3, 1, 5, 4 };
//		int k = 2;

//		int[] arr = {1,1,3,5,4};
//		int k = 0;

		int[] arr = {1,2,4,4,3,3,0,9,2,3};
		int k = 3;

		KDiffArray obj = new KDiffArray();
		int result = obj.findPairs(arr, k);
		System.out.println(result);
	}

}
