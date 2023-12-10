package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 11/15/2020
 */
@LeetCode(
		id = 938,
		name = "Range Sum of BST",
		url = "https://leetcode.com/problems/range-sum-of-bst/",
		difficulty = Difficulty.EASY
)
public class RangeSumOfBST {
	public int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null) {
			return 0;
		}

		if (low <= root.val && root.val <= high) {
			return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
		}

		return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
	}
}
