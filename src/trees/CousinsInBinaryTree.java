/**
 * 
 */
package trees;

import java.util.*;

/**
 * @author onkesh.bansal
 *         https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3322/
 */
public class CousinsInBinaryTree {

	public int[] convertTreetoArr(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			list.add(temp.val);

			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}

		int[] arr = new int[list.size()];
		int idx = 0;
		for (int ele : list) {
			arr[idx++] = ele;
		}

		return arr;

	}

	private int getIndexOfInteger(int[] arr, int x) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != x)
				count++;
			else
				break;
		}

		return count;
	}

	public int getLevelByNum(int[] arr, int x) {
		int pos = getIndexOfInteger(arr, x);
		int level = 1;

		if (pos == 0)
			return level;

		while (pos >= Math.pow(2, level) - 1) {
			level++;
		}

		return level;
	}

	public int getParentByPos(int pos) {
		if (pos % 2 == 0) {
			return (pos - 2) / 2;
		}
		return (pos - 1) / 2;
	}

	public boolean isCousins(TreeNode root, int x, int y) {
		boolean res = true;

		if (x == y)
			return false;
		
		if (root.val == x || root.val == y)
			return false;

		int[] arr = convertTreetoArr(root);
		int levelX = getLevelByNum(arr, x);
		int levelY = getLevelByNum(arr, y);
		int posX = getIndexOfInteger(arr, x);
		int posY = getIndexOfInteger(arr, y);

		// check if siblings
		if (levelX != levelY)
			res = false;
		else {
			int parentX = getParentByPos(posX);
			int parentY = getParentByPos(posY);
			if (parentX == parentY)
				res = false;

		}

		return res;
	}

	public static TreeNode insertLevelOrder(int[] arr, TreeNode root, int idx) {
		if (idx < arr.length) {
			TreeNode temp = new TreeNode(arr[idx]);
			if(arr[idx] < 0)
				temp = new TreeNode();
			
			root = temp;

			root.left = insertLevelOrder(arr, root.left, 2 * idx + 1);
			root.right = insertLevelOrder(arr, root.right, 2 * idx + 2);
		}
		return root;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] arr = { 1, 2, 3, -1, 4, -1, 5 };
		TreeNode root = new TreeNode();
		root = insertLevelOrder(arr, root, 0);

		long start = System.nanoTime();

		CousinsInBinaryTree obj = new CousinsInBinaryTree();
		boolean ans = obj.isCousins(root, 4, 5);
		System.out.println(ans);

		long fin = System.nanoTime();
		long elapsed = fin - start;
		System.out.println("Time elapsed: " + elapsed + " nano sec");

//		Traversals.InOrder(root);
//		System.out.println();
//		Traversals.PreOrder(root);
//		System.out.println();
//		Traversals.PostOrder(root);
//		System.out.println();
//		Traversals.BreadthFirst(root);

	}

}
