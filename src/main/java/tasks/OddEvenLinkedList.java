package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 06-Apr-20
 */
@LeetCode(
		id = 328,
		name = "Odd Even Linked List",
		url = "https://leetcode.com/problems/odd-even-linked-list/",
		difficulty = Difficulty.MEDIUM
)
public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummyOdd = new ListNode(0);
		ListNode dummyEven = new ListNode(0);

		boolean isOdd = true;
		ListNode odd = dummyOdd;
		ListNode even = dummyEven;
		while (head != null) {
			if (isOdd) {
				odd.next = head;
				odd = odd.next;
				head = head.next;
				odd.next = null;
			}
			else {
				even.next = head;
				even = even.next;
				head = head.next;
				even.next = null;
			}

			isOdd = !isOdd;
		}

		odd.next = dummyEven.next;

		return dummyOdd.next;
	}
}
