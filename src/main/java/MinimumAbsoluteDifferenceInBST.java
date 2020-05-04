import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 04-May-20
 */
@LeetCode(id = 530, name = "Minimum Absolute Difference in BST", url = "https://leetcode.com/problems/minimum-absolute-difference-in-bst/")
public class MinimumAbsoluteDifferenceInBST
{
	public static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(){}

		TreeNode(int val){ this.val = val; }

		TreeNode(int val, TreeNode left, TreeNode right)
		{
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public int getMinimumDifference(TreeNode root)
	{
		List<Integer> inorder = new ArrayList<>();
		inorder(root, inorder);
		int minDiff = Integer.MAX_VALUE;
		if (inorder.size() < 2)
		{
			return 0;
		}

		for (int i = 1; i < inorder.size(); i++)
		{
			int diff = inorder.get(i) - inorder.get(i - 1);
			if (minDiff > diff)
			{
				minDiff = diff;
			}
		}

		return minDiff;
	}

	private void inorder(TreeNode root, List<Integer> inorder)
	{
		if (root == null)
		{
			return;
		}

		inorder(root.left, inorder);
		inorder.add(root.val);
		inorder(root.right, inorder);
	}

	public static void main(String[] args)
	{
		TreeNode treeNode = new TreeNode(1);
		treeNode.right = new TreeNode(3);
		treeNode.right.left = new TreeNode(2);
		System.out.println(new MinimumAbsoluteDifferenceInBST().getMinimumDifference(treeNode));
	}
}
