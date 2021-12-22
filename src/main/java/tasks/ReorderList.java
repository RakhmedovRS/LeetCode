package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 20-Aug-20
 */
@LeetCode(
	id = 143,
	name = "Reorder List",
	url = "https://leetcode.com/problems/reorder-list/",
	difficulty = Difficulty.MEDIUM
)
public class ReorderList
{
	public void reorderList(ListNode head)
	{
		int nodesCount = 0;
		ListNode temp = head;
		while (temp != null)
		{
			nodesCount++;
			temp = temp.next;
		}

		int half = nodesCount % 2 == 0 ? nodesCount / 2 : nodesCount / 2 + 1;
		ListNode leftPart = new ListNode();
		ListNode rightPart = new ListNode();
		ListNode left = leftPart;
		ListNode right = rightPart;
		nodesCount = 0;
		while (head != null)
		{
			temp = head.next;
			if (nodesCount < half)
			{
				left.next = head;
				left = left.next;
				left.next = null;
			}
			else
			{
				right.next = head;
				right = right.next;
				right.next = null;
			}

			nodesCount++;
			head = temp;
		}

		ListNode prev = null;
		ListNode oldHead = leftPart.next;
		ListNode newHead = rightPart.next;
		while (newHead != null)
		{
			temp = newHead.next;
			newHead.next = prev;
			prev = newHead;
			newHead = temp;
		}
		newHead = prev;
		prev = null;
		while (oldHead != null)
		{
			temp = oldHead.next;
			if (prev != null)
			{
				prev.next = oldHead;
			}
			prev = oldHead;
			oldHead = temp;
			prev.next = null;
			if (newHead != null)
			{
				temp = newHead.next;
				prev.next = newHead;
				prev = newHead;
				newHead = temp;
				prev.next = null;
			}
		}
	}
}
