package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 12/22/2020
 */
@LeetCode(
		id = 110,
		name = "Balanced Binary Tree",
		url = "https://leetcode.com/problems/balanced-binary-tree/",
		difficulty = Difficulty.EASY
)
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		boolean[] balanced = new boolean[]{true};
		dfs(root, balanced);
		return balanced[0];
	}

	private int dfs(TreeNode root, boolean[] balanced) {
		if (!balanced[0]) {
			return Integer.MAX_VALUE;
		}

		if (root == null) {
			return 0;
		}

		int left = dfs(root.left, balanced);
		int right = dfs(root.right, balanced);

		if (left == Integer.MAX_VALUE || right == Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}

		if (Math.abs(left - right) > 1) {
			balanced[0] = false;
			return Integer.MAX_VALUE;
		}

		return Math.max(left, right) + 1;
	}
}
