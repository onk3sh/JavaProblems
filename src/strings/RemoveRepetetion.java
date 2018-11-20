package strings;

import java.io.IOException;
import java.util.Scanner;

public class RemoveRepetetion {
	
	public static String removeRepeatedChars(String s) {
		String res = new String();
		int n = s.length(),i;
		i=0;
		while(i<n) {
			while(i!= n-1 && s.charAt(i) == s.charAt(i+1)) i++;
			res+= s.charAt(i);
			i++;
		}
		return res;
	}
	
	public static char[] removeRepeatedCharsInplace(char[] arr) {
		int n = arr.length,i,j=0;
		for(i=1; i<n;i++) {
			if(arr[j]!=arr[i]) {
				j++;
				arr[j] = arr[i];
			}
		}
		j++;
		arr[j] = '\0';
		return arr;
	}

	
    private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
    	String s = scanner.nextLine();
		char[] arr = s.toCharArray();
    	char[] result = removeRepeatedCharsInplace(arr);
    	int i = 0;
    	while(result[i]!='\0') {
    		System.out.print(result[i]);
    		i++;
    	}
    	scanner.close();
    }

}
