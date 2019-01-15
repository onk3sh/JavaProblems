package linkedlist;

class LinkedList{
	class NodeData {
		int data;
		NodeData next;
		
		public NodeData(int input) {
			this.data = input;
			this.next = null;
		}
	}
	
	public NodeData head;
	public NodeData tail;
	
	public LinkedList() {
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
    
    NodeData insertNodeAtTheEnd(NodeData head, int data) {
    	NodeData node = new NodeData(data);
    	NodeData ptr = head;
    	
    	if(ptr == null) {
    		ptr = head;
    	}
    	else {
    		while(ptr.next != null) {
    			ptr = ptr.next;
    		}
    		ptr.next = node;
    	}
    	
    	return head;
    }

	public NodeData insertNewNodeAtHead(NodeData head2, int i) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
