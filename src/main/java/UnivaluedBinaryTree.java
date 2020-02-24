/**
 * Univalued Binary Tree
 * LeetCode 965
 *
 * @author RakhmedovRS
 * @created 24-Feb-20
 */
public class UnivaluedBinaryTree
{
	public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x){ val = x; }
	}

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
