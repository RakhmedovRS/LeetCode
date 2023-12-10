package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 4/23/2021
 */
@LeetCode(
		id = 1836,
		name = "Remove Duplicates From an Unsorted Linked List",
		url = "https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class RemoveDuplicatesFromAnUnsortedLinkedList {
	public ListNode deleteDuplicatesUnsorted(ListNode head) {
		int[] seen = new int[100_001];
		ListNode temp = head;
		while (temp != null) {
			seen[temp.val]++;
			temp = temp.next;
		}

		ListNode dummy = new ListNode();
		ListNode prev = dummy;
		ListNode next;
		while (head != null) {
			next = head.next;

			if (seen[head.val] == 1) {
				prev.next = head;
				head.next = null;
				prev = prev.next;
			}

			head = next;
		}

		return dummy.next;
	}
}
