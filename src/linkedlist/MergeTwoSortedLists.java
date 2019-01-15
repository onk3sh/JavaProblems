package linkedlist;

import linkedlist.LinkedList.NodeData;

public class MergeTwoSortedLists {
	
	public static NodeData mergeTwoSortedLists(NodeData head1, NodeData head2) {
		NodeData ptr1 = head1;
		NodeData ptr2 = head2;
		
		if(ptr1 == null)
			return ptr2;
		if(ptr2 == null)
			return ptr1;
		
		if(ptr1.data < ptr2.data) {
			ptr1.next = mergeTwoSortedLists(ptr1.next, ptr2);
			return ptr1;
		}
		else{
			ptr2.next = mergeTwoSortedLists(ptr1, ptr2.next);
			return ptr2;
		}	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list_1 = new LinkedList();
		LinkedList list_2 = new LinkedList();
		list_1.insertNode(1);
		list_1.insertNode(2);
		list_1.insertNode(3);
		
		list_2.insertNode(3);
		list_2.insertNode(4);

		list_1.printLinkedList(list_1.head, "=>");
		System.out.println();
		list_2.printLinkedList(list_2.head, "=>");
		System.out.println();
		
		list_1.printLinkedList(mergeTwoSortedLists(list_1.head, list_2.head), "=>");
		System.out.println();
	}

}
