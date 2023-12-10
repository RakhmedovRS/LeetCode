package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 8/23/2021
 */
@LeetCode(
		id = 653,
		name = "Two Sum IV - Input is a BST",
		url = "https://leetcode.com/problems/two-sum-iv-input-is-a-bst/",
		difficulty = Difficulty.EASY
)
public class TwoSumIVInputIsBST {
	public boolean findTarget(TreeNode root, int k) {
		return dfs(root, k, new HashSet<>());
	}

	private boolean dfs(TreeNode root, int k, Set<Integer> set) {
		if (root == null) {
			return false;
		}

		if (set.contains(k - root.val)) {
			return true;
		}

		set.add(root.val);

		return dfs(root.left, k, set) || dfs(root.right, k, set);
	}
}
