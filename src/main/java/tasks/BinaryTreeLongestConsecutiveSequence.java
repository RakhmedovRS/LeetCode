package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 12/30/2020
 */
@LeetCode(
	id = 298,
	name = "Binary Tree Longest Consecutive Sequence",
	url = "https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class BinaryTreeLongestConsecutiveSequence
{
	public int longestConsecutive(TreeNode root)
	{
		if (root == null)
		{
			return 0;
		}

		int[] max = new int[]{0};
		dfs(root, root.val, 0, max);
		return max[0];
	}

	private void dfs(TreeNode root, int prevVal, int len, int[] max)
	{
		max[0] = Math.max(max[0], len);

		if (root == null)
		{
			return;
		}

		if (root.val - prevVal == 1)
		{
			dfs(root.left, root.val, len + 1, max);
			dfs(root.right, root.val, len + 1, max);
		}
		else
		{
			dfs(root.left, root.val, 1, max);
			dfs(root.right, root.val, 1, max);
		}
	}
}
