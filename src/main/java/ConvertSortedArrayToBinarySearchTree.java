import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 26-Mar-20
 */
@LeetCode(id = 108, name = "Convert Sorted Array to Binary Search Tree", url = "https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/")
public class ConvertSortedArrayToBinarySearchTree
{
	private TreeNode getChild(int[] nums, int left, int right)
	{
		if (left > right)
		{
			return null;
		}
		int rootIndex = left + (right - left) / 2;
		TreeNode node = new TreeNode(nums[rootIndex]);
		node.left = getChild(nums, left, rootIndex - 1);
		node.right = getChild(nums, rootIndex + 1, right);

		return node;
	}

	public TreeNode sortedArrayToBST(int[] nums)
	{
		if (nums.length == 0)
		{
			return null;
		}
		return getChild(nums, 0, nums.length - 1);
	}
}
