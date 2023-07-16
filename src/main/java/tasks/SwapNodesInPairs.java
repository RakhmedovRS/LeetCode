package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 10-Apr-20
 */
@LeetCode(
		id = 24,
		name = "Swap Nodes in Pairs",
		url = "https://leetcode.com/problems/swap-nodes-in-pairs/",
		difficulty = Difficulty.MEDIUM
)
public class SwapNodesInPairs
{
	public ListNode swapPairs(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return head;
		}

		ListNode next = head.next;
		ListNode nextNext = head.next.next;

		head.next = swapPairs(nextNext);
		next.next = head;
		return next;
	}

	public static void main(String[] args)
	{
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		new SwapNodesInPairs().swapPairs(root);
	}
}
