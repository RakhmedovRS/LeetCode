import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 24-May-20
 */
@LeetCode(id = 1038, name = "Binary Search Tree to Greater Sum Tree", url = "https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/")
public class BinarySearchTreeToGreaterSumTree
{
	public TreeNode bstToGst(TreeNode root)
	{
		bstToGst(root, new int[]{0});
		return root;
	}

	private void bstToGst(TreeNode root, int[] sum)
	{
		if (root == null)
		{
			return;
		}

		bstToGst(root.right, sum);
		sum[0] += root.val;
		root.val = sum[0];
		bstToGst(root.left, sum);
	}
}
