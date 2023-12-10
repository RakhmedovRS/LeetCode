package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 24-Aug-20
 */
@LeetCode(
		id = 404,
		name = "Sum of Left Leaves",
		url = "https://leetcode.com/problems/sum-of-left-leaves/",
		difficulty = Difficulty.EASY
)
public class SumOfLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {
		return sumOfLeftLeaves(root, false);
	}

	public int sumOfLeftLeaves(TreeNode root, boolean left) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return left ? root.val : 0;
		}

		return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
	}
}
