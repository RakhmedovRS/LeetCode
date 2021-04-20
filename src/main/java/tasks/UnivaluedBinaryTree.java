package tasks;

import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 24-Feb-20
 */
@LeetCode(id = 965, name = "Univalued Binary Tree", url = "https://leetcode.com/problems/univalued-binary-tree/")
public class UnivaluedBinaryTree
{
	public boolean isUnivalTree(TreeNode root)
	{
		if (root == null || (root.left == null && root.right == null))
		{
			return true;
		}

		if (root.left != null && root.right != null)
		{
			return root.val == root.left.val && root.val == root.right.val && isUnivalTree(root.left) && isUnivalTree(root.right);
		}
		else if (root.left != null)
		{
			return root.val == root.left.val && isUnivalTree(root.left);
		}
		else
		{
			return root.val == root.right.val && isUnivalTree(root.right);
		}
	}
}
