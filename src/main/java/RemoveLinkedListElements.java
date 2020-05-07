import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 07-May-20
 */
@LeetCode(id = 203, name = "Remove Linked List Elements", url = "https://leetcode.com/problems/remove-linked-list-elements/")
public class RemoveLinkedListElements
{
	public ListNode removeElements(ListNode head, int val)
	{
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		while (head != null)
		{
			if (head.val != val)
			{
				current.next = head;
				current = current.next;
			}

			head = head.next;
		}
		current.next = null;

		return dummy.next;
	}
}
