package sorting;

public class QuickSelect {

	static void swap(int[] arr, int a, int b) {
		if(a != b ) {
			int temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
		}
	}

	static int partition(int[] arr, int left, int right) {
		int pivot = arr[right];
		int pivotLocation = left;

		for (int i = left; i <= right; i++) {
			if (arr[i] < pivot) {
				swap(arr, i, pivotLocation);
				pivotLocation++;
			}
		}

		swap(arr, right, pivotLocation);

		return pivotLocation;
	}

	static int performQuickSelect(int[] arr, int left, int right, int kth) {
		int partition = partition(arr, left, right);

		if (partition == kth) {
			return arr[partition];
		} else if (partition < kth) {
			return performQuickSelect(arr, partition + 1, right, kth);
		} else {
			return performQuickSelect(arr, left, partition - 1, kth);
		}
	}

	static int kthSmallest(int[] arr, int kth) {
		return performQuickSelect(arr, 0, arr.length - 1, kth);
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 7,6,5,4,3,2,1 };

		int kPosition = 3;
		int length = arr.length;

		if (kPosition > length) {
			System.out.println("Index out of bound");
		} else {
			// find kth smallest value
			System.out.println(
					"K-th smallest element in array : " 
			+ kthSmallest(arr, kPosition - 1));
		}

	}

}
