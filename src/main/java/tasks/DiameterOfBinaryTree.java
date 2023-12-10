package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 11-Apr-20
 */
@LeetCode(
		id = 543,
		name = "Diameter of Binary Tree",
		url = "https://leetcode.com/problems/diameter-of-binary-tree/",
		difficulty = Difficulty.EASY
)
public class DiameterOfBinaryTree {
	public int diameterOfBinaryTree(TreeNode root) {
		int[] max = new int[]{0};
		diameterOfBinaryTree(root, max);
		return max[0];
	}

	int diameterOfBinaryTree(TreeNode root, int[] max) {
		if (root == null) {
			return -1;
		}

		int left = 1 + diameterOfBinaryTree(root.left, max);
		int right = 1 + diameterOfBinaryTree(root.right, max);
		int edges = left + right;
		if (edges > max[0]) {
			max[0] = edges;
		}
		return Math.max(left, right);
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);

		System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(treeNode));
	}
}
