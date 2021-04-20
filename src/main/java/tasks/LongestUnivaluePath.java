package tasks;

import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 08-Aug-20
 */
@LeetCode(id = 687, name = "Longest Univalue Path", url = "https://leetcode.com/problems/longest-univalue-path/")
public class LongestUnivaluePath
{
	public int longestUnivaluePath(TreeNode root)
	{
		int[] max = new int[]{0};
		return dfs(root, max);
	}

	private int dfs(TreeNode root, int[] max)
	{
		if (root == null)
		{
			return 0;
		}

		int left = dfs(root.left, max);
		int right = dfs(root.right, max);
		int fromLeft = 0;
		int fromRight = 0;
		if (root.left != null && root.val == root.left.val)
		{
			fromLeft += left + 1;
		}

		if (root.right != null && root.val == root.right.val)
		{
			fromRight += right + 1;
		}

		max[0] = Math.max(max[0], fromLeft + fromRight);

		return Math.max(fromLeft, fromRight);
	}

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println(new LongestUnivaluePath().longestUnivaluePath(root));
	}
}
