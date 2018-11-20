package numbers;

public class WaterAreaInHistogram {
	
	public static int calculate(int[] arr) {
		int vol = 0;
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		int n = arr.length;
		int i = 0;
		
		left[0] = arr[0];
		for(i = 1; i<n; i++) {
			left[i] = Math.max(left[i-1], arr[i]);
		}
		
		right[n-1] = arr[n-1];
		for(i = n - 2; i >= 0; i--) {
			right[i] = Math.max(right[i+1], arr[i]);
		}
		
		for(i=0;i<n;i++) {
			vol += Math.min(left[i],right[i]) - arr[i];
		}
		
		return vol;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,0,1,3,4,3,1,3};
		int[] input2 = {1,0,1};
		int[] input3 = {3,0,0,2,0,4};

		System.out.println(calculate(input));
		System.out.println(calculate(input2));
		System.out.println(calculate(input3));

	}

}
