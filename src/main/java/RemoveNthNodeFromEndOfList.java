/**
 * @author RakhmedovRS
 * @created 14-Mar-20
 */
@LeetCode(id = 19, name = "Remove Nth Node From End of List", url = "https://leetcode.com/problems/remove-nth-node-from-end-of-list/")
public class RemoveNthNodeFromEndOfList
{
	public static class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x){ val = x; }
	}

	public ListNode removeNthFromEnd(ListNode head, int n)
	{
		ListNode dummy = new ListNode(0);
		ListNode dummy2 = new ListNode(0);
		dummy.next = dummy2;
		dummy2.next = head;

		ListNode current = dummy2;
		while (n > 0)
		{
			current = current.next;
			n--;
		}

		ListNode newCurrent = dummy2;
		ListNode prev = dummy;
		while (current != null)
		{
			prev = newCurrent;
			newCurrent = newCurrent.next;
			current = current.next;
		}

		prev.next = newCurrent.next;

		return dummy2.next;
	}

	public static void main(String[] args)
	{
		RemoveNthNodeFromEndOfList.ListNode head = new RemoveNthNodeFromEndOfList.ListNode(1);
		head.next = new RemoveNthNodeFromEndOfList.ListNode(2);
		head.next.next = new RemoveNthNodeFromEndOfList.ListNode(3);
		head.next.next.next = new RemoveNthNodeFromEndOfList.ListNode(4);
		head.next.next.next.next = new RemoveNthNodeFromEndOfList.ListNode(5);

		new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 5);
	}
}
