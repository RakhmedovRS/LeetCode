package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 12-Sep-20
 */
@LeetCode(
		id = 979,
		name = "Distribute Coins in Binary Tree",
		url = "https://leetcode.com/problems/distribute-coins-in-binary-tree/",
		difficulty = Difficulty.MEDIUM
)
public class DistributeCoinsInBinaryTree
{
	public int distributeCoins(TreeNode root)
	{
		int[] answer = new int[]{0};
		dfs(root, answer);
		return answer[0];
	}

	private int dfs(TreeNode root, int[] answer)
	{
		if (root == null)
		{
			return 0;
		}

		int left = dfs(root.left, answer);
		int right = dfs(root.right, answer);

		answer[0] += Math.abs(left) + Math.abs(right);
		return root.val + left + right - 1;
	}

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(0);
		root.left.right = new TreeNode(3);

		System.out.println(new DistributeCoinsInBinaryTree().distributeCoins(root));
	}
}
