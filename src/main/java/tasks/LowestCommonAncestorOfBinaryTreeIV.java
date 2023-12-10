package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 1/6/2021
 */
@LeetCode(
		id = 1676,
		name = "Lowest Common Ancestor of a Binary Tree IV",
		url = "https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iv/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class LowestCommonAncestorOfBinaryTreeIV {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
		Set<TreeNode> set = new HashSet<>(Arrays.asList(nodes));
		TreeNode[] answer = new TreeNode[1];
		lca(root, set, answer);
		return answer[0];
	}

	private int lca(TreeNode node, Set<TreeNode> set, TreeNode[] answer) {
		if (node == null) {
			return 0;
		}

		int left = lca(node.left, set, answer);
		int right = lca(node.right, set, answer);
		if (set.contains(node)) {
			if (left + right + 1 == set.size() && answer[0] == null) {
				answer[0] = node;
			}

			return left + right + 1;
		}
		else {
			if (left + right == set.size() && answer[0] == null) {
				answer[0] = node;
			}

			return left + right;
		}
	}
}
