import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 15-Mar-20
 */
@LeetCode(id = 141, name = "Linked List Cycle", url = "https://leetcode.com/problems/linked-list-cycle/")
public class LinkedListCycle
{
	class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x)
		{
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head)
	{
		if(head == null || head.next == null || head.next.next == null)
		{
			return false;
		}

		ListNode fast = head.next.next;
		while (fast.next != null && fast.next.next != null)
		{
			if (fast == head)
			{
				return true;
			}
			head = head.next;
			fast = fast.next.next;
		}
		return false;
	}
}
