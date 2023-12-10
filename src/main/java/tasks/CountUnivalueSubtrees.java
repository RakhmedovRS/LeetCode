package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 12/14/2020
 */
@LeetCode(
		id = 250,
		name = "Count Univalue Subtrees",
		url = "https://leetcode.com/problems/count-univalue-subtrees/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class CountUnivalueSubtrees {
	public int countUnivalSubtrees(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Map<TreeNode, TreeNode> parents = new HashMap<>();
		List<TreeNode> leaves = new ArrayList<>();
		dfs(null, root, parents, leaves);

		int count = leaves.size();
		LinkedList<TreeNode> queue = new LinkedList<>(leaves);
		Set<TreeNode> visited = new HashSet<>();
		TreeNode parent;
		TreeNode current;

		while (!queue.isEmpty()) {
			current = queue.remove();
			parent = parents.get(current);
			if (parent != null && parent.val == current.val) {
				if (parent.left == null || parent.right == null) {
					count++;
					queue.add(parent);
				}
				else if (!visited.add(parent)) {
					count++;
					queue.add(parent);
				}
			}
		}

		return count;
	}

	private void dfs(TreeNode parent, TreeNode current, Map<TreeNode, TreeNode> parents, List<TreeNode> leaves) {
		if (current == null) {
			return;
		}

		parents.put(current, parent);

		if (current.left == null && current.right == null) {
			leaves.add(current);
			return;
		}

		dfs(current, current.left, parents, leaves);
		dfs(current, current.right, parents, leaves);
	}
}
