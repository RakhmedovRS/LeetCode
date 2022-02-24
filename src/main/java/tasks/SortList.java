package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 04-Mar-20
 */
@LeetCode(
	id = 148,
	name = "Sort List",
	url = "https://leetcode.com/problems/sort-list/",
	difficulty = Difficulty.MEDIUM
)
public class SortList
{
	public ListNode sortList(ListNode head)
	{
		int size = 0;
		ListNode temp = head;
		while (temp != null)
		{
			size++;
			temp = temp.next;
		}

		return sortList(head, 0, size - 1);
	}

	private ListNode sortList(ListNode head, int left, int right)
	{
		if (left >= right)
		{
			return head;
		}

		ListNode nodeA = head;
		ListNode currentA = head;
		ListNode nodeB = null;
		int middle = left + (right - left) / 2;

		for (int i = left; i < middle; i++)
		{
			currentA = currentA.next;
		}

		if (currentA != null)
		{
			nodeB = currentA.next;
			currentA.next = null;
		}

		nodeA = sortList(nodeA, left, middle);
		nodeB = sortList(nodeB, middle + 1, right);

		return merge(nodeA, nodeB);
	}

	private ListNode merge(ListNode nodeA, ListNode nodeB)
	{
		if (nodeA == null)
		{
			return nodeB;
		}

		if (nodeB == null)
		{
			return nodeA;
		}

		ListNode dummy = new ListNode();
		ListNode current = dummy;
		while (nodeA != null && nodeB != null)
		{
			if (nodeA.val < nodeB.val)
			{
				current.next = nodeA;
				current = current.next;
				nodeA = nodeA.next;
			}
			else
			{
				current.next = nodeB;
				current = current.next;
				nodeB = nodeB.next;
			}
		}

		while (nodeA != null)
		{
			current.next = nodeA;
			current = current.next;
			nodeA = nodeA.next;
		}

		while (nodeB != null)
		{
			current.next = nodeB;
			current = current.next;
			nodeB = nodeB.next;
		}

		current.next = null;

		return dummy.next;
	}
}
