package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 04-Jun-20
 */
@LeetCode(
		id = 1457,
		name = "Pseudo-Palindromic Paths in a Binary Tree",
		url = "https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/",
		difficulty = Difficulty.MEDIUM
)
public class PseudoPalindromicPathsInBinaryTree {
	public int pseudoPalindromicPaths(TreeNode root) {
		int[] count = new int[]{0};
		int[] table = new int[10];
		dfs(root, table, count);

		return count[0];
	}

	private void dfs(TreeNode root, int[] table, int[] count) {
		if (root == null) {
			return;
		}
		table[root.val]++;

		if (root.left == null && root.right == null) {
			count[0] += isPalindromePermutation(table) ? 1 : 0;
		}
		else {
			dfs(root.left, table, count);
			dfs(root.right, table, count);
		}

		table[root.val]--;
	}

	private boolean isPalindromePermutation(int[] table) {
		boolean seenOdd = false;
		for (int num : table) {
			if (num % 2 != 0) {
				if (seenOdd) {
					return false;
				}

				seenOdd = true;
			}
		}

		return true;
	}
}
