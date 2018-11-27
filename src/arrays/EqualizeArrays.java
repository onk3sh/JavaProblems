package arrays;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EqualizeArrays {

    static int equalizeArray(int[] arr) {
        int i = 0, n = arr.length, max = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(i = 0; i<n; i++){
            if(map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i])+ 1);
            else
                map.put(arr[i], 1);
        }
        for(int j : map.values()){
            if(j > 1 && j > max)
                max = j;
        }
        if(max == 0) return n - 1;
        return n - max;
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

        int result = equalizeArray(arr);
        System.out.println(result);
        scanner.close();
    }

}
