package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 12/9/2020
 */
@LeetCode(
		id = 270,
		name = "Closest Binary Search Tree Value",
		url = "https://leetcode.com/problems/closest-binary-search-tree-value/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
		double diff = Double.MAX_VALUE;
		int closest = Integer.MAX_VALUE;
		while (root != null) {
			if (diff > Math.abs(target - root.val)) {
				diff = Math.abs(target - root.val);
				closest = root.val;
			}

			root = target < root.val ? root.left : root.right;
		}

		return closest;
	}
}
