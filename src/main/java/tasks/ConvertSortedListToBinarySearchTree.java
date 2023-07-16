package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 10-Mar-20
 */
@LeetCode(
		id = 109,
		name = "Convert Sorted List to Binary Search Tree",
		url = "https://leetcode.com/problems/minimum-window-substring/",
		difficulty = Difficulty.MEDIUM
)
public class ConvertSortedListToBinarySearchTree
{
	public TreeNode sortedListToBST(ListNode head)
	{
		List<Integer> values = new ArrayList<>();
		while (head != null)
		{
			values.add(head.val);
			head = head.next;
		}

		return sortedListToBST(0, values.size() - 1, values);
	}

	public TreeNode sortedListToBST(int left, int right, List<Integer> values)
	{
		if (left > right)
		{
			return null;
		}

		if (left == right)
		{
			return new TreeNode(values.get(left));
		}

		int middle = (left + right) / 2;
		TreeNode node = new TreeNode(values.get(middle));
		node.left = sortedListToBST(left, middle - 1, values);
		node.right = sortedListToBST(middle + 1, right, values);
		return node;
	}
}
