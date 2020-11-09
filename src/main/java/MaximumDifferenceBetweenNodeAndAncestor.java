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
		long[] diff = new long[]{0};
		dfs(root, diff);
		return (int) diff[0];
	}

	private long[] dfs(TreeNode root, long[] diff)
	{
		if (root == null)
		{
			return new long[0];
		}

		long[] minMax;
		if (root.left == null && root.right == null)
		{
			return new long[]{Math.abs(root.val), Math.abs(root.val)};
		}
		else if (root.right == null)
		{
			minMax = dfs(root.left, diff);
			minMax[0] = Math.min(minMax[0], Math.abs(root.val));
			minMax[1] = Math.max(minMax[1], Math.abs(root.val));
		}
		else if (root.left == null)
		{
			minMax = dfs(root.right, diff);
			minMax[0] = Math.min(minMax[0], Math.abs(root.val));
			minMax[1] = Math.max(minMax[1], Math.abs(root.val));
		}
		else
		{
			long[] lMinMax = dfs(root.left, diff);
			long[] rMinMax = dfs(root.right, diff);

			minMax = new long[]{Math.min(lMinMax[0], rMinMax[0]), Math.max(lMinMax[1], rMinMax[1])};
		}

		diff[0] = Math.max(diff[0], Math.abs(root.val - minMax[0]));
		diff[0] = Math.max(diff[0], Math.abs(root.val - minMax[1]));

		minMax[0] = Math.min(minMax[0], Math.abs(root.val));
		minMax[1] = Math.max(minMax[1], Math.abs(root.val));
		return minMax;
	}
}
