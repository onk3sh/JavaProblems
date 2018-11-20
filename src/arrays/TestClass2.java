package arrays;

public class TestClass2 {
	
//	Sort an array based on sorting order defined by another array:
//		  input: int[] arr1={5,4,2,2,3,1};
//		  
//		         int[] referenceArray={2,4,5,3,1};
//				 
//		  output: arr[]={2,2,4,5,3,1};
//		  
//		  condition = in place***

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr1={5,4,2,3,1};
		int[] referenceArray={2,4,5,3,1};
		
		for(int i = 0; i<referenceArray.length; i++) {
			for(int j = 0; j<arr1.length; j++) {
				if(arr1[j] == referenceArray[i]) {
					swap(arr1,i,j);
				}
			}
		}
		
		for(int i = 0; i<arr1.length;i++) {
			System.out.print(arr1[i]);
		}
		
	}

}
