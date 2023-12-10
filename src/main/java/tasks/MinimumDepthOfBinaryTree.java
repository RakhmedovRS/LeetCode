package tasks;

import common.LeetCode;
import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 10/22/2020
 */
@LeetCode(id = 111, name = "Minimum Depth of Binary Tree", url = "https://leetcode.com/problems/minimum-depth-of-binary-tree/")
public class MinimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);
		int size;
		int level = 1;
		TreeNode current;
		while (!nodes.isEmpty()) {
			size = nodes.size();
			while (size-- > 0) {
				current = nodes.remove();
				if (current.left == null && current.right == null) {
					return level;
				}

				if (current.left != null) {
					nodes.add(current.left);
				}

				if (current.right != null) {
					nodes.add(current.right);
				}
			}
			level++;
		}

		return level;
	}
}
