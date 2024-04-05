package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-04-04
 */
@LeetCode(
		id = 3063,
		name = "Linked List Frequency",
		url = "https://leetcode.com/problems/linked-list-frequency/description/",
		difficulty = Difficulty.EASY,
		premium = true
)
public class LinkedListFrequency {
	public ListNode frequenciesOfElements(ListNode head) {
		int[] memo = new int[100_001];
		ListNode dummy = new ListNode();
		ListNode prev = dummy;
		while (head != null) {
			if (memo[head.val] == 0) {
				prev.next = new ListNode(head.val);
				prev = prev.next;
			}
			memo[head.val]++;
			head = head.next;
		}

		ListNode current = dummy;
		while (current != null) {
			current.val = memo[current.val];
			current = current.next;
		}
		return dummy.next;
	}
}