/**
 * 
 */
package trees;

import java.util.*;

/**
 * @author onkesh.bansal
 *
 */
public class Traversals {

	// Depth first traversal - in order
	public static void InOrder(TreeNode root) {
		if (root != null) {
			InOrder(root.left);
			System.out.print(root.val + " ");
			InOrder(root.right);
		}
	}

	// Depth first traversal - pre order
	public static void PreOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			PreOrder(root.left);
			PreOrder(root.right);
		}
	}

	// Depth first traversal - post order
	public static void PostOrder(TreeNode root) {
		if (root != null) {
			PostOrder(root.left);
			PostOrder(root.right);
			System.out.print(root.val + " ");
		}
	}

	// Breadth first traversal - Level order traversals
	public static void BreadthFirst(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.print(temp.val + " ");

			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);

		}
	}
}
