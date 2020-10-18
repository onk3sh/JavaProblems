/**
 * 
 */
package leetcode;

import java.util.TreeMap;

/**
 * @author onkesh.bansal
 *
 */
public class CountOddEvenJumps {

	public int oddEvenJumps(int[] A) {
        int N = A.length;
        if(N <=1) return N;
        
        boolean[] odd = new boolean[N];
        boolean[] even = new boolean[N];
        odd[N - 1] = even[N - 1] = true;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[N - 1], N - 1);
        
        for(int i = N - 2; i > 0; i--){
            int current = A[i];
            if(map.containsKey(current)){
                odd[i] = even[map.get(current)];
                even[i] = odd[map.get(current)];
            }
            else {
                Integer lower = map.lowerKey(current);
                Integer higher = map.higherKey(current);
                
                if(lower != null) even[i] = odd[map.get(lower)];
                if(higher != null) odd[i] = even[map.get(higher)];
            }
            map.put(current, i);
        }
        
        int ans = 0;
        for(boolean b : odd)
            if(b) ans++;
        return ans;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountOddEvenJumps obj = new CountOddEvenJumps();
		int[] arr = {2,3,1,1,4};
		System.out.println(obj.oddEvenJumps(arr));
		

	}

}
