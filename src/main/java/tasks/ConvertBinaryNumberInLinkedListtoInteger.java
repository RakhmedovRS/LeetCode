package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 11/1/2020
 */
@LeetCode(
		id = 1290,
		name = "Convert Binary Number in a Linked List to Integer",
		url = "https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/",
		difficulty = Difficulty.EASY
)
public class ConvertBinaryNumberInLinkedListtoInteger {
	public int getDecimalValue(ListNode head) {
		StringBuilder sb = new StringBuilder();
		while (head != null) {
			sb.append(head.val);
			head = head.next;
		}

		return Integer.parseInt(sb.toString(), 2);
	}
}
