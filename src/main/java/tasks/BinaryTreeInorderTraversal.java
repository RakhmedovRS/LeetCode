package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 01-Apr-20
 */
@LeetCode(
		id = 94,
		name = "Binary Tree Inorder Traversal",
		url = "https://leetcode.com/problems/binary-tree-inorder-traversal/",
		difficulty = Difficulty.EASY
)
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		Deque<TreeNode> deque = new LinkedList<>();
		deque.add(root);
		List<Integer> result = new ArrayList<>();

		while (!deque.isEmpty()) {
			TreeNode node = deque.removeFirst();
			if (node != null) {
				if (node.left == null) {
					result.add(node.val);
					deque.addFirst(node.right);
				}
				else {
					deque.addFirst(node);
					deque.addFirst(node.left);
					node.left = null;
				}
			}
		}

		return result;
	}

	public List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		inorder(root, result);
		return result;
	}

	private void inorder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}

		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);
	}
}
