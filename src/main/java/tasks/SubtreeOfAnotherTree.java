package tasks;

import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 29-May-20
 */
@LeetCode(id = 572, name = "Subtree of Another Tree", url = "https://leetcode.com/problems/subtree-of-another-tree/")
public class SubtreeOfAnotherTree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}
		else if (s == null || t == null) {
			return false;
		}

		boolean sub = false;
		if (s.val == t.val) {
			sub = equals(s.left, t.left) && equals(s.right, t.right);
		}

		return sub || (isSubtree(s.left, t) || isSubtree(s.right, t));
	}

	private boolean equals(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}
		else if (s == null || t == null) {
			return false;
		}

		return s.val == t.val && equals(s.left, t.left) && equals(s.right, t.right);
	}
}
