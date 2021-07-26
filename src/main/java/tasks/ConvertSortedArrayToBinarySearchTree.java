package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 26-Mar-20
 */
@LeetCode(
	id = 108,
	name = "Convert Sorted Array to Binary Search Tree",
	url = "https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/",
	difficulty = Difficulty.EASY
)
public class ConvertSortedArrayToBinarySearchTree
{
	public TreeNode sortedArrayToBST(int[] nums)
	{
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}

	private TreeNode sortedArrayToBST(int[] nums, int left, int right)
	{
		if (left > right)
		{
			return null;
		}

		if (left == right)
		{
			return new TreeNode(nums[left]);
		}

		int pos = (right + left) / 2;
		TreeNode node = new TreeNode(nums[pos]);
		node.left = sortedArrayToBST(nums, left, pos - 1);
		node.right = sortedArrayToBST(nums, pos + 1, right);
		return node;
	}
}
