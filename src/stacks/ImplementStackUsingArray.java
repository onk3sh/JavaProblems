package stacks;

public class ImplementStackUsingArray {

	private static int MAX = 10;
	private int[] arr;
	private int currentPos;
	
	public ImplementStackUsingArray() {
		arr	= new int[MAX];
		arr[0] = -1;
		currentPos = 0;
	}
	
	public void push(int value) {
		currentPos++;
		if(currentPos > MAX) {
			System.out.println("Stack Overflow!");
			currentPos = MAX;
		}
		arr[currentPos] = value;
	}
	
	public void pop() {
		arr[currentPos] = 0;
		currentPos--;
		if(currentPos < 0 || arr[currentPos] == -1) {
			System.out.println("Stack is empty. Cannot pop further");
			currentPos = 1;
		}
	}
	
	public Boolean isEmpty() {
		if(currentPos < 0 || (currentPos == 0  && arr[currentPos] == -1) )
			return true;
		else
			return false;
	}

	
	public void peek() {
		System.out.println(arr[currentPos]);
	}
	
	public static void main(String[] args) {
		ImplementStackUsingArray s = new ImplementStackUsingArray();
		s.push(1);
		s.push(2);
//		s.push(3);
		s.pop();
		s.pop();
//		s.pop();
		s.peek();
	}
	
}

