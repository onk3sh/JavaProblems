package arrays;

import java.io.*;
import java.util.*;

public class TwoDimensionalArrayDS {

    /*
     * Complete the array2D function below.
     */
    static int array2D(int[][] arr) {
        int maxSum,top,mid,bot,sum,i,j,k;
        maxSum = top = mid = bot = sum = 0;
        int[] count = new int[100];    
        
        for(i = 0; i< 4; i++) {
        	for(j = 0; j<4; j++) {
        		top = arr[i][j]+arr[i][j+1]+arr[i][j+2];
        		mid = arr[i+1][j+1];
        		bot = arr[i+2][j]+arr[i+2][j+1] + arr[i+2][j+2];
        		
        		sum = top + mid + bot;
        		if(sum >=0) count[sum] = 1;
        		else if(sum < 0) count[sum*-1]= -1;
        	}
        }
        k = 99;
        while(k>=0) {
        	if(count[k] == 1) {
        		maxSum = k;
        		break;
        	}
        	else if(count[k] == -1) {
        		maxSum = k*-1;
        	}
        	k--;
        }
        return maxSum;
    }

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[6][6];
        Scanner scanner = new Scanner(System.in);
        for (int arrRowItr = 0; arrRowItr < 6; arrRowItr++) {
            String[] arrRowItems = scanner.nextLine().split(" ");

            for (int arrColumnItr = 0; arrColumnItr < 6; arrColumnItr++) {
                int arrItem = Integer.parseInt(arrRowItems[arrColumnItr].trim());
                arr[arrRowItr][arrColumnItr] = arrItem;
            }
        }
        scanner.close();
        
        int result = array2D(arr);

        System.out.println(String.valueOf(result));

    }
}