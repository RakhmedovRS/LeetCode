package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-08-04
 */
@LeetCode(
		id = 3237,
		name = "Alt and Tab Simulation",
		url = "https://leetcode.com/problems/alt-and-tab-simulation/description/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class AltAndTabSimulation {
	class Node {
		Node prev;
		Node next;
		int val;

		public Node(int val) {
			this.val = val;
		}
	}

	public int[] simulationResult(int[] windows, int[] queries) {
		Node head = new Node(-1);
		Node tail = new Node(-1);
		Node prev = head;
		Map<Integer, Node> map = new HashMap<>();
		for (int window : windows) {
			Node node = new Node(window);
			map.put(window, node);
			prev.next = node;
			node.prev = prev;
			prev = node;
		}

		prev.next = tail;
		tail.prev = prev;

		for (int query : queries) {
			Node node = map.get(query);
			prev = node.prev;
			Node next = node.next;

			prev.next = next;
			next.prev = prev;

			next = head.next;

			head.next = node;
			node.prev = head;

			node.next = next;
			next.prev = node;
		}

		head = head.next;
		int pos = 0;
		int[] ans = new int[windows.length];
		while (head.val != -1) {
			ans[pos++] = head.val;
			head = head.next;
		}
		return ans;
	}
}