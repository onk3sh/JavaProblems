package arrays;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumSwaps { 
	
	public static int minimumSwaps(int[] arr,int n,int[] sorted) {
		int count = 0;
		if(Arrays.equals(arr, sorted)) {
			return 0;
		}
		Map<Integer,Integer> locator = new HashMap<Integer,Integer>();
		for(int i = 0;i<n;i++) {
			locator.put(arr[i], i);
		}
		
		for(int i = 0; i<n;i++) {
			if(arr[i]!=sorted[i]) {
				int position = locator.get(sorted[i]);
				swap(arr,i,position);
				locator.put(arr[position], position);
				count++;
			}
		}
		
		return count;
	}
	
	public static void reverse(int[] arr) {
		int n = arr.length;
		for(int i = 0; i<n/2;i++) {
			swap(arr,i,n-i-1);
		}
	}
	
	public static void swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
        
        int res1 = minimumSwaps(Arrays.copyOf(arr, arr.length), n, sorted);
        reverse(sorted);
        int res2 = minimumSwaps(arr, n, sorted);
        
        System.out.println(Math.min(res1, res2));
        
        scanner.close();
    }

}
