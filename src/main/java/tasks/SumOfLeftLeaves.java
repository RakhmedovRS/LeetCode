package tasks;

import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 24-Aug-20
 */
@LeetCode(id = 404, name = "Sum of Left Leaves", url = "https://leetcode.com/problems/sum-of-left-leaves/")
public class SumOfLeftLeaves
{
	public int sumOfLeftLeaves(TreeNode root)
	{
		if (root == null)
		{
			return 0;
		}

		return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
	}

	public int sumOfLeftLeaves(TreeNode root, boolean isLeft)
	{
		if (root == null)
		{
			return 0;
		}

		if (root.left == null && root.right == null)
		{
			return isLeft ? root.val : 0;
		}

		return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
	}
}
