package linkedlist;

import linkedlist.LinkedList.NodeData;

public class NthNodeFromEnd {
	
	public static int getNthNodeFromEnd(NodeData head, int n) {
		NodeData ptr = head;
		NodeData ptr_fast = head;
		int count = 0;
		
		while(count < n && ptr_fast.next != null) {
			ptr_fast = ptr_fast.next;
			count++;
		}
		
		while(ptr_fast.next != null) {
			ptr_fast = ptr_fast.next;
			ptr = ptr.next;
		}
		
		return ptr.data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		ll.insertNode(1);
		ll.insertNode(2);
		ll.insertNode(3);
		ll.insertNode(4);
		ll.insertNode(5);
		
		ll.printLinkedList(ll.head, "=>");
		System.out.println("\n"+getNthNodeFromEnd(ll.head,2));
	}

}
