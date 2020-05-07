import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 10-Apr-20
 */
@LeetCode(id = 24, name = "Swap Nodes in Pairs", url = "https://leetcode.com/problems/swap-nodes-in-pairs/")
public class SwapNodesInPairs
{
	public ListNode swapPairs(ListNode head)
	{
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode current = dummy;
		while (current.next != null && current.next.next != null)
		{
			ListNode first = current.next;
			ListNode second = current.next.next;
			first.next = second.next;
			current.next = second;
			current.next.next = first;
			current = current.next.next;
		}
		return dummy.next;
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
