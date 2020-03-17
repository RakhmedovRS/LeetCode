import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 17-Mar-20
 */
@LeetCode(id = 101, name = "Symmetric Tree", url = "https://leetcode.com/problems/symmetric-tree/")
public class SymmetricTree
{
	public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x){ val = x; }
	}

	public boolean isSymmetric(TreeNode root)
	{
		TreeNode secondRoot = cloneTree(root);
		invertTree(secondRoot);
		return isSameTree(root, secondRoot);
	}

	private boolean isSameTree(TreeNode firstRoot, TreeNode secondRoot)
	{
		if (firstRoot == null && secondRoot == null)
		{
			return true;
		}

		if (firstRoot != null && secondRoot != null)
		{
			if (firstRoot.val == secondRoot.val)
			{
				return isSameTree(firstRoot.left, secondRoot.left) && isSameTree(firstRoot.right, secondRoot.right);
			}
		}

		return false;
	}

	private TreeNode cloneTree(TreeNode root)
	{
		if (root == null)
		{
			return null;
		}

		TreeNode newNode = new TreeNode(root.val);
		newNode.left = cloneTree(root.left);
		newNode.right = cloneTree(root.right);
		return newNode;
	}

	private void invertTree(TreeNode root)
	{
		if (root == null)
		{
			return;
		}

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		invertTree(root.left);
		invertTree(root.right);
	}
}
