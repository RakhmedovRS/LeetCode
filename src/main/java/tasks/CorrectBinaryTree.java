package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12/30/2020
 */
@LeetCode(
		id = 1660,
		name = "Correct a Binary Tree",
		url = "https://leetcode.com/problems/correct-a-binary-tree/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class CorrectBinaryTree {
	public TreeNode correctBinaryTree(TreeNode root) {
		if (root == null || root.right == root) {
			return null;
		}

		Map<TreeNode, TreeNode> parents = new HashMap<>();
		dfs(root, null, parents);
		checkAndDeleteInvalidSubTree(root, parents);

		return root;
	}

	private void dfs(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parents) {
		if (root == null) {
			return;
		}

		parents.put(root, parent);
		dfs(root.left, root, parents);
		dfs(root.right, root, parents);
	}

	private void checkAndDeleteInvalidSubTree(TreeNode root, Map<TreeNode, TreeNode> parents) {
		if (root == null) {
			return;
		}

		if (root.right != null) {
			if (parents.get(root.right) != root) {
				if (parents.get(root).left == root) {
					parents.get(root).left = null;
				}
				else {
					parents.get(root).right = null;
				}
			}
		}

		checkAndDeleteInvalidSubTree(root.left, parents);
		checkAndDeleteInvalidSubTree(root.right, parents);
	}
}

