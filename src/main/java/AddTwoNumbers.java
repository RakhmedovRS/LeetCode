import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 01-Apr-20
 */
@LeetCode(id = 2, name = "Add Two Numbers", url = "https://leetcode.com/problems/add-two-numbers/")
public class AddTwoNumbers
{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		boolean hasRest = false;
		while (l1 != null || l2 != null || hasRest)
		{
			int l1Value = 0;
			if (l1 != null)
			{
				l1Value = l1.val;
				l1 = l1.next;
			}

			int l2Value = 0;
			if (l2 != null)
			{
				l2Value = l2.val;
				l2 = l2.next;
			}

			ListNode node = new ListNode(0);
			node.val += l1Value + l2Value;
			if (hasRest)
			{
				node.val += 1;
				hasRest = false;
			}

			if (node.val >= 10)
			{
				node.val %= 10;
				hasRest = true;
			}
			current.next = node;
			current = current.next;
		}

		return dummy.next;
	}
}
