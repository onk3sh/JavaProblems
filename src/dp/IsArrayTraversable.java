package dp;

public class IsArrayTraversable {
/**
 * Given an input array with either 0s or 1s and a jump factor of k,
 * WAP to check if the array is traversable i.e.  
 * 
 * Conditions:
 * 1. Array will always start from a 0
 * 2. Have to jump over 1.
 * 3. Jump either 1 or n postions forward in the array
 * 4. return true or false if array is traverable or not
 * 
 */
	
	public static Boolean isTraversable(int[] arr, int maxJump) {
		int i = 0,n=arr.length;
		Boolean res = false;
        while(i < n - maxJump - 1) //goes through all clouds up until the last jump
        {
            i += (arr[i+maxJump] == 0) ? maxJump : 1;
            res = true;                
        }
        return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {0,1,0,0,0,1,0,0,1,0,1,0};
		System.out.println(isTraversable(arr,3));

	}

}
