package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 14-Mar-20
 */
@LeetCode(
		id = 206,
		name = "Reverse Linked List",
		url = "https://leetcode.com/problems/reverse-linked-list/",
		difficulty = Difficulty.EASY
)
public class ReverseLinkedList
{
	public ListNode reverseList(ListNode head)
	{
		ListNode prev = null;
		ListNode next = head;
		while (next != null)
		{
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}

		return prev;
	}

	public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		new ReverseLinkedList().reverseList(head);
	}
}
