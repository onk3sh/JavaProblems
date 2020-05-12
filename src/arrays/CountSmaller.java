package arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

public class CountSmaller {
	
	public static int[] countSmallerFreq(int[] arr) {
		int n = arr.length;
		int res[] = new int[n];
		int[] count = new int[101];
		for(int i = 0; i<n; i++) {
			count[arr[i]]++;
		}
		
		return res;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		long startTime = System.currentTimeMillis();

		File file = new File("C:\\Users\\onkesh.bansal\\Desktop\\hr\\lc\\cs-1.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

		String[] s = bufferedReader.readLine().replaceAll("\\s+$", "").split(",");
		int[] arr = Stream.of(s).mapToInt(x -> Integer.parseInt(x)).toArray();
		int[] result = countSmallerFreq(arr);
        
        for(int i: result) {
        	System.out.print(i+",");
        }
        System.out.println();

		long endTime = System.currentTimeMillis();
		// calculate time difference
		long timeDiff = endTime - startTime;
		System.out.println("Elapsed time: " + timeDiff + " ms");
		bufferedReader.close();
		scanner.close();
	}

}
