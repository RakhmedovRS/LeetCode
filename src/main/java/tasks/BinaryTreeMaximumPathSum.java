package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 21-Feb-20
 */
@LeetCode(
	id = 124,
	name = "Binary Tree Maximum Path Sum",
	url = "https://leetcode.com/problems/binary-tree-maximum-path-sum/",
	difficulty = Difficulty.HARD
)
public class BinaryTreeMaximumPathSum
{
	public int maxPathSum(TreeNode root)
	{
		int[] max = new int[]{Integer.MIN_VALUE};
		dfs(root, max);
		return max[0];
	}

	private int dfs(TreeNode root, int[] max)
	{
		if (root == null)
		{
			return 0;
		}

		int left = dfs(root.left, max);
		int right = dfs(root.right, max);

		max[0] = Math.max(max[0], Math.max(root.val, Math.max(root.val + left, Math.max(root.val + right, root.val + left + right))));

		return root.val + Math.max(0, Math.max(left, right));
	}
}
