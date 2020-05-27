import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 27-May-20
 */
@LeetCode(id = 538, name = "Convert BST to Greater Tree", url = "https://leetcode.com/problems/convert-bst-to-greater-tree/")
public class ConvertBSTToGreaterTree
{
	public TreeNode convertBST(TreeNode root)
	{
		convertBST(root, new int[]{0});
		return root;
	}

	private void convertBST(TreeNode root, int[] sum)
	{
		if (root == null)
		{
			return;
		}

		convertBST(root.right, sum);
		sum[0] += root.val;
		root.val = sum[0];
		convertBST(root.left, sum);
	}
}
