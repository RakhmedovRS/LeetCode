import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 20-Mar-20
 */
@LeetCode(id = 98, name = "Validate Binary Search Tree", url = "https://leetcode.com/problems/validate-binary-search-tree/")
public class ValidateBinarySearchTree
{
	public static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x){ val = x; }
	}

	public boolean isValidBST(TreeNode root)
	{
		return isValidBST(root, null, null);
	}

	public boolean isValidBST(TreeNode root, Integer left, Integer right)
	{
		if (root == null)
		{
			return true;
		}

		if ((left == null || root.val > left) && (right == null || root.val < right))
		{
			return isValidBST(root.left, left, root.val) && isValidBST(root.right, root.val, right);
		}

		return false;
	}

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		System.out.println(new ValidateBinarySearchTree().isValidBST(root));
		System.out.println(new ValidateBinarySearchTree().isValidBST(new TreeNode(Integer.MAX_VALUE)));
	}
}
