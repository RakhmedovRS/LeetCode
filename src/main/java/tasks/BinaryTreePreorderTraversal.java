package tasks;

import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 12-Apr-20
 */
@LeetCode(id = 144, name = "Binary Tree Preorder Traversal", url = "https://leetcode.com/problems/binary-tree-preorder-traversal/")
public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		Deque<TreeNode> stack = new LinkedList<>();
		stack.addFirst(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.removeFirst();
			result.add(node.val);
			if (node.right != null) {
				stack.addFirst(node.right);
			}

			if (node.left != null) {
				stack.addFirst(node.left);
			}
		}

		return result;
	}
}
