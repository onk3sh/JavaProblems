package numbers;

import java.io.*;
import java.util.*;

public class RecordBreakingScores {

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
    	int[] res = new int[2];
    	int max, min, breakMax, breakMin;
    	max = min = scores[0];
    	breakMax = breakMin = 0;
    	
    	for(int i=1; i<scores.length; i++) {
    		if(scores[i] > max) { 
    			breakMax++;
    			max = scores[i];
    		}
    		if(scores[i] < min) {
    			breakMin++;
    			min = scores[i];
    		}
    	}
    	res[0] = breakMax;
    	res[1] = breakMin;
    	return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
 //       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }
//        bufferedWriter.newLine();
//        bufferedWriter.close();

        scanner.close();
    }
}

