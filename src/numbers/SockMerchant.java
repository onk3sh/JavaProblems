package numbers;

import java.io.*;
import java.util.*;

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] arr) {
        int res = 0,i;
        Map<Integer,Integer> pairs = new HashMap<Integer,Integer>();
        
        for(i = 0;i<n;i++){
        	if(pairs.containsKey(arr[i]))
        		pairs.put(arr[i], pairs.get(arr[i]) + 1);
        	else
        		pairs.put(arr[i], 1);
        }
        
        for(int value : pairs.values()) {
        	if(value > 0 && value != 1)
        		res+= (value/2);
        }
       
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);
        System.out.println(result);

        scanner.close();
    }
}

