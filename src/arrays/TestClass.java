package arrays;

public class TestClass {

//	Rotate an array by K positions:
//	  input : int[] arr1={1,2,3,4,5,6,7};
//	output: arr={3,4,5,6,7,1,2};
//	
//		12345
//	 	23451
//	
	public static int[] rotateArrByOne(int[] arr) {
		int temp = arr[0], i;
		for(i = 0; i<arr.length - 1; i++) {
			arr[i] = arr[i+1];
		}
		arr[i] = temp;
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int k = 2;
		int length = arr.length;
		
		
		if(k%length != 0) {
			for(int j = 0; j<k; j++) {
				arr = rotateArrByOne(arr);
			}
		}
		else if(k%length == 0) {
			int rem = k/length;
			for(int j = 0; j<rem; j++) {
				arr = rotateArrByOne(arr);
			}
		}
		
		//result print
		for(int i = 0; i<length;i++) {
			System.out.print(arr[i]);
		}
	}

}
