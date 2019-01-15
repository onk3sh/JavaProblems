package linkedlist;

public class InsertNewNodeAtHead {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertNode(1);
		ll.insertNode(2);
		ll.insertNode(3);
//		ll.printLinkedList(ll.head, "=>");
		
		ll.printLinkedList(ll.insertNewNodeAtHead(ll.head, 10),"=>");
	}

}
