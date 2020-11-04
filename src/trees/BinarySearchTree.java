/**
 * 
 */
package trees;
/**
 * @author onkesh.bansal
 *
 */

class BSTTreeNode {
	int data;
	BSTTreeNode left;
	BSTTreeNode right;
	
	BSTTreeNode(int d){
		this.data = d;
	}
	
	int getData() {
		return this.data;
	}
	
}
public class BinarySearchTree {

	public static BSTTreeNode root;
	
	BinarySearchTree(){
		root = null;
	}
	
	BinarySearchTree(int d){
		root = new BSTTreeNode(d);
	}
	
	private BSTTreeNode add(BSTTreeNode current, int d) {
		if(current == null) {
			return new BSTTreeNode(d);
		}
		
		else if(d < current.getData())
			current.left = add(current.left, d);
		else if(d > current.getData())
			current.right = add(current.right, d);
		
		return current;
	}
	
	void addValue(int d) {
		root = add(root, d);
	}
	
	void print(BSTTreeNode node) {
		//in order traversal
		if(node != null) {
			print(node.left);
			System.out.print(node.data+",");
			print(node.right);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.addValue(10);
		tree.addValue(13);
		tree.addValue(1);
		
		tree.print(root);
	}

}
