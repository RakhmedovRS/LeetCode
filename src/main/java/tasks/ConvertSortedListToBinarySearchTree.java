package tasks;

import common.LeetCode;
import common.ListNode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 10-Mar-20
 */
@LeetCode(id = 109, name = "Convert Sorted List to Binary Search Tree", url = "https://leetcode.com/problems/minimum-window-substring/")
public class ConvertSortedListToBinarySearchTree
{
	private TreeNode convertListToBST(int left, int right, ListNode[] currentHead)
	{
		if (left > right)
		{
			return null;
		}

		int mid = (left + right) / 2;

		TreeNode leftNode = convertListToBST(left, mid - 1, currentHead);

		TreeNode node = new TreeNode(currentHead[0].val);
		node.left = leftNode;

		currentHead[0] = currentHead[0].next;

		node.right = convertListToBST(mid + 1, right, currentHead);
		return node;
	}

	public TreeNode sortedListToBST(ListNode head)
	{
		if (head == null)
		{
			return null;
		}

		ListNode temp = head;
		int size = 0;
		while (temp != null)
		{
			temp = temp.next;
			size++;
		}

		ListNode[] currentHead = new ListNode[]{head};
		return convertListToBST(0, size - 1, currentHead);
	}
}
