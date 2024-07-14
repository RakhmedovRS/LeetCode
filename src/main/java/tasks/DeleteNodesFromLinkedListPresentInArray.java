package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-07-13
 */
@LeetCode(
		id = 3217,
		name = "Delete Nodes From Linked List Present in Array",
		url = "https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/description/",
		difficulty = Difficulty.MEDIUM
)
public class DeleteNodesFromLinkedListPresentInArray {
	public ListNode modifiedList(int[] nums, ListNode head) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}

		ListNode dummy = new ListNode();
		ListNode current = dummy;
		while (head != null) {
			if (!set.contains(head.val)) {
				current.next = new ListNode(head.val);
				current = current.next;
			}
			head = head.next;
		}
		return dummy.next;
	}
}