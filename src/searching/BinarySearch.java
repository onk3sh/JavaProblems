/**
 * 
 */
package searching;

/**
 * @author onkesh.bansal
 *	Binary search in a sorted array
 *	Worst case = O(logn)
 */
public class BinarySearch {
	
	public int binarySearch(int[] arr, int k)
	{	
		int n = arr.length - 1;
		return search(arr, 0, n, k); 
	}

	int search(int[] arr, int start, int end, int k)
	{
		int mid = (start+end)/2;
		if(arr[mid] == k) return mid;
		
		while(start < end)
		{
			
			if(k < arr[mid])
				return search(arr, start, mid - 1, k);
			
			else
				return search(arr, mid+1, end, k);		
		}
		
		return -1;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int query = 11;
		
		BinarySearch obj = new BinarySearch();
		int res = obj.binarySearch(arr, query);
		
		if (res != -1) 
			System.out.println("true," + res);
		else
			System.out.println("false");
	}

}
