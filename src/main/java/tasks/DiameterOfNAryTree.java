package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 29-Jan-21
 */
@LeetCode(
		id = 1522,
		name = "Diameter of N-Ary Tree",
		url = "https://leetcode.com/problems/diameter-of-n-ary-tree/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class DiameterOfNAryTree {
	class Node {
		public int val;
		public List<Node> children;

		public Node() {
			children = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			children = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	public int diameter(Node root) {
		int[] diameter = new int[]{0};
		diameter(root, diameter);
		return diameter[0];
	}

	public int diameter(Node root, int[] diameter) {
		if (root == null) {
			return -1;
		}

		if (root.children == null || root.children.isEmpty()) {
			return 1;
		}

		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;

		int result;
		for (Node child : root.children) {
			result = diameter(child, diameter);
			diameter[0] = Math.max(diameter[0], result);

			if (result > first) {
				second = first;
				first = result;
			}
			else if (result > second) {
				second = result;
			}
		}

		if (first != Integer.MIN_VALUE && second != Integer.MIN_VALUE) {
			diameter[0] = Math.max(diameter[0], first + second);
		}

		return Math.max(first, second) + 1;
	}
}
