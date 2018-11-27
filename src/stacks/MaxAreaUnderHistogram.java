package stacks;

import java.util.Stack;

public class MaxAreaUnderHistogram {
	
	public static int calculateMaxArea(int[] input) {
		Stack<Integer> s = new Stack<Integer>();
		int top; // to store top of stack
		int maxArea = 0;
		int areaWithTop; //to store area with top bar as the smallest bar
		int n = input.length;
		int i = 0;
		
		while (i < n) {
			//if the current bar is higher than the bar on top of the stack, push it to stack
			if(s.empty() || input[s.peek()] <= input[i]) {
				s.push(i++);
			}
			// If this bar is lower than the top of the stack, then calculate area of rectangle
			// with stack top as the smallest/minimum height bar
			// 'i' is the 'right index' for the top and element before top in stack is 'left index'
			else
			{
				top = s.peek();
				s.pop();
				
				// Calculate the area, with input[top] stack as smallest bar
				areaWithTop = input[top] * (s.empty() ? i : i - s.peek() - 1);
				
				if (maxArea < areaWithTop)
					maxArea = areaWithTop;
			}
		}
		
		// now pop the remaining bars from the stack and calculate area with every popped bar
		// as the smallest bar
		while (s.empty() == false) {
			top = s.peek();
			s.pop();
			
			areaWithTop = input[top] * (s.empty() ? i : i - s.peek() - 1);
			
			if (maxArea < areaWithTop)
				maxArea = areaWithTop;
		}
		
		
		return maxArea;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {0,1,2};
		int[] input2 = {6,2,5,4,5,1,13};
		int[] input3 = {1,2,3,4,5,3,3,2};

		System.out.println(calculateMaxArea(input));
		System.out.println(calculateMaxArea(input2));
		System.out.println(calculateMaxArea(input3));

	}

}
