/**
 * 
 */
package arrays;

/**
 * @author onkesh.bansal
 *
 */
public class ArrayRotationTimes {

	private void rotateArrayAntiClockwise(int[] arr){
		int n = arr.length;	
		int temp = arr[n-1];
		
		for(int i = n - 1; i>0; i--){
			arr[i] = arr[i - 1];
		}
		
		arr[0] = temp;
	}
	
	private void rotateArrayClockwise(int[] arr){
		int n = arr.length;	
		int temp = arr[0];
		
		for(int i = 0; i<n - 1; i++){
			arr[i] = arr[i + 1];
		}
		
		arr[n - 1] = temp;
	}

	public void rotateArrayDirectionTimes(int[] arr, int k, boolean clockwise){
		int n = arr.length;
		if(n == 0 || k == 0) return;
		
		int temp = k%n;
		if(k != 0) {
			for(int i = 0; i<temp; i++)
				if(clockwise)
					rotateArrayClockwise(arr);
				else
					rotateArrayAntiClockwise(arr);
		}
	}

	public void printArray(int[] arr){
		System.out.print("[");
		for(int i : arr)
			System.out.print(i + ",");
		
		System.out.println("]");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayRotationTimes obj = new ArrayRotationTimes();
		
		System.out.println("Clockwise rotation:");
		for(int i = 0; i<=5; i++) {
			int[] arr = {1,2,3,4,5};
			obj.rotateArrayDirectionTimes(arr, i, true);
			obj.printArray(arr);
		}
		System.out.println();
		System.out.println("AntiClockwise rotation:");
		for(int i = 0; i<=5; i++) {
			int[] arr = {1,2,3,4,5};
			obj.rotateArrayDirectionTimes(arr, i, false);
			obj.printArray(arr);
		}
		
	}

}
