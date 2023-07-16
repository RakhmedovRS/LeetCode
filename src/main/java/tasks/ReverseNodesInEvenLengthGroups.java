package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 11/14/2021
 */
@LeetCode(
		id = 2074,
		name = "Reverse Nodes in Even Length Groups",
		url = "https://leetcode.com/problems/reverse-nodes-in-even-length-groups/",
		difficulty = Difficulty.MEDIUM
)
public class ReverseNodesInEvenLengthGroups
{
	public ListNode reverseEvenLengthGroups(ListNode head)
	{
		LinkedList<LinkedList<ListNode>> lists = new LinkedList<>();
		for (int i = 1; i < Integer.MAX_VALUE; i++)
		{
			if (head == null)
			{
				break;
			}

			LinkedList<ListNode> list = new LinkedList<>();
			for (int j = 0; j < i; j++)
			{
				if (head == null)
				{
					break;
				}
				list.addLast(head);
				head = head.next;
				list.getLast().next = null;
			}

			lists.addLast(list);
		}

		ListNode dummy = new ListNode();
		ListNode current = dummy;
		while (!lists.isEmpty())
		{
			LinkedList<ListNode> list = lists.removeFirst();
			boolean reverse = list.size() % 2 == 0;
			while (!list.isEmpty())
			{
				if (reverse)
				{
					current.next = list.removeLast();
				}
				else
				{
					current.next = list.removeFirst();
				}
				current = current.next;
			}
		}

		return dummy.next;
	}
}
