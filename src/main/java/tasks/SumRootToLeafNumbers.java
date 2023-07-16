package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 26-Jun-20
 */
@LeetCode(
		id = 129,
		name = "Sum Root to Leaf Numbers",
		url = "https://leetcode.com/problems/sum-root-to-leaf-numbers/",
		difficulty = Difficulty.MEDIUM
)
public class SumRootToLeafNumbers
{
	public int sumNumbers(TreeNode root)
	{
		return sumNumbers(root, 0);
	}

	public int sumNumbers(TreeNode root, int current)
	{
		if (root == null)
		{
			return 0;
		}

		current *= 10;
		current += root.val;

		if (root.left == null && root.right == null)
		{
			return current;
		}

		return sumNumbers(root.left, current) + sumNumbers(root.right, current);
	}
}
