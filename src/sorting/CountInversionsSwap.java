package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author onkesh.bansal
 *
 */
public class CountInversionsSwap {
	
	static long mergeAndCount(int[] arr, int start, int mid, int end) {
		
		long count = 0;
		
		int n1 = mid - (start - 1);
		int n2 = end - mid;
		
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for(int i = 0; i<n1; i++) {
			L[i] = arr[start + i];
		}
		
		for(int j = 0; j<n2; j++) {
			R[j] = arr[mid + 1 + j];
		}
		
		int i = 0;
		int j = 0;
		int k = start;
		
		while(i < n1 && j < n2) {
			if(L[i] <= R[j]) {
				arr[k++] = L[i++];
			}
			else {
				arr[k++] = R[j++];	
				count+= (mid + 1) - (start + i);
			}
		}
		
		while(i < n1) {
			arr[k++] = L[i++];
		}
		
		while(j < n2) {
			arr[k++] = R[j++];
		}
		
		return count;
	}
	
	static long sortAndCount(int[] arr, int start, int end) {
		
		long count = 0;
		
		if(start < end) {
			int mid = (start+end)/2;
			
			count+= sortAndCount(arr, start, mid);
			count+= sortAndCount(arr, mid+1, end);
			count+= mergeAndCount(arr, start, mid, end);
		}
		
		return count;
	}

	static long mergeSortAndCount(int[] arr) {
		return sortAndCount(arr, 0, arr.length - 1);
	}
	
	static long countInversions(int[] arr) {
		return mergeSortAndCount(arr);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		long startTime = System.currentTimeMillis();

		File file = new File("C:\\Users\\onkesh.bansal\\Desktop\\hr\\cis-3.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

		String s = bufferedReader.readLine().replaceAll("\\s+$", "");
		int t = Integer.parseInt(s);
		
        for (int tItr = 0; tItr < t; tItr++) {
        	s = bufferedReader.readLine().replaceAll("\\s+$", "");
            int n = Integer.parseInt(s);

            int[] arr = new int[n];

            arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
    				.mapToInt(x -> Integer.parseInt(x)).toArray();

            long result = countInversions(arr);

            System.out.println(String.valueOf(result));
        }

		long endTime = System.currentTimeMillis();
		// calculate time difference
		long timeDiff = endTime - startTime;
		System.out.println("Elapsed time: " + timeDiff + " ms");
		bufferedReader.close();
		scanner.close();
	}

}
