package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 01-May-20
 */
@LeetCode(
		id = 236,
		name = "Lowest Common Ancestor of a Binary Tree",
		url = "https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/",
		difficulty = Difficulty.MEDIUM
)
public class LowestCommonAncestorOfBinaryTree
{
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
	{
		if (root == null)
		{
			return null;
		}

		if (root.val == p.val || root.val == q.val)
		{
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (right != null && left != null)
		{
			return root;
		}
		else if (left != null)
		{
			return left;
		}
		else
		{
			return right;
		}
	}
}
