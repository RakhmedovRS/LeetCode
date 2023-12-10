package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 10/31/2020
 */
@LeetCode(
		id = 99,
		name = "Recover Binary Search Tree",
		url = "https://leetcode.com/problems/recover-binary-search-tree/",
		difficulty = Difficulty.MEDIUM
)
public class RecoverBinarySearchTree {
	public void recoverTree(TreeNode root) {
		TreeNode firstWrong = null;
		TreeNode secondWrong = null;
		TreeNode prev = new TreeNode(Integer.MIN_VALUE);
		while (root != null) {
			TreeNode node = root.left;
			if (node != null) {
				while (node.right != null && node.right != root) {
					node = node.right;
				}

				if (node.right == null) {
					node.right = root;
					root = root.left;
					continue;
				}
				else {
					node.right = null;
				}
			}

			if (root.val < prev.val) {
				if (firstWrong == null) {
					firstWrong = prev;
				}

				secondWrong = root;
			}

			prev = root;
			root = root.right;
		}

		int temp = firstWrong.val;
		firstWrong.val = secondWrong.val;
		secondWrong.val = temp;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		new RecoverBinarySearchTree().recoverTree(root);

		System.out.println(new PrintBinaryTree().printTree(root));
	}
}
