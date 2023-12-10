package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 01-Apr-20
 */
@LeetCode(
		id = 2,
		name = "Add Two Numbers",
		url = "https://leetcode.com/problems/add-two-numbers/",
		difficulty = Difficulty.MEDIUM
)
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		int reminder = 0;
		int result;
		while (l1 != null || l2 != null || reminder > 0) {
			result = 0;
			if (l1 != null) {
				result += l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				result += l2.val;
				l2 = l2.next;
			}

			result += reminder;
			prev.next = new ListNode(result % 10);
			reminder = result / 10;
			prev = prev.next;
		}

		return dummy.next;
	}
}
