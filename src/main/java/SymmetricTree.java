import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 17-Mar-20
 */
@LeetCode(id = 101, name = "Symmetric Tree", url = "https://leetcode.com/problems/symmetric-tree/")
public class SymmetricTree
{
	public boolean isSymmetric(TreeNode root)
	{
		TreeNode secondRoot = cloneAndInvertTree(root);
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

	private TreeNode cloneAndInvertTree(TreeNode root)
	{
		if (root == null)
		{
			return null;
		}

		TreeNode newNode = new TreeNode(root.val);
		newNode.left = cloneAndInvertTree(root.right);
		newNode.right = cloneAndInvertTree(root.left);
		return newNode;
	}
}
