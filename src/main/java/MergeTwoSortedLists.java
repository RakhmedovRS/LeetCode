import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 14-Mar-20
 */
@LeetCode(id = 21, name = "Merge Two Sorted Lists", url = "https://leetcode.com/problems/merge-two-sorted-lists/")
public class MergeTwoSortedLists
{
	public class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x){ val = x; }
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2)
	{
		if (l1 == null && l2 == null)
		{
			return null;
		}

		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		while (l1 != null && l2 != null)
		{
			if (l1.val > l2.val)
			{
				current.next = l2;
				l2 = l2.next;
			}
			else
			{
				current.next = l1;
				l1 = l1.next;
			}
			current = current.next;
		}

		while (l1 != null)
		{
			current.next = l1;
			l1 = l1.next;
			current = current.next;
		}

		while (l2 != null)
		{
			current.next = l2;
			l2 = l2.next;
			current = current.next;
		}

		return dummy.next;
	}
}
