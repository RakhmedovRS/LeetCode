/**
 * Search in a Binary Search Tree
 * LeetCode 700
 *
 * @author RakhmedovRS
 * @created 10-Feb-20
 */
public class SearchInBinarySearchTree
{

	public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x){ val = x; }
	}

	public TreeNode searchBST(TreeNode root, int val)
	{
		if (root == null)
		{
			return null;
		}

		if (root.val == val)
		{
			return root;
		}
		else if (val < root.val)
		{
			return searchBST(root.left, val);
		}
		else
		{
			return searchBST(root.right, val);
		}
	}

	public TreeNode searchBST1(TreeNode root, int val)
	{
		if (root == null)
		{
			return null;
		}

		while (root != null)
		{
			if (root.val == val)
			{
				break;
			}
			else if (val < root.val)
			{
				root = root.left;
			}
			else
			{
				root = root.right;
			}
		}

		return root;
	}
}
