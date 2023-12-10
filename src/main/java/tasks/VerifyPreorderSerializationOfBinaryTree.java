package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 07-Aug-20
 */
@LeetCode(
		id = 331,
		name = "Verify Preorder Serialization of a Binary Tree",
		url = "https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/",
		difficulty = Difficulty.MEDIUM
)
public class VerifyPreorderSerializationOfBinaryTree {
	class TreeNode {
		public String val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(String x) {
			val = x;
		}
	}

	public boolean isValidSerialization(String preorder) {
		String[] parts = preorder.split(",");

		Map<TreeNode, TreeNode> parents = new HashMap<>();
		TreeNode root = new TreeNode(parts[0]);
		TreeNode current = root;
		parents.put(current, null);
		for (int i = 1; i < parts.length; i++) {
			while (true) {
				if (current == null) {
					return false;
				}

				if (current.left == null) {
					current.left = new TreeNode(parts[i]);
					parents.put(current.left, current);
					if (!"#".equals(parts[i])) {
						current = current.left;
					}
					break;
				}
				else if (current.right == null) {
					current.right = new TreeNode(parts[i]);
					parents.put(current.right, current);
					if (!"#".equals(parts[i])) {
						current = current.right;
					}
					break;
				}
				else {
					current = parents.get(current);
				}
			}
		}

		return validate(root);
	}

	private boolean validate(TreeNode node) {
		if (node == null) {
			return false;
		}

		if ("#".equals(node.val)) {
			return node.left == null && node.right == null;
		}

		return validate(node.left) && validate(node.right);
	}
}
