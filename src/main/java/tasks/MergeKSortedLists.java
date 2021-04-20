package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 11-Feb-20
 */
@LeetCode(
	id = 23,
	name = "Merge k Sorted Lists",
	url = "https://leetcode.com/problems/merge-k-sorted-lists/",
	difficulty = Difficulty.HARD
)
public class MergeKSortedLists
{
	public ListNode mergeKLists(ListNode[] lists)
	{
		if (lists == null || lists.length == 0)
		{
			return null;
		}

		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(head -> head.val));
		for (ListNode node : lists)
		{
			if (node != null)
			{
				minHeap.add(node);
			}
		}

		ListNode current;
		ListNode next;
		while (!minHeap.isEmpty())
		{
			current = minHeap.remove();

			if (current == null)
			{
				continue;
			}

			next = current.next;
			current.next = null;
			prev.next = current;
			prev = current;
			if (next != null)
			{
				minHeap.add(next);
			}
		}

		return dummy.next;
	}
}
