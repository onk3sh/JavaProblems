package linkedlist;

public class FindLoopInLinkedList {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList linkedList = new LinkedList();
		linkedList.insertNode(1);
		linkedList.insertNode(2);
		linkedList.insertNode(3);
		linkedList.insertNode(4);
		linkedList.insertNode(5);
		linkedList.tail.next = linkedList.head;
		linkedList.printLinkedList(linkedList.head, "=>");
		System.out.println();
		System.out.println("Does Linked List have loop? "+linkedList.hasCycle(linkedList.head));
	}

}
