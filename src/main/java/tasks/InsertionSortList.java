package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 11/2/2020
 */
@LeetCode(
		id = 147,
		name = "Insertion Sort List",
		url = "https://leetcode.com/problems/insertion-sort-list/",
		difficulty = Difficulty.MEDIUM
)
public class InsertionSortList
{
	public ListNode insertionSortList(ListNode head)
	{
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode next;
		while (head != null)
		{
			next = head.next;
			head.next = null;
			insert(dummy, head);
			head = next;
		}

		return dummy.next;
	}

	private void insert(ListNode dummy, ListNode node)
	{
		ListNode prev = dummy;
		dummy = dummy.next;
		while (dummy != null)
		{
			if (node.val <= dummy.val)
			{
				node.next = dummy;
				prev.next = node;
				return;
			}

			prev = dummy;
			dummy = dummy.next;
		}

		prev.next = node;
	}
}
