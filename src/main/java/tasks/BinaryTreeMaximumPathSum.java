package tasks;

import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 21-Feb-20
 */
@LeetCode(id = 124, name = "Binary Tree Maximum Path Sum", url = "https://leetcode.com/problems/binary-tree-maximum-path-sum/")
public class BinaryTreeMaximumPathSum
{
	public int maxPathSum(TreeNode root)
	{
		int[] answer = new int[]{Integer.MIN_VALUE};
		maxPathSum(root, answer);
		return answer[0];
	}

	private int maxPathSum(TreeNode root, int[] answer)
	{
		if (root == null)
		{
			return 0;
		}

		int left = Math.max(0, maxPathSum(root.left, answer));
		int right = Math.max(0, maxPathSum(root.right, answer));

		answer[0] = Math.max(answer[0], root.val + left + right);

		return Math.max(left, right) + root.val;
	}
}
