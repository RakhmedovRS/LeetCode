import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 10-Feb-20
 */
@LeetCode(id = 700, name = "Search in a Binary Search Tree", url = "https://leetcode.com/problems/search-in-a-binary-search-tree/")
public class SearchInBinarySearchTree
{
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
