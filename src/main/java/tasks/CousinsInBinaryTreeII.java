package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 4/18/2023
 */
@LeetCode(
		id = 2641,
		name = "Cousins in Binary Tree II",
		url = "https://leetcode.com/problems/cousins-in-binary-tree-ii/",
		difficulty = Difficulty.MEDIUM
)
public class CousinsInBinaryTreeII {
	public TreeNode replaceValueInTree(TreeNode root) {
		Map<Integer, Integer> levels = new HashMap<>();
		Map<TreeNode, TreeNode> parents = new HashMap<>();
		TreeNode clone = cloneTree(root);
		dfs(0, null, clone, levels, parents);
		dfs2(0, root, clone, levels, parents);
		return root;
	}

	private void dfs2(int level, TreeNode root, TreeNode clone, Map<Integer, Integer> levels, Map<TreeNode, TreeNode> parents) {
		if (root == null) {
			return;
		}

		int levelSum = levels.getOrDefault(level, 0);
		TreeNode parent = parents.get(clone);
		if (parent == null) {
			levelSum -= clone.val;
		}
		else {
			if (parent.left != null) {
				levelSum -= parent.left.val;
			}

			if (parent.right != null) {
				levelSum -= parent.right.val;
			}
		}

		root.val = levelSum;

		dfs2(level + 1, root.left, clone.left, levels, parents);
		dfs2(level + 1, root.right, clone.right, levels, parents);
	}

	private TreeNode cloneTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode newNode = new TreeNode(root.val);
		newNode.left = cloneTree(root.left);
		newNode.right = cloneTree(root.right);
		return newNode;
	}

	private void dfs(int level, TreeNode prev, TreeNode root, Map<Integer, Integer> levels, Map<TreeNode, TreeNode> parents) {
		if (root == null) {
			return;
		}

		parents.put(root, prev);
		levels.put(level, levels.getOrDefault(level, 0) + root.val);
		dfs(level + 1, root, root.left, levels, parents);
		dfs(level + 1, root, root.right, levels, parents);
	}
}
