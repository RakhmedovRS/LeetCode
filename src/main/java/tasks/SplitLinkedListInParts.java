package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 22-Apr-20
 */
@LeetCode(
	id = 725,
	name = "Split Linked List in Parts",
	url = "https://leetcode.com/problems/split-linked-list-in-parts/",
	difficulty = Difficulty.MEDIUM
)
public class SplitLinkedListInParts
{
	public ListNode[] splitListToParts(ListNode head, int k)
	{
		LinkedList<ListNode> nodes = new LinkedList<>();
		while (head != null)
		{
			nodes.addLast(head);
			head = head.next;
		}

		int parts = nodes.size() / k;
		int rest = nodes.size() % k;

		ListNode[] asnwer = new ListNode[k];
		for (int pos = 0; pos < asnwer.length; pos++)
		{
			ListNode dummy = new ListNode();
			ListNode prev = dummy;
			for (int i = 0; i < parts; i++)
			{
				prev.next = nodes.removeFirst();
				prev = prev.next;
				prev.next = null;
			}

			if (rest > 0)
			{
				prev.next = nodes.removeFirst();
				prev = prev.next;
				prev.next = null;
				rest--;
			}

			asnwer[pos] = dummy.next;
		}

		return asnwer;
	}

	public static void main(String[] args)
	{
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);
		root.next.next.next.next.next = new ListNode(6);
		root.next.next.next.next.next.next = new ListNode(7);
		root.next.next.next.next.next.next.next = new ListNode(8);

		ListNode[] nodes = new SplitLinkedListInParts().splitListToParts(root, 7);
	}
}
