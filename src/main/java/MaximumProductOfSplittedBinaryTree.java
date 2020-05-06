import common.LeetCode;

import java.util.HashMap;

/**
 * @author RakhmedovRS
 * @created 06-May-20
 */
@LeetCode(id = 1339, name = "Maximum Product of Splitted Binary Tree", url = "https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/")
public class MaximumProductOfSplittedBinaryTree
{
	public class TreeNode
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

	public int maxProduct(TreeNode root)
	{
		HashMap<TreeNode, Integer> nodeToSum = new HashMap<>();
		long totalSum = calculateTotalSum(root, nodeToSum);
		long[] maxProduct = new long[]{0};
		maxProduct(root, totalSum, maxProduct, nodeToSum);
		return (int) (maxProduct[0] % (1e9 + 7));
	}

	private void maxProduct(TreeNode root, long totalSum, long[] maxProduct, HashMap<TreeNode, Integer> nodeToSum)
	{
		if (root == null)
		{
			return;
		}

		long leftSubTreeSum = nodeToSum.getOrDefault(root.left, 0);
		long rightSubTreeSum = nodeToSum.getOrDefault(root.right, 0);
		long leftMax = (totalSum - leftSubTreeSum) * leftSubTreeSum;
		long rightMax = (totalSum - rightSubTreeSum) * rightSubTreeSum;

		if (leftMax > maxProduct[0])
		{
			maxProduct[0] = leftMax;
		}

		if (rightMax > maxProduct[0])
		{
			maxProduct[0] = rightMax;
		}

		maxProduct(root.left, totalSum, maxProduct, nodeToSum);
		maxProduct(root.right, totalSum, maxProduct, nodeToSum);
	}

	private int calculateTotalSum(TreeNode root, HashMap<TreeNode, Integer> nodeToSum)
	{
		if (root == null)
		{
			return 0;
		}

		int subTreeSum = root.val + calculateTotalSum(root.left, nodeToSum) + calculateTotalSum(root.right, nodeToSum);

		nodeToSum.put(root, subTreeSum);

		return subTreeSum;
	}
}
