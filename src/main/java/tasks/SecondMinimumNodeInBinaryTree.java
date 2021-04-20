package tasks;

import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 22-Jun-20
 */
@LeetCode(id = 671, name = "Second Minimum Node In a Binary Tree", url = "https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/")
public class SecondMinimumNodeInBinaryTree
{
	public int findSecondMinimumValue(TreeNode root)
	{
		if (root == null)
		{
			return -1;
		}
		Integer[] ans = new Integer[]{null};
		findSecondMinimumValue(root, root.val, ans);
		return ans[0] == Integer.MAX_VALUE ? -1 : ans[0];
	}

	private void findSecondMinimumValue(TreeNode root, int prev, Integer[] ans)
	{
		if (root == null)
		{
			return;
		}

		if (root.val != prev)
		{
			if (ans[0] == null)
			{
				ans[0] = root.val;
			}
			else
			{
				ans[0] = Math.min(ans[0], root.val);
			}
		}

		if (root.left == null)
		{
			return;
		}

		findSecondMinimumValue(root.left, prev, ans);
		findSecondMinimumValue(root.right, prev, ans);
	}

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(8);
		root.right = new TreeNode(5);
		System.out.println(new SecondMinimumNodeInBinaryTree().findSecondMinimumValue(root));
	}
}
