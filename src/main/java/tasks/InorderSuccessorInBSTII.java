package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/13/2021
 */
@LeetCode(
		id = 510,
		name = "Inorder Successor in BST II",
		url = "https://leetcode.com/problems/inorder-successor-in-bst-ii/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class InorderSuccessorInBSTII {
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node parent;
	}

	public Node inorderSuccessor(Node node) {
		if (node.right != null) {
			Node n = node.right;
			while (n.left != null) {
				n = n.left;
			}

			return n;
		}
		else {
			Node parent;
			while (node != null) {
				parent = node.parent;
				if (parent != null && parent.left == node) {
					return parent;
				}

				node = parent;
			}
		}

		return null;
	}
}
