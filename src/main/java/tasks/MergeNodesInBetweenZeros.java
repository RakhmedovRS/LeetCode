package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 2/20/2022
 */
@LeetCode(
		id = 2181,
		name = "Merge Nodes in Between Zeros",
		url = "https://leetcode.com/problems/merge-nodes-in-between-zeros/",
		difficulty = Difficulty.MEDIUM
)
public class MergeNodesInBetweenZeros {
	public ListNode mergeNodes(ListNode head) {
		ListNode dummy = new ListNode();
		int sum = 0;
		ListNode current = dummy;
		boolean seenZero = false;
		while (head != null) {
			if (head.val == 0) {
				if (seenZero) {
					current.next = new ListNode(sum);
					current = current.next;
					sum = 0;
				}
				else {
					seenZero = true;
				}
			}

			if (seenZero) {
				sum += head.val;
			}

			head = head.next;
		}

		return dummy.next;
	}
}
