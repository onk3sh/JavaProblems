package arrays; 

public class ArrayRotation {
	
	public static void rotate(int[] arr, int d, int n) {		
		if(d < 0) {
			System.out.println("Number of rotations cannot be less than 0");
		}
		
		int i,j,k,temp;
		for(i = 0; i<gcd(d,n); i++) {
			temp = arr[i];
			j = i;
			while(true) {
				k = j + d;
				while(k >= n)
					k = k - n;
				if(k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
	}
	
	public static int gcd(int i, int j) {
		if (j == 0)
			return i;
		else
			return gcd(j, i%j);
	}
	
	public static void printArray(int[] arr) {
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}			
	}
	
	public static void leftRotatebyOne(int arr[], int n)
	{
	   int temp = arr[0];
	   int i;
	   for(i = 0; i < n-1; i++)
	   arr[i] = arr[i+1];
	    
	   arr[i] = temp;
	}
	 
	/*Function to left rotate arr[] of size n by d*/
	public static void leftRotate(int arr[], int d, int n)
	{
	    for (int i = 0; i < d; i++)
	    leftRotatebyOne(arr, n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6,7,8,9};
		rotate(arr, 201, 9);
		printArray(arr);
		System.out.print("\n=================\n");
		leftRotate(arr, 2, 9);
		printArray(arr);
	}

}
