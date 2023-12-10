package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 23-Jun-20
 */
@LeetCode(
		id = 222,
		name = "Count Complete Tree Nodes",
		url = "https://leetcode.com/problems/count-complete-tree-nodes/",
		difficulty = Difficulty.MEDIUM
)
public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
		int[] count = new int[]{0};
		traverse(root, count);
		return count[0];
	}

	private void traverse(TreeNode root, int[] count) {
		if (root == null) {
			return;
		}

		count[0]++;
		traverse(root.left, count);
		traverse(root.right, count);
	}
}
