package map;

import java.io.*;
import java.util.*;

public class FrequencyQueries {

	// Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
    	List<Integer> result = new ArrayList<>();
    	Map<Integer,Integer> numberToCount = new HashMap<>();
    	Map<Integer, Set<Integer>> countToNumbers = new HashMap<>();
    	
    	for(List<Integer> list : queries) {
    		int n1 = list.get(0);
    		int n2 = list.get(1);
    		if(n1 == 1) {
    			int previousCount = numberToCount.getOrDefault(n2, 0);
    			int currentCount = previousCount + 1;
    			
    			numberToCount.put(n2, currentCount);
    			
    			if(previousCount !=0) {
    				countToNumbers.get(previousCount).remove(n2);
    			}
    			
    			if(countToNumbers.containsKey(n2) == false) {
    				countToNumbers.put(currentCount, new HashSet<>());
    			}
    			countToNumbers.get(currentCount).add(n2);
    		}
    		else if(n1 == 2) {
    			int previousCount = numberToCount.get(n2);
    			int currentCount = previousCount - 1;
    			
    			if(currentCount == 0) {
    				numberToCount.remove(n2);
    			}
    			else {
    				numberToCount.put(n2, currentCount);
    			}
    			
    			countToNumbers.get(previousCount).remove(n2);
    			
    			if(currentCount != 0) {
    				countToNumbers.get(currentCount).add(n2);
    			}
    		}
    		else if(n1 == 3) {
    			Set<Integer> temp = countToNumbers.get(n2);
    			if(temp.isEmpty())
    				result.add(0);
    			else
    				result.add(1);
    		}
    	}
    	
    	
    	return result;
    }
    
    private static final Scanner scan = new Scanner(System.in);
	
    public static void main(String[] args) throws IOException {
        int q = Integer.parseInt(scan.nextLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = scan.nextLine().replaceAll("\\s+$", "").split(" ");
            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<Integer> ans = freqQuery(queries);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(String.valueOf(ans.get(i)));

            if (i != ans.size() - 1) {
                System.out.print("\n");
            }
        }
        
        scan.close();
    }

}
