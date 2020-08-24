import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 24-Aug-20
 */
@LeetCode(id = 654, name = "Maximum Binary Tree", url = "https://leetcode.com/problems/maximum-binary-tree/")
public class MaximumBinaryTree
{
	public TreeNode constructMaximumBinaryTree(int[] nums)
	{
		return constructMaximumBinaryTree(nums, 0, nums.length - 1);
	}

	public TreeNode constructMaximumBinaryTree(int[] nums, int left, int right)
	{
		int index = findMaxIndex(nums, left, right);
		if (index == -1)
		{
			return null;
		}

		TreeNode node = new TreeNode(nums[index]);
		node.left = constructMaximumBinaryTree(nums, left, index - 1);
		node.right = constructMaximumBinaryTree(nums, index + 1, right);
		return node;
	}

	private int findMaxIndex(int[] nums, int left, int right)
	{
		if (left == right)
		{
			return left;
		}

		if (left > right)
		{
			return -1;
		}

		int idx = left;
		for (int i = left; i <= right; i++)
		{
			if (nums[i] > nums[idx])
			{
				idx = i;
			}
		}

		return idx;
	}
}
