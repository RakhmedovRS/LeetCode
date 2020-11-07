import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 11/7/2020
 */
@LeetCode(id = 445, name = "Add Two Numbers II", url = "https://leetcode.com/problems/add-two-numbers-ii/")
public class AddTwoNumbersII
{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		if (l1 == null)
		{
			return l2;
		}
		else if (l2 == null)
		{
			return l1;
		}

		ListNode h1 = reverse(l1);
		ListNode h2 = reverse(l2);

		ListNode dummy = new ListNode();
		ListNode prev = dummy;
		int rest = 0;
		int sum;
		while (h1 != null || h2 != null || rest > 0)
		{
			sum = rest;
			if (h1 != null)
			{
				sum += h1.val;
				h1 = h1.next;
			}

			if (h2 != null)
			{
				sum += h2.val;
				h2 = h2.next;
			}

			rest = sum / 10;

			prev.next = new ListNode(sum % 10);
			prev = prev.next;
		}

		return reverse(dummy.next);
	}

	private ListNode reverse(ListNode head)
	{
		ListNode prev = null;
		ListNode next;
		while (head != null)
		{
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}

		return prev;
	}

	public static void main(String[] args)
	{
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		System.out.println(new AddTwoNumbersII().addTwoNumbers(l1, l2));

	}
}
