package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 12/15/2020
 */
@LeetCode(
		id = 1120,
		name = "Maximum Average Subtree",
		url = "https://leetcode.com/problems/maximum-average-subtree/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class MaximumAverageSubtree {
	public double maximumAverageSubtree(TreeNode root) {
		return dfs(root)[2];
	}

	public double[] dfs(TreeNode root) {
		if (root == null) {
			return new double[3];
		}

		if (root.left == null && root.right == null) {
			return new double[]{root.val, 1, root.val};
		}

		double[] left = dfs(root.left);
		double[] right = dfs(root.right);

		double sum = root.val + left[0] + right[0];
		double count = 1 + left[1] + right[1];
		double max = Math.max(sum / count, Math.max(left[2], right[2]));

		return new double[]{sum, count, max};
	}
}
