package tasks;

import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 10-Jul-20
 */
@LeetCode(id = 1372, name = "Longest ZigZag Path in a Binary Tree", url = "https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/")
public class LongestZigZagPathInBinaryTree
{
	public int longestZigZag(TreeNode root)
	{
		int[] max = new int[]{0};
		traverse(root.left, true, 1, max);
		traverse(root.right, false, 1, max);
		return max[0];
	}

	private void traverse(TreeNode root, boolean left, int step, int[] max)
	{
		if (root == null)
		{
			return;
		}

		max[0] = Math.max(max[0], step);

		if (left)
		{
			traverse(root.left, true, 1, max);
			traverse(root.right, false, step + 1, max);
		}
		else
		{
			traverse(root.left, true, step + 1, max);
			traverse(root.right, false, 1, max);
		}
	}
}
