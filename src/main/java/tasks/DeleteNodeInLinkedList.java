package tasks;

import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 13-Mar-20
 */
@LeetCode(id = 237, name = "Delete Node in a Linked List", url = "https://leetcode.com/problems/delete-node-in-a-linked-list/")
public class DeleteNodeInLinkedList {
	public void deleteNode(ListNode node) {
		if (node.next == null) {
			return;
		}

		ListNode prev = node;
		while (node.next != null) {
			node.val = node.next.val;

			prev = node;
			node = node.next;
		}
		prev.next = null;
	}
}
