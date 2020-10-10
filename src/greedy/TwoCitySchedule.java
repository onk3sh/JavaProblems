/**
 * 
 */
package greedy;

import java.util.Arrays;

/**
 * @author onkesh.bansal
 * 
 *         Link:
 *         https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3349/
 * 
 *         Input: [[10,20],[30,200],[400,50],[30,20]] 
 *         Output: 110 
 *         
 *         Explanation:
 *         The first person goes to city A for a cost of 10. The second person
 *         goes to city A for a cost of 30. The third person goes to city B for
 *         a cost of 50. The fourth person goes to city B for a cost of 20.
 * 
 *         The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the
 *         people interviewing in each city.
 *         
 *         Solution:
 *         
 *         Theory:
 *         Greedy questions are a double edged sword.
 *         If you can find the greediness factor and what you should be greedy on, 
 *         the problem is trivial, otherwise it will have you wondering if you actually have a CS degree or not. 
 *         In this specific problem, 
 *         the greediness factor should be How much money can we save if we fly the person to city A over city B? 
 *         We need to sort on that criteria. Once the array is sorted, we know that the first half of the array will be cheaper for those that fly to city A 
 *         and the second half will contain prices that are cheaper to fly to city B.
 *         
 *         Initially I got the greedy algorithm wrong. I tried being greedy on the Average cost flying between both cities and sorted on that criteria. 
 *         But if we think about it, we can easily prove why this won't work.
 * 
 */
public class TwoCitySchedule {

	public static int twoCitySchedCost(int[][] costs) {
		// time O(nlogn)
		int res = 0;
		int n = costs.length;
		
		Arrays.sort(costs, (a,b) -> {
			return (a[0] - a[1]) - (b[0] - b[1]);
		});
		
		for(int i = 0; i<n; i++) {
			if(i<costs.length/2)
				res+=costs[i][0];
			else
				res+=costs[i][1];
		}
		
		return res;
	}
	
	public static int twoCitySchedCostIterative(int[][] costs) {
        // time O(nlogn)
        int n = costs.length / 2;
        int minCost = 0;
        int[] refund = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            minCost += costs[i][0]; // send everyone to city A
            refund[i] = costs[i][1] - costs[i][0]; 
            // positive value means we pay extra, negative value means we get refund
        }
        Arrays.sort(refund);
        for (int i = 0; i < n; i++) {
            minCost += refund[i];
        }
        return minCost;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[][] costs = {{10,20},{30,200},{400,50},{30,20}} ;
		System.out.println(twoCitySchedCostIterative(costs));
	}

}
