package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 1/5/2021
 */
@LeetCode(
		id = 82,
		name = "Remove Duplicates from Sorted List II",
		url = "https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/",
		difficulty = Difficulty.MEDIUM
)
public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode();
		int[] keep = new int[601];
		ListNode temp = head;
		while (temp != null) {
			keep[temp.val + 300]++;
			temp = temp.next;
		}

		temp = dummy;
		ListNode next;
		while (head != null) {
			next = head.next;
			if (keep[head.val + 300] == 1) {
				temp.next = head;
				temp = temp.next;
				temp.next = null;
			}

			head = next;
		}

		return dummy.next;
	}
}
