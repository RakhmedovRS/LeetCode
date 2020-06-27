import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 27-Jun-20
 */
@LeetCode(id = 897, name = "Increasing Order Search Tree", url = "https://leetcode.com/problems/increasing-order-search-tree/")
public class IncreasingOrderSearchTree
{
	public TreeNode increasingBST(TreeNode root)
	{
		if (root == null)
		{
			return null;
		}

		TreeNode ans = new TreeNode(0);
		TreeNode[] prev = new TreeNode[]{ans};
		traverse(root, prev);

		return ans.right;
	}

	private void traverse(TreeNode root, TreeNode[] prev)
	{
		if (root == null)
		{
			return;
		}

		traverse(root.left, prev);
		prev[0].left = null;
		prev[0].right = root;
		prev[0] = root;
		traverse(root.right, prev);
	}

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(8);
		root.right.right.left = new TreeNode(7);
		root.right.right.right  = new TreeNode(9);

		new IncreasingOrderSearchTree().increasingBST(root);
	}
}
