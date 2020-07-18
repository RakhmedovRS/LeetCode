import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 18-Jul-20
 */
@LeetCode(id = 669, name = "Trim a Binary Search Tree", url = "https://leetcode.com/problems/trim-a-binary-search-tree/")
public class TrimBinarySearchTree
{
	public TreeNode trimBST(TreeNode root, int L, int R)
	{
		if (root == null)
		{
			return null;
		}

		if (root.val < L)
		{
			return trimBST(root.right, L, R);
		}
		else if (root.val > R)
		{
			return trimBST(root.left, L, R);
		}

		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);
		return root;
	}
}
