package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 12/15/2020
 */
@LeetCode(
	id = 369,
	name = "Plus One Linked List",
	url = "https://leetcode.com/problems/plus-one-linked-list/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class PlusOneLinkedList
{
	public ListNode plusOne(ListNode head)
	{
		if (head == null)
		{
			return null;
		}

		ListNode tail = reverse(head);
		head = tail;
		boolean hasRest = true;
		ListNode prev = null;
		while (hasRest)
		{
			if (head == null)
			{
				prev.next = new ListNode(1);
				break;
			}

			if (head.val + 1 == 10)
			{
				head.val = 0;
			}
			else
			{
				head.val++;
				hasRest = false;
			}

			prev = head;
			head = head.next;
		}

		return reverse(tail);
	}

	private ListNode reverse(ListNode head)
	{
		ListNode prev = null;
		ListNode temp;
		while (head != null)
		{
			temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}

		return prev;
	}
}
