package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 18-Jul-20
 */
@LeetCode(
		id = 669,
		name = "Trim a Binary Search Tree",
		url = "https://leetcode.com/problems/trim-a-binary-search-tree/",
		difficulty = Difficulty.MEDIUM
)
public class TrimBinarySearchTree {
	public TreeNode trimBST(TreeNode root, int low, int high) {
		if (root == null) {
			return null;
		}

		if (low <= root.val && root.val <= high) {
			root.left = trimBST(root.left, low, high);
			root.right = trimBST(root.right, low, high);
			return root;
		}
		else if (low >= root.val) {
			return trimBST(root.right, low, high);
		}
		else if (high <= root.val) {
			return trimBST(root.left, low, high);
		}

		return null;
	}
}
