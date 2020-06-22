import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 22-Jun-20
 */
@LeetCode(id = 1026, name = "Maximum Difference Between Node and Ancestor", url = "https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/")
public class MaximumDifferenceBetweenNodeAndAncestor
{
	public int maxAncestorDiff(TreeNode root)
	{
		int[] ans = new int[]{Integer.MIN_VALUE};
		maxAncestorDiff(root, root.val, root.val, ans);
		return ans[0];
	}

	private void maxAncestorDiff(TreeNode root, int max, int min, int[] ans)
	{
		if (root == null)
		{
			return;
		}

		ans[0] = Math.max(ans[0], Math.max(Math.abs(max - root.val), Math.abs(root.val - min)));
		maxAncestorDiff(root.left, Math.max(root.val, max), Math.min(root.val, min), ans);
		maxAncestorDiff(root.right, Math.max(root.val, max), Math.min(root.val, min), ans);
	}
}
