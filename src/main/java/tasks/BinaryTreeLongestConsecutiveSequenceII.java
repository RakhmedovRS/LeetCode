package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 1/15/2021
 */
@LeetCode(
	id = 549,
	name = "Binary Tree Longest Consecutive Sequence II",
	url = "https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class BinaryTreeLongestConsecutiveSequenceII
{
	public int longestConsecutive(TreeNode root)
	{
		int[] max = new int[]{0};
		dfs(root, max);
		return max[0];
	}

	private int[] dfs(TreeNode root, int[] max)
	{
		if (root == null)
		{
			return new int[]{10_000_000, 0, -10_000_000, 0};
		}

		int[] left = dfs(root.left, max);
		int[] right = dfs(root.right, max);

		max[0] = Math.max(max[0], Math.max(left[1], left[3]));
		max[0] = Math.max(max[0], Math.max(right[1], right[3]));

		if (left[0] == root.val - 1 && root.val + 1 == right[2])
		{
			max[0] = Math.max(max[0], 1 + left[1] + right[3]);
		}

		if (left[2] == root.val + 1 && root.val - 1 == right[0])
		{
			max[0] = Math.max(max[0], 1 + left[3] + right[1]);
		}

		//increase
		if (left[0] == root.val - 1)
		{
			left[1]++;
		}
		else
		{
			left[1] = 1;
		}

		//decrease
		if (left[2] == root.val + 1)
		{
			left[3]++;
		}
		else
		{
			left[3] = 1;
		}

		//increase
		if (right[0] == root.val - 1)
		{
			right[1]++;
		}
		else
		{
			right[1] = 1;
		}

		//decrease
		if (right[2] == root.val + 1)
		{
			right[3]++;
		}
		else
		{
			right[3] = 1;
		}

		int[] incDed = new int[]{root.val, Math.max(left[1], right[1]), root.val, Math.max(left[3], right[3])};

		max[0] = Math.max(max[0], Math.max(incDed[1], incDed[3]));

		return incDed;
	}
}
