package numbers;

public class RearrangeZeros {
	
	public static int[] rearrangeZero(int[] arr) {
		int j = 0;
		for(int i = 0; i<arr.length; i++) {
			if(arr[i]!= 0) {
				arr[j] = arr[i];
				j++;
			}
		}
		while(j<arr.length) {
			arr[j] = 0;
			j++;
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = {1,1,0,0,4,2,0,0,8,0,10};
		
		arr = rearrangeZero(arr);
		
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]+ ",");
		}
	}

}
