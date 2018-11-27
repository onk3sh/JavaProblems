package arrays;

import java.util.*;
import java.util.Map.Entry;

public class TestClass2 {
	
//	Sort an array based on sorting order defined by another array:
//		  input: int[] arr1={5,4,2,2,3,1};
//		  
//		         int[] referenceArray={2,4,5,3,1};
//				 
//		  output: arr[]={2,2,4,5,3,1};
//		  
//		  condition = in place***

	public static int getFirstPositionInArray(int[] arr, int start, int input) {
		int pos = -1;
		for(int i = start; i<arr.length;i++) {
			if(arr[i] == input) {
				pos = i;
				break;
			}
		}
		return pos;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr={5,4,2,4,2,3,2,3,5,1,2,3,4,5};
		int[] refArr={2,4,5,3,1};
		int i = 0, temp = 0, j = 0;
		
		while(i<arr.length) {
			while(temp != -1) {
				temp = getFirstPositionInArray(arr, i, refArr[j]);
				if(temp == -1) break;
				swap(arr,i,temp);
				i++;
			}
			j++;
			temp = 0;
		}
		
		for(i = 0; i<arr.length;i++) {
			System.out.print(arr[i]);
		}
		
	}

}
