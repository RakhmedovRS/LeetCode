package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 14-Mar-20
 */
@LeetCode(
		id = 19,
		name = "Remove Nth Node From End of List",
		url = "https://leetcode.com/problems/remove-nth-node-from-end-of-list/",
		difficulty = Difficulty.MEDIUM
)
public class RemoveNthNodeFromEndOfList
{
	public ListNode removeNthFromEnd(ListNode head, int n)
	{
		List<ListNode> list = new ArrayList<>();
		list.add(new ListNode());
		list.get(0).next = head;

		while (head != null)
		{
			list.add(head);
			head = head.next;
		}

		list.get(list.size() - 1 - n).next = list.get(list.size() - n);

		return list.get(0).next;
	}

	public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 5);
	}
}
