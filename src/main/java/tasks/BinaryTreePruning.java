package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 18-Feb-20
 */
@LeetCode(
	id = 814,
	name = "Binary Tree Pruning",
	url = "https://leetcode.com/problems/binary-tree-pruning/",
	difficulty = Difficulty.MEDIUM
)
public class BinaryTreePruning
{
	public boolean needDeleteNode(TreeNode root)
	{
		if (root == null)
		{
			return false;
		}

		if (needDeleteNode(root.left))
		{
			root.left = null;
		}

		if (needDeleteNode(root.right))
		{
			root.right = null;
		}

		return root.val == 0 && root.left == null && root.right == null;
	}

	public TreeNode pruneTree(TreeNode root)
	{
		if (!needDeleteNode(root))
		{
			return null;
		}

		return root;
	}

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(0);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(1);
		new BinaryTreePruning().pruneTree(root);
	}
}
