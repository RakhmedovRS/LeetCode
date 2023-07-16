package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 10/7/2020
 */
@LeetCode(
		id = 61,
		name = "Rotate List",
		url = "https://leetcode.com/problems/rotate-list/",
		difficulty = Difficulty.MEDIUM
)
public class RotateList
{
	public ListNode rotateRight(ListNode head, int k)
	{
		if (head == null || k == 0)
		{
			return head;
		}

		LinkedList<ListNode> list = new LinkedList<>();
		while (head != null)
		{
			list.addLast(head);
			head = head.next;
		}

		k %= list.size();
		while (k-- > 0)
		{
			list.addFirst(list.removeLast());
		}

		ListNode newHead = list.removeFirst();
		ListNode current = newHead;
		while (!list.isEmpty())
		{
			current.next = list.remove();
			current = current.next;
		}

		current.next = null;

		return newHead;
	}
}
