package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 10/28/2021
 */
@LeetCode(
	id = 2046,
	name = "Sort Linked List Already Sorted Using Absolute Values",
	url = "https://leetcode.com/problems/sort-linked-list-already-sorted-using-absolute-values/",
	difficulty = Difficulty.MEDIUM
)
public class SortLinkedListAlreadySortedUsingAbsoluteValues
{
	public ListNode sortLinkedList(ListNode head)
	{
		LinkedList<ListNode> list = new LinkedList<>();
		while (head != null)
		{
			if (head.val < 0)
			{
				list.addFirst(head);
			}
			else
			{
				list.addLast(head);
			}

			head = head.next;
		}

		ListNode dummy = new ListNode();
		ListNode current = dummy;
		while (!list.isEmpty())
		{
			current.next = list.removeFirst();
			current = current.next;
			current.next = null;
		}

		return dummy.next;
	}
}
