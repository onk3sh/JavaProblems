/**
 * 
 */
package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author onkesh.bansal
 *
 */
public class SingleNumber {

	public static int singleNumber(int[] arr) {
		int n = arr.length;
		if (n % 2 == 0)
			return -1;

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if(set.contains(arr[i])) {
				set.remove(arr[i]);
			}
			else
				set.add(arr[i]);
		}
		
		Iterator<Integer> itr = set.iterator();
		
		return itr.next();
	}
	
	public static int singleNumberFast(int[] arr) {
		int xor = 0;
		for(int i:arr) {
			xor= xor ^ i;
		}
		
		return xor;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 4, 2, 1, 2, 1 };
		System.out.println(singleNumberFast(arr));
	}

}
