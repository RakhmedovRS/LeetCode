package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 3/17/2021
 */
@LeetCode(
		id = 545,
		name = "Boundary of Binary Tree",
		url = "https://leetcode.com/problems/boundary-of-binary-tree/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class BoundaryOfBinaryTree {
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> answer = new ArrayList<>();
		if (root == null) {
			return answer;
		}

		if (!isLeaf(root)) {
			answer.add(root.val);
		}

		TreeNode current = root.left;
		while (current != null && !isLeaf(current)) {
			answer.add(current.val);
			current = current.left == null ? current.right : current.left;
		}

		dfs(root, answer);

		LinkedList<Integer> list = new LinkedList<>();

		current = root.right;
		while (current != null && !isLeaf(current)) {
			list.addFirst(current.val);
			current = current.right == null ? current.left : current.right;
		}

		while (!list.isEmpty()) {
			answer.add(list.removeFirst());
		}

		return answer;
	}

	private boolean isLeaf(TreeNode treeNode) {
		return treeNode.left == null && treeNode.right == null;
	}

	private void dfs(TreeNode treeNode, List<Integer> list) {
		if (treeNode == null) {
			return;
		}

		if (isLeaf(treeNode)) {
			list.add(treeNode.val);
		}
		else {
			dfs(treeNode.left, list);
			dfs(treeNode.right, list);
		}
	}
}
