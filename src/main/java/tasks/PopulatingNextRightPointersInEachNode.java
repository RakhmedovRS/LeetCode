package tasks;

import common.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 04-Apr-20
 */
@LeetCode(id = 116, name = "Populating Next Right Pointers in Each Node", url = "https://leetcode.com/problems/populating-next-right-pointers-in-each-node/")
public class PopulatingNextRightPointersInEachNode {
	static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

	public Node connect(Node root) {
		if (root == null) {
			return null;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int size;
		Node current;
		while (!queue.isEmpty()) {
			size = queue.size();
			while (size-- > 0) {
				current = queue.remove();
				if (size > 0) {
					current.next = queue.peek();
				}

				if (current.left != null) {
					queue.add(current.left);
				}

				if (current.right != null) {
					queue.add(current.right);
				}
			}
		}

		return root;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		new PopulatingNextRightPointersInEachNode().connect(root);
	}
}
