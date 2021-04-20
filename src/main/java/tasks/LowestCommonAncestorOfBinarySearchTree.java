package tasks;

import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 12-May-20
 */
@LeetCode(id = 235, name = "Lowest Common Ancestor of a Binary Search Tree", url = "https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/")
public class LowestCommonAncestorOfBinarySearchTree
{
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
	{
		if (p.val > q.val)
		{
			return lowestCommonAncestor(root, q, p);
		}

		if (root.val >= p.val && root.val <= q.val)
		{
			return root;
		}
		else if (p.val < root.val)
		{
			return lowestCommonAncestor(root.left, q, p);
		}
		else
		{
			return lowestCommonAncestor(root.right, q, p);
		}
	}
}
