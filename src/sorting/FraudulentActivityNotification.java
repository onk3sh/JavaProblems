package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

public class FraudulentActivityNotification {
	
	static int getMedian(int[] arr, int start, int end){
        int res = 0;
        
    }
    // Complete the activityNotifications function below.
    static int activityNotifications(int[] arr, int d) {
        int n = arr.length;
        
        return 0;

    }

	
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    	File file = new File("C:\\Users\\onkesh.bansal\\Desktop\\hr\\mt-1.txt");
    	BufferedReader bufferedReader = new BufferedReader(new FileReader(file)); 
    	
    	String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);
        int[] expenditure = new int[n];
        int d = Integer.parseInt(nr[1]);

        expenditure = Stream.of(bufferedReader.readLine()
        		.replaceAll("\\s+$", "").split(" "))
        		.mapToInt(x -> Integer.parseInt(x))
        		.toArray();

        int result = activityNotifications(expenditure, d);
        
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
        bufferedReader.close();
        scanner.close();
    }

}
