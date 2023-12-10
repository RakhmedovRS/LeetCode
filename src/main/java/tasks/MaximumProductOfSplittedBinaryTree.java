package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 06-May-20
 */
@LeetCode(
		id = 1339,
		name = "Maximum Product of Splitted Binary Tree",
		url = "https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumProductOfSplittedBinaryTree {
	public int maxProduct(TreeNode root) {
		Map<TreeNode, Long> memo = new HashMap<>();
		dfs(root, memo);
		long[] max = new long[]{Long.MIN_VALUE};
		findMax(root, max, memo, memo.get(root));
		return (int) (max[0] % 1_000_000_007);
	}

	private void findMax(TreeNode node, long[] max, Map<TreeNode, Long> memo, long sum) {
		if (node == null) {
			return;
		}

		if (node.left != null) {
			max[0] = Math.max(max[0], (sum - memo.get(node.left)) * memo.get(node.left));
			findMax(node.left, max, memo, sum);
		}

		if (node.right != null) {
			max[0] = Math.max(max[0], (sum - memo.get(node.right)) * memo.get(node.right));
			findMax(node.right, max, memo, sum);
		}
	}

	private long dfs(TreeNode node, Map<TreeNode, Long> memo) {
		if (node == null) {
			return 0;
		}

		long sum = node.val + dfs(node.left, memo) + dfs(node.right, memo);
		memo.put(node, sum);
		return sum;
	}
}
