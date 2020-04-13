package arrays;

public class StaircaseProblem {
	/*
	 * There is a staircase. A man can climb X number of steps in the day
	 * But will have to come down Y steps in the night as the stairs are slippery.
	 * Calculate how many number of days it will take to climb a staircase of N steps.
	 */

	public static int solveStaricaseProblem(int n, int x, int y) {
		int res = 0;
		while(n>=0) {
			if(n-x == 0) {
				res++;
				return res;
			}
			else
			{
				n -= x-y;
				res++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp = solveStaricaseProblem(15, 3, 1);
		System.out.println("The answer is: "+ temp+" days");
	}

}
