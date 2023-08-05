package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author Ruslan Rakhmedov
 * @created 8/5/2023
 */
@LeetCode(
		id = 2807,
		name = "Insert Greatest Common Divisors in Linked List",
		url = "https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/",
		difficulty = Difficulty.MEDIUM
)
public class InsertGreatestCommonDivisorsInLinkedList
{
	public ListNode insertGreatestCommonDivisors(ListNode head)
	{
		ListNode dummy = new ListNode();
		ListNode current = dummy;
		while (head != null)
		{
			if (current.val != 0)
			{
				current.next = new ListNode(gcd(current.val, head.val));
				current = current.next;
			}
			current.next = head;

			head = head.next;
			current = current.next;
		}

		return dummy.next;
	}

	public static int gcd(int a, int b)
	{
		return a == 0 ? b : gcd(b % a, a);
	}
}
