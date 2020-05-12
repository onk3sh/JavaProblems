/**
 * 
 */
package hackerearth;

/**
 * @author onkesh.bansal
 *
 */
public class CheckAnagram {
	
	static String check(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		
		int[] count = new int[100];
		
		if(n1 != n2) {
			return "No";
		}
		
		
		for(int i = 0; i<n1; i++) {
			count[arr1[i]]++;
			count[arr2[i]]--;
		}
		
		for(int i = 0; i<count.length; i++) {
			if(count[i]!=0) {
				return "No";
			}
		}
		
		
		return "Yes";
	}

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "bac";
		System.out.println(check(s1,s2));
	}

}
