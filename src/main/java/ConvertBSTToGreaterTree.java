import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 27-May-20
 */
@LeetCode(
	id = 538,
	name = "Convert BST to Greater Tree",
	url = "https://leetcode.com/problems/convert-bst-to-greater-tree/",
	difficulty = Difficulty.MEDIUM
)
public class ConvertBSTToGreaterTree
{
	public TreeNode convertBST(TreeNode root)
	{
		LinkedList<TreeNode> nodes = new LinkedList<>();
		inorder(root, nodes);

		int sum = 0;
		while (!nodes.isEmpty())
		{
			TreeNode current = nodes.removeLast();
			int temp = current.val;
			current.val += sum;
			sum += temp;
		}

		return root;
	}

	private void inorder(TreeNode root, LinkedList<TreeNode> nodes)
	{
		if (root == null)
		{
			return;
		}

		inorder(root.left, nodes);
		nodes.addLast(root);
		inorder(root.right, nodes);
	}
}
