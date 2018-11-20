package numbers;

import java.io.*;
import java.util.*;

public class BetweenTwoSets {

    /*
     * You will be given two arrays of integers and asked to determine all integers that 
     * satisfy the following two conditions:
		1. The elements of the first array are all factors of the integer being considered
		2. The integer being considered is a factor of all elements of the second array
     * 
     * Input Format: 
     * The first line contains two space-separated integers, n and m , the number of elements in array  and the number of elements in array . 
     * The second line contains n distinct space-separated integers describing a[i] where 0<=i<n. 
     * The third line contains m distinct space-separated integers describing b[j] where 0<=j<m.
     * 
     * Output Format
     * Print the number of integers that are considered to be between a and b.
     * 
     * Sample Input
		2 3
		2 4
		16 32 96
		
		Sample Output : 3
		Explanation :
		2 and 4 divide evenly into 4, 8, 12 and 16. 
		4, 8 and 16 divide evenly into 16, 32, 96.
		4, 8 and 16 are the only three numbers for which each element of a is a factor and 
		each is a factor of all elements of b.
     */
	
    static int getTotalX(int[] a, int[] b) {
    	int res, counter;
    	long lcm_of_a, temp;
    	counter = 1;
    	res = 0; temp = 0;
    	lcm_of_a = lcmofarray(a, 0, a.length);
    	
    	// assumption = b array will be sorted in ascending 
    	while(temp <= b[0]) {
    		temp = lcm_of_a * counter;
    		if(check(b,temp)) res++;
    		counter++;
    	}
    	
    	return res;

    }
    
    static long hcf(long a, long b){
        if (a<b) return hcf(b,a);
        if (a%b==0) return b;
        else if (a%b==1) return 1;
        else return hcf(b, a%b);
    }

    /*
     * a x b = LCM X HCF
     */
    static long lcm(long a, long b){
        return ((a*b)/hcf(a,b));

    } 
    
    static Boolean check(int[] arr, long temp) {
    	
    	int counter = 0;
    	for(int i = 0; i<arr.length; i++) {
    		if(arr[i] % temp == 0)
    			counter++;
    	}
    	if(counter == arr.length)
    		return true;
    	else
    		return false;
    }
    
    public static long lcmofarray(int[] arr, int start, int end){
        if ((end-start)==1) 
        	return lcm(arr[start],arr[end-1]);
        else 
        	return lcm (arr[start], lcmofarray(arr, start+1, end));
    }
    
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());
        int m = Integer.parseInt(nm[1].trim());
        int[] a = new int[n];
        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];
        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        int total = getTotalX(a, b);
        System.out.println(total);
    }
}

