package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 1/8/2021
 */
@LeetCode(
	id = 25,
	name = "Reverse Nodes in k-Group",
	url = "https://leetcode.com/problems/reverse-nodes-in-k-group/",
	difficulty = Difficulty.HARD
)
public class ReverseNodesInKGroup
{
	public ListNode reverseKGroup(ListNode head, int k)
	{
		ListNode dummy = new ListNode();
		ListNode prevPrev;
		ListNode prev = dummy;
		ListNode next;
		int nodeCount = nodeCount(head);
		while (nodeCount >= k)
		{
			prevPrev = prev;
			prev = head;
			for (int i = 0; i < k - 1; i++)
			{
				head = head.next;
			}

			next = head == null ? null : head.next;
			if (head != null)
			{
				head.next = null;
			}

			prevPrev.next = reverse(prev);

			if (head != null)
			{
				prev.next = next;
				head = next;
			}

			nodeCount -= k;
		}

		return dummy.next;
	}

	private int nodeCount(ListNode head)
	{
		int count = 0;
		while (head != null)
		{
			head = head.next;
			count++;
		}

		return count;
	}

	private ListNode reverse(ListNode head)
	{
		ListNode prev = null;
		ListNode next;
		while (head != null)
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
		ReverseNodesInKGroup clazz = new ReverseNodesInKGroup();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		System.out.println(clazz.reverseKGroup(head, 3));

		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.println(clazz.reverseKGroup(head, 2));
	}
}
