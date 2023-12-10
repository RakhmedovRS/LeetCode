package tasks;

import common.LeetCode;
import common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 09-Jul-20
 */
@LeetCode(id = 1171, name = "Remove Zero Sum Consecutive Nodes from Linked List", url = "https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/")
public class RemoveZeroSumConsecutiveNodesFromLinkedList {
	public ListNode removeZeroSumSublists(ListNode head) {
		if (head == null) {
			return null;
		}

		Map<Integer, ListNode> sumToNode = new HashMap<>();
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode current = dummy;
		int sum = 0;
		while (current != null) {
			sum += current.val;
			sumToNode.put(sum, current);
			current = current.next;
		}

		current = dummy;
		sum = 0;
		while (current != null) {
			sum += current.val;
			current.next = sumToNode.get(sum).next;
			current = current.next;
		}

		return dummy.next;
	}
}
