package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 6/23/2021
 */
@LeetCode(
		id = 92,
		name = "Reverse Linked List II",
		url = "https://leetcode.com/problems/reverse-linked-list-ii/",
		difficulty = Difficulty.MEDIUM
)
public class ReverseLinkedListII
{
	public ListNode reverseBetween(ListNode head, int left, int right)
	{
		if (head == null)
		{
			return null;
		}
		ListNode prev = null;
		ListNode current = head;
		while (left > 1)
		{
			prev = current;
			current = current.next;
			left--;
			right--;
		}

		ListNode conn = prev;
		ListNode tail = current;
		ListNode next;
		while (right > 0)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			right--;
		}

		if (conn != null)
		{
			conn.next = prev;
		}
		else
		{
			head = prev;
		}

		tail.next = current;
		return head;
	}
}
