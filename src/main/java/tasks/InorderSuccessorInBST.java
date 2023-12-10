package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 1/13/2021
 */
@LeetCode(
		id = 285,
		name = "Inorder Successor in BST",
		url = "https://leetcode.com/problems/inorder-successor-in-bst/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class InorderSuccessorInBST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (p.right != null) {
			p = p.right;
			while (p.left != null) {
				p = p.left;
			}

			return p;
		}

		Map<TreeNode, TreeNode> parents = new HashMap<>();
		dfs(null, root, parents);

		TreeNode parent = parents.get(p);
		while (parent != null) {
			if (parent.val > p.val) {
				return parent;
			}

			parent = parents.get(parent);
		}

		return null;
	}

	private void dfs(TreeNode parent, TreeNode current, Map<TreeNode, TreeNode> parents) {
		if (current == null) {
			return;
		}

		parents.put(current, parent);
		dfs(current, current.left, parents);
		dfs(current, current.right, parents);
	}
}
