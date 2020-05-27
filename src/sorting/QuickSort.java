/**
 * 
 */
package sorting;

/**
 * @author onkesh.bansal
 *
 */
public class QuickSort {

	private static void swap(int[] arr, int a, int b) {
		if (a != b) {
			int temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int i = start;
		int j = end + 1;

		while (true) {
			while (arr[++i] < arr[start]) {
				if (i == end)
					break;
			}

			while (arr[start] < arr[--j]) {
				if (j == start)
					break;
			}

			if (i >= j)
				break;

			swap(arr, i, j);
		}
		swap(arr, start, j);
		return j;
	}

	private static void sort(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = partition(arr, start, end);

			sort(arr, start, pivot - 1);
			sort(arr, pivot + 1, end);
		}
	}

	static void quickSort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	public static void print(int[] arr) {
		int i;
		for (i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.print(arr[i] + "\n");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		int[] arr = { 2, 3, 1, 4, 5, 9, 8, 7, 6, 10, 0 };
//		int[] arr = { 1,1,2,2,2 };
//		int[] arr = { 2,1,3,1,2 };

		quickSort(arr);
		print(arr);

		long endTime = System.currentTimeMillis();
		// calculate time difference
		long timeDiff = endTime - startTime;
		System.out.println("Elapsed time: " + timeDiff + " ms");

	}

}
