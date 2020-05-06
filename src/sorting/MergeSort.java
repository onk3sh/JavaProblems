package sorting;

import java.util.Arrays;

/**
 * @author onkesh.bansal
 *
 */
public class MergeSort {

	static void merge(int[] arr, int start, int mid, int end) {
		
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
			}
		}
		
		while(i < n1) {
			arr[k++] = L[i++];
		}
		
		while(j < n2) {
			arr[k++] = R[j++];
		}
	}
	
	static void sort(int[] arr, int start, int end) {
		
		if(start < end) {
			int mid = (start+end)/2;
			
			sort(arr, start, mid);
			sort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}

	static void mergeSort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

//		int[] arr = { 2, 3, 1, 4, 5, 9, 8, 7, 6, 10, 0 };
//		int[] arr = { 1,1,2,2,2 };
		int[] arr = { 2,1,3,1,2 };

		mergeSort(arr);

		for (int i : arr) {
			System.out.print(i + ", ");
		}
		System.out.println();
		System.out.println(count);
		
		long endTime = System.currentTimeMillis();
		// calculate time difference
		long timeDiff = endTime - startTime;
		System.out.println("Elapsed time: " + timeDiff + " ms");
		
	}

}
