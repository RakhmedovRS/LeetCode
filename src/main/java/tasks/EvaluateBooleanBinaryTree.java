package tasks;

/**
 * @author RakhmedovRS
 * @created 7/9/2022
 */

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

@LeetCode(
		id = 2331,
		name = "Evaluate Boolean Binary Tree",
		url = "https://leetcode.com/problems/evaluate-boolean-binary-tree/",
		difficulty = Difficulty.EASY
)
public class EvaluateBooleanBinaryTree {
	public boolean evaluateTree(TreeNode root) {
		if (root.left == null && root.right == null) {
			return root.val == 1;
		}

		if (root.val == 2) {
			return evaluateTree(root.left) || evaluateTree(root.right);
		}
		else {
			return evaluateTree(root.left) && evaluateTree(root.right);
		}
	}
}
