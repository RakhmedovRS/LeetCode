package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 01-Jun-20
 */
@LeetCode(
		id = 563,
		name = "Binary Tree Tilt",
		url = "https://leetcode.com/problems/binary-tree-tilt/",
		difficulty = Difficulty.EASY
)
public class BinaryTreeTilt
{
	public int findTilt(TreeNode root)
	{
		int[] answer = new int[]{0};
		findTilt(root, answer);
		return answer[0];
	}

	public int findTilt(TreeNode root, int[] answer)
	{
		if (root == null)
		{
			return 0;
		}

		int left = findTilt(root.left, answer);
		int right = findTilt(root.right, answer);

		answer[0] += Math.abs(left - right);

		return root.val + left + right;
	}
}
