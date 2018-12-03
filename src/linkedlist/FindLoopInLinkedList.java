package linkedlist;

class NodeData {
	int data;
	NodeData next;
	
	public NodeData(int input) {
		this.data = input;
		this.next = null;
	}
}

class SinglyLinkedList{
	public NodeData head;
	public NodeData tail;
	
	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public void insertNode(int input_value) {
		NodeData node = new NodeData(input_value);
		if(this.head == null) {
			this.head = node;
		}
		else {
			this.tail.next = node;
		}		
		this.tail = node;
	}
	
	public void printLinkedList(NodeData node, String sep) {
		while (node != null) {
			if(this.hasCycle(node)) {
				System.out.println("Cannot print! Linkedlist has loop!!");
				break;
			}
            System.out.print(String.valueOf(node.data));
            
            node = node.next;
            if (node != null) {
                System.out.print(sep);
            }
        }
	}
	
    boolean hasCycle(NodeData head) {
            if(head == null) return false;

            NodeData slow = head;
            NodeData fast = head.next;

            while(slow != null && fast != null && fast.next!= null){
                if(slow == fast)
                    return true;
                else{
                    slow = slow.next;
                    fast = fast.next.next;
                }
            }
        return false;
    }
}

public class FindLoopInLinkedList {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SinglyLinkedList linkedList = new SinglyLinkedList();
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
