package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 12/5/2021
 */
@LeetCode(
		id = 2095,
		name = "Delete the Middle Node of a Linked List",
		url = "https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/",
		difficulty = Difficulty.MEDIUM
)
public class DeleteTheMiddleNodeOfLinkedList
{
	public ListNode deleteMiddle(ListNode head)
	{
		LinkedList<ListNode> list = new LinkedList<>();
		while (head != null)
		{
			list.add(head);
			ListNode next = head.next;
			head.next = null;
			head = next;
		}

		ListNode dummy = new ListNode();
		ListNode current = dummy;
		list.remove(list.size() / 2);
		while (!list.isEmpty())
		{
			current.next = list.removeFirst();
			current = current.next;
		}

		return dummy.next;
	}
}
