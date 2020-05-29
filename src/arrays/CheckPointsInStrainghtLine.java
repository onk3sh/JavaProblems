/**
 * 
 */
package arrays;

import java.util.*;

/**
 * @author onkesh.bansal
 *         https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/
 */
public class CheckPointsInStrainghtLine {

	/*
	 * formula for slope => m = (y2-y1/x2-x1)
	 */
	private static double calculateSlope(int[] p1, int[] p2) {
		double xComp = (p2[0] - p1[0]);
		double yComp = (p2[1] - p1[1]);
		
		if(xComp == 0)
			return Double.POSITIVE_INFINITY;
		
		return yComp/xComp;
	}
	
	public static boolean checkStraightLine(int[][] coordinates) {
		double slope = calculateSlope(coordinates[0], coordinates[1]);
		
		int n = coordinates.length;
		for(int i = 2; i<n; i++) {
			double temp = calculateSlope(coordinates[i-1], coordinates[i]);
			if(temp != slope)
				return false;
		}
		
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] points = {{1,1},{2,2},{3,3},{4,4},{5,5}};
//		int[][] points = {{1,1},{2,2},{3,4},{4,5},{5,6}, {7,7}};
//		int[][] points = {{0,0},{0,1},{0,-1}};
		int[][] points = {{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}};
		System.out.println(checkStraightLine(points));
	}

}
