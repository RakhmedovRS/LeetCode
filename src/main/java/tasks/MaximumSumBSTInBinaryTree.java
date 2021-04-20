package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 1/13/2021
 */
@LeetCode(
	id = 1373,
	name = "Maximum Sum BST in Binary Tree",
	url = "https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/",
	difficulty = Difficulty.HARD
)
public class MaximumSumBSTInBinaryTree
{
	public int maxSumBST(TreeNode root)
	{
		int[] max = new int[]{0};
		dfs(root, max);
		return max[0];
	}

	private int[] dfs(TreeNode root, int[] max)
	{
		if (root == null)
		{
			return new int[]{1, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
		}

		int[] left = dfs(root.left, max);
		int[] right = dfs(root.right, max);

		boolean isValid = left[0] == 1 && right[0] == 1 && left[1] < root.val && root.val < right[2];
		int sum = root.val + left[3] + right[3];
		if (isValid)
		{
			max[0] = Math.max(max[0], sum);
		}

		return new int[]{isValid ? 1 : 0, Math.max(root.val, right[1]), Math.min(root.val, left[2]), sum};
	}
}
