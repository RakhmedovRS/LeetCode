import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 17-May-20
 */
@LeetCode(id = 701, name = "Insert into a Binary Search Tree", url = "https://leetcode.com/problems/insert-into-a-binary-search-tree/")
public class InsertIntoBinarySearchTree
{
	public TreeNode insertIntoBST(TreeNode root, int val)
	{
		if (root == null)
		{
			return new TreeNode(val);
		}

		if (root.val > val)
		{
			root.left = insertIntoBST(root.left, val);
		}
		else
		{
			root.right = insertIntoBST(root.right, val);
		}

		return root;
	}

	public static void main(String[] args)
	{

	}
}
