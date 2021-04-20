package tasks;

import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 13-Feb-20
 */
@LeetCode(id = 876, name = "Middle of the Linked List", url = "https://leetcode.com/problems/middle-of-the-linked-list/")
public class MiddleOfTheLinkedList
{
public ListNode middleNode(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return head;
		}

		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}
}
