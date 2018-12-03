package stacks;

import java.util.EmptyStackException;

public class ImplementStackUsingLinkedList {
	
		private class StackNode{
			int data;
			StackNode next;
			
			public StackNode(int input) {
				this.data = input;
			}
		}
		
		private StackNode top;
		
		public ImplementStackUsingLinkedList() {
			top = null;
		}
		
		public int pop(){
			if (top == null) throw new EmptyStackException();
			int item = top.data;
			top = top.next;
			return item;
		}
		
		public void push(int item){
			StackNode t = new StackNode(item);
			t.next = top;
			top = t;
		}
		
		public int peek(){
			if (top == null) throw new EmptyStackException();
			return top.data;
		}
		
		public Boolean isEmpty(){
			return top == null;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ImplementStackUsingLinkedList s = new ImplementStackUsingLinkedList();
//		s.push(1);
//		s.push(2);
//		s.push(3);
//		s.push(4);
//		s.pop();
//		System.out.println(s.peek());
		System.out.println(s.isEmpty());

	}

}
