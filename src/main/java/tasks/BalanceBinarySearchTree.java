package tasks;

import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 17-Jul-20
 */
@LeetCode(id = 1382, name = "Balance a Binary Search Tree", url = "https://leetcode.com/problems/balance-a-binary-search-tree/")
public class BalanceBinarySearchTree {
	public TreeNode balanceBST(TreeNode root) {
		List<Integer> nodes = new ArrayList<>();
		inOrder(root, nodes);
		return rebuildTree(nodes, 0, nodes.size() - 1);
	}

	private TreeNode rebuildTree(List<Integer> nodes, int left, int right) {
		if (left == right) {
			return new TreeNode(nodes.get(left));
		}

		if (left > right) {
			return null;
		}

		int mid = (left + right) / 2;
		TreeNode node = new TreeNode(nodes.get(mid));
		node.left = rebuildTree(nodes, left, mid - 1);
		node.right = rebuildTree(nodes, mid + 1, right);
		return node;
	}

	private void inOrder(TreeNode treeNode, List<Integer> nodes) {
		if (treeNode == null) {
			return;
		}

		inOrder(treeNode.left, nodes);
		nodes.add(treeNode.val);
		inOrder(treeNode.right, nodes);
	}
}
