package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 10/27/2020
 */
@LeetCode(
	id = 142,
	name = "Linked List Cycle II",
	url = "https://leetcode.com/problems/linked-list-cycle-ii/",
	difficulty = Difficulty.MEDIUM
)
public class LinkedListCycleII
{
	public ListNode detectCycle(ListNode head)
	{
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
			{
				slow = head;
				while (slow != fast)
				{
					slow = slow.next;
					fast = fast.next;
				}

				return slow;
			}
		}

		return null;
	}
}
