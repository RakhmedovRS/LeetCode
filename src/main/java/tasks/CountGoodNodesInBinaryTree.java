package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 13-Jun-20
 */
@LeetCode(
	id = 1448,
	name = "Count Good Nodes in Binary Tree",
	url = "https://leetcode.com/problems/count-good-nodes-in-binary-tree/",
	difficulty = Difficulty.MEDIUM
)
public class CountGoodNodesInBinaryTree
{
	public int goodNodes(TreeNode root)
	{
		return goodNodes(root, Integer.MIN_VALUE);
	}

	public int goodNodes(TreeNode root, int max)
	{
		if (root == null)
		{
			return 0;
		}

		if (root.val >= max)
		{
			return 1 + goodNodes(root.left, root.val) + goodNodes(root.right, root.val);
		}

		return goodNodes(root.left, max) + goodNodes(root.right, max);
	}
}
