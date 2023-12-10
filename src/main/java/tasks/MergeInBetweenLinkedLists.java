package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 11/28/2020
 */
@LeetCode(
		id = 1669,
		name = "Merge In Between Linked Lists",
		url = "https://leetcode.com/problems/merge-in-between-linked-lists/",
		difficulty = Difficulty.MEDIUM
)
public class MergeInBetweenLinkedLists {
	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
		ListNode tailList2 = list2;
		while (tailList2.next != null) {
			tailList2 = tailList2.next;
		}

		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = list1;

		ListNode prev = dummy;
		while (prev.next.val != a) {
			prev = prev.next;
		}

		ListNode cut = prev.next;
		prev.next = list2;

		while (cut.val != b) {
			cut = cut.next;
		}

		tailList2.next = cut.next;

		return dummy.next;
	}
}
