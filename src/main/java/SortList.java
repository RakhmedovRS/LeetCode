import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 04-Mar-20
 */
@LeetCode(id = 148, name = "Sort List", url = "https://leetcode.com/problems/sort-list/")
public class SortList
{
	public class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x){ val = x; }
	}

	public ListNode sortList(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return head;
		}

		ListNode slow = head;
		ListNode fast = head.next.next;
		while (fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode right = slow.next;
		slow.next = null;

		ListNode first = sortList(head);
		ListNode second = sortList(right);
		return merge(first, second);
	}

	private ListNode merge(ListNode head1, ListNode head2)
	{
		ListNode dummy = new ListNode(1);
		ListNode prev = dummy;
		while (head1 != null && head2 != null)
		{
			if (head1.val > head2.val)
			{
				prev.next = head2;
				prev = head2;
				head2 = head2.next;
			}
			else
			{
				prev.next = head1;
				prev = head1;
				head1 = head1.next;
			}
		}

		while (head1 != null)
		{
			prev.next = head1;
			prev = head1;
			head1 = head1.next;
		}

		while (head2 != null)
		{
			prev.next = head2;
			prev = head2;
			head2 = head2.next;
		}

		return dummy.next;
	}
}
