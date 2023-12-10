package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 1/8/2021
 */
@LeetCode(
		id = 25,
		name = "Reverse Nodes in k-Group",
		url = "https://leetcode.com/problems/reverse-nodes-in-k-group/",
		difficulty = Difficulty.HARD
)
public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode();
		ListNode current = dummy;
		int i = 0;
		while (head != null) {
			current.next = head;
			current = current.next;
			head = head.next;
			if (++i == k) {
				current.next = null;
				ListNode h = dummy.next;
				dummy.next = reverse(dummy.next);
				h.next = reverseKGroup(head, k);
				break;
			}
		}

		return dummy.next;
	}

	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode next;
		while (head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}

		return prev;
	}

	public static void main(String[] args) {
		ReverseNodesInKGroup clazz = new ReverseNodesInKGroup();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		System.out.println(clazz.reverseKGroup(head, 3));

		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.println(clazz.reverseKGroup(head, 2));
	}
}
