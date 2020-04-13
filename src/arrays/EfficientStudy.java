package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EfficientStudy {
	/*
	 * One can study up to certain number of pages
	 * max pages cannot exceed p
	 * Associate 2*article[i] with iv[i] - to gain value, each article has to be read twice
	 * Maximize learning as max sum of iv[i] with article pages less than p
	 *  => 
	 * */
	
	public static int maxLearning(List<Integer> iv, List<Integer> articles, int p) {
		List<Integer> maxRead = new ArrayList<>();
		for(int i : articles) {
			if(i*2 > p) {
				maxRead.add(-1);
			}
			else
				maxRead.add(i * 2);
		}
		
		return 0;
	}
			
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> articles = new ArrayList<>(Arrays.asList(2,2,3,4));
		List<Integer> iv = new ArrayList<>(Arrays.asList(2,4,4,5));
		int p = 7;
		int res = maxLearning(iv,articles,p);
		System.out.println(res);
	}

}
