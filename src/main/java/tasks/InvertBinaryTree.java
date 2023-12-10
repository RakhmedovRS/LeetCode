package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 10/26/2021
 */
@LeetCode(
		id = 226,
		name = "Invert Binary Tree",
		url = "https://leetcode.com/problems/invert-binary-tree/",
		difficulty = Difficulty.EASY
)
public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode temp = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(temp);

		return root;
	}
}
