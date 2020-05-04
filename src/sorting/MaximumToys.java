package sorting;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class MaximumToys {
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static int partition(int[]arr, int low, int high) {
		int pivot = arr[high];
		int i = low-1;
		
		for(int j = low; j<high; j++) {
			if(arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		
		swap(arr, i+1, high);
		return i+1;
	}
	
	static void quicksort(int[] arr, int low, int high) {
		if(low < high) {
			int pi = partition(arr, low, high);
			
			quicksort(arr, low, pi-1);
			quicksort(arr, pi+1, high);
		}
	}
	
	static void sort(int[] arr) {
		quicksort(arr, 0, arr.length - 1);
	}

	 // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        int count = 0;
        sort(prices);
        for(int p : prices) {
            if(p < k) {
            	count++;
            	k-=p;
            }
        }
        return count;
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    	File file = new File("C:\\Users\\onkesh.bansal\\Desktop\\hr\\mt-1.txt");
    	BufferedReader bufferedReader = new BufferedReader(new FileReader(file)); 
    	
    	String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);
        int[] prices = new int[n];
        int k = Integer.parseInt(nr[1]);

        prices = Stream.of(bufferedReader.readLine()
        		.replaceAll("\\s+$", "").split(" "))
        		.mapToInt(x -> Integer.parseInt(x))
        		.toArray();

        int result = maximumToys(prices, k);
        
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
        bufferedReader.close();
        scanner.close();
    }
}
