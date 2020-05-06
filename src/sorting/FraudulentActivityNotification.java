package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

public class FraudulentActivityNotification {

	static int getMedian(int[] count, int d) {
		int sum = 0;
		for (int i = 0; i < count.length; i++) {
			sum += count[i];
			if ((2 * sum) == d) {
				return 2 * i + 1;
			} else if (2 * sum > d) {
				return 2 * i;
			}
		}
		return 1;
	}

	// Complete the activityNotifications function below.
	static int activityNotifications(int[] arr, int d) {
		int[] count = new int[201];
		int result = 0;
		for (int i = 0; i < d; i++) {
			count[arr[i]]++;
		}

		for (int i = d; i < arr.length; i++) {
			int median = getMedian(count, d);
			if (median <= arr[i]) {
				result++;
			}
			count[arr[i - d]]--;
			count[arr[i]]++;
		}

		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();

		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		File file = new File("C:\\Users\\onkesh.bansal\\Desktop\\hr\\fan-1.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

		String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(nr[0]);
		int[] expenditure = new int[n];
		int d = Integer.parseInt(nr[1]);

		expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.mapToInt(x -> Integer.parseInt(x)).toArray();

		int result = activityNotifications(expenditure, d);

		System.out.println(result);

		long endTime = System.currentTimeMillis();
		// calculate time difference
		long timeDiff = endTime - startTime;
		System.out.println("Elapsed time: " + timeDiff + " ms");

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
		bufferedReader.close();
		scanner.close();
	}

}
