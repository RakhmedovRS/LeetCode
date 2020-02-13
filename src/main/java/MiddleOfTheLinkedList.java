/**
 * Middle of the Linked List
 * LeetCode 876
 *
 * @author RakhmedovRS
 * @created 13-Feb-20
 */
public class MiddleOfTheLinkedList
{
	public class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x){ val = x; }
	}

	public ListNode middleNode(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return head;
		}

		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}
}
