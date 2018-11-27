package numbers;

import java.io.*;
import java.util.*;

public class CountTriplets {
	
	private static long countTriplets(List<Long> input, long r) {
		long count = 0;
		if(input.size() < 3) {
			return -1;
		}
		if(r == 1) {
			long n = (long)input.size();
			return n * (n - 1) * (n - 2) * 3;
		}
		
		Map<Long,List<Integer>> map = new HashMap<Long,List<Integer>>();
		for(int i = 0; i<input.size();i++) {
			if(map.containsKey(input.get(i))) {
				map.get(input.get(i)).add(i);
			}
			else
			{
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(input.get(i), list);
			}
		}
		for(Long a : map.keySet()) {
			Long ar=(long) 0, ar2=(long) 0;
			int size_a = map.get(a).size(),size_ar=0;
			ar = a*r;
			ar2 = ar*r;
			if(map.containsKey(ar) && map.containsKey(ar2)) {
				size_ar = Math.max(map.get(ar).size(),map.get(ar2).size());
				count+= Math.max(size_a, size_ar);
			}
		}
		return count;
	}
    private static final Scanner scan = new Scanner(System.in);

	 public static void main(String[] args) throws IOException {
	        String[] nm = scan.nextLine().split(" ");

	        int n = Integer.parseInt(nm[0].trim());
	        Long r = Long.parseLong(nm[1].trim());
	        List<Long> l = new ArrayList<Long>();
	        String[] aItems = scan.nextLine().split(" ");

	        for (int aItr = 0; aItr < n; aItr++) {
	            Long aItem = Long.parseLong(aItems[aItr].trim());
	            l.add(aItem);
	        }

	        Long total = countTriplets(l, r);
	        System.out.println(total);
	    }
}
