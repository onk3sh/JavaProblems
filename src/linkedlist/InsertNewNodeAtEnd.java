package linkedlist;

import java.util.*;

public class InsertNewNodeAtEnd{
	
	private final static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		System.out.print("Enter number of nodes in Linkedlist:");
//		int n = scan.nextInt(),temp = 0;
		LinkedList ll = new LinkedList();
//		for(int i = 0; i<n;i++) {
//			temp = scan.nextInt();
//			ll.insertNode(temp);
//		}
//		ll.printLinkedList(ll.head, "=>");
		ll.insertNode(1);
		ll.insertNode(2);
		ll.insertNode(3);
//		ll.printLinkedList(ll.head, "=>");
		
		ll.printLinkedList(ll.insertNodeAtTheEnd(ll.head, 10),"=>");
	}

}
