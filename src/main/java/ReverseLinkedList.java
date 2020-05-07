import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 14-Mar-20
 */
@LeetCode(id = 206, name = "Reverse Linked List", url ="https://leetcode.com/problems/reverse-linked-list/")
public class ReverseLinkedList
{
	public ListNode reverseList(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return head;
		}

		ListNode prev = null;
		ListNode next = head.next;
		while (next != null)
		{
			head.next = prev;
			prev = head;
			head = next;
			next = next.next;
		}

		head.next = prev;

		return head;
	}

	public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		new ReverseLinkedList().reverseList(head);
	}
}
