package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Ruslan Rakhmedov
 * @created 12/2/2022
 */
@LeetCode(
		id = 2487,
		name = "Remove Nodes From Linked List",
		url = "https://leetcode.com/problems/remove-nodes-from-linked-list/",
		difficulty = Difficulty.MEDIUM
)
public class RemoveNodesFromLinkedList {
	public ListNode removeNodes(ListNode head) {
		List<Integer> list = new ArrayList<>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}

		TreeSet<Integer> set = new TreeSet<>();
		LinkedList<Integer> linkedList = new LinkedList<>();
		for (int i = list.size() - 1; i >= 0; i--) {
			if (set.isEmpty() || set.ceiling(list.get(i) + 1) == null) {
				linkedList.addFirst(list.get(i));
			}

			set.add(list.get(i));
		}

		ListNode dummy = new ListNode();
		ListNode newHead = dummy;
		while (!linkedList.isEmpty()) {
			newHead.next = new ListNode(linkedList.removeFirst());
			newHead = newHead.next;
		}

		return dummy.next;
	}
}
