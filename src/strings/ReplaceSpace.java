package strings;

import java.io.IOException;
import java.util.Scanner;

public class ReplaceSpace {
	
	public static char[] replaceSpace(char[] arr, int length) {
		int newLength = 0;
		int spaceCount = 0;
		int i = 0;
		
		for(i = 0; i<length;i++) {
			if(arr[i] == ' ') spaceCount++;
		}
		//Remove trailing spaces
		while(arr[i-1] == ' ') {
			spaceCount--;
			i--;
		}
		
		newLength = length + 2*spaceCount + 1;
		arr[newLength - 1] = '\0';
		newLength--;
		
		for(i = length - 1; i>=0; i--) {
			if(arr[i] == ' ') {
				arr[newLength - 1] = '0';
				arr[newLength - 2] = '2';
				arr[newLength - 3] = '%';
				newLength -= 3;
			}
			else {
				arr[newLength - 1] = arr[i];
				newLength--;
			}
		}
		
		return arr;
	}

    public static void main(String[] args) throws IOException {
    	char[] arr = {'t','h','i','s',' ','i','s',' ','a',' ','t','e','s','t',' ',' ',' ',' ',' ',' ',' ',' ',' '};
		int length = 14;
		
        char[] result = replaceSpace(arr, length);
        int i = 0;
        while(result[i]!='\0') {
        	System.out.print(arr[i]);
        	i++;
        }
    }

}
