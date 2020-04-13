package arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int n = q.length, temp = 0, count = 0;
        boolean chaotic = false;
        for(int i = 0; i<n; i++){
            temp = q[i] - i - 1;
            if(temp > 2){
            	chaotic = true;
                break;
            }
            for(int j = Math.max(0, temp); j<i; j++) {
            	if(q[j] > q[i])
            		count++;
            }
        }
        if(chaotic)
            System.out.println("Too chaotic");
        else
        	System.out.println(count);
    }

    public static void main(String[] args) {

        int[] q = {1,2,5,3,7,8,6,4};

            minimumBribes(q);
    }
}
