package linkedlist;

import linkedlist.LinkedList.NodeData;

public class RemoveDuplicatesFromSortedList {
	
	public static NodeData removeDuplicatesFromSorted(NodeData head) {
		NodeData ptr = head;
		
		while(ptr.next != null) {
			if(ptr.data == ptr.next.data) {
				ptr.next = ptr.next.next;
			}
			else
			ptr = ptr.next;
		}
		
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		ll.insertNode(1);
		ll.insertNode(2);
		ll.insertNode(2);
		ll.insertNode(3);
		ll.insertNode(4);
		ll.insertNode(4);
		ll.insertNode(4);
		ll.insertNode(5);
		
		ll.printLinkedList(ll.head, "=>");
		System.out.println();
		ll.printLinkedList(removeDuplicatesFromSorted(ll.head), "=>");		
	}

}
