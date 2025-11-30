package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-28
 */
@LeetCode(
        id = 3294,
        name = "Convert Doubly Linked List to Array II",
        url = "https://leetcode.com/problems/convert-doubly-linked-list-to-array-ii/description/",
        difficulty = Difficulty.MEDIUM,
        premium = true
)
public class ConvertDoublyLinkedListToArrayII {
    class Node {
        public int val;
        public Node prev;
        public Node next;
    }

    public int[] toArray(Node node) {
        while (node.prev != null) {
            node = node.prev;
        }

        Node head = node;
        int elements = 0;
        while (head != null) {
            elements++;
            head = head.next;
        }

        int pos = 0;
        int[] ans = new int[elements];
        while (node != null) {
            ans[pos++] = node.val;
            node = node.next;
        }

        return ans;
    }
}