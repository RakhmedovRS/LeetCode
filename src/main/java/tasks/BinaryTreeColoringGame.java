package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 10/20/2020
 */
@LeetCode(
		id = 1145,
		name = "Binary Tree Coloring Game",
		url = "https://leetcode.com/problems/binary-tree-coloring-game/",
		difficulty = Difficulty.MEDIUM
)
public class BinaryTreeColoringGame {
	public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
		Map<TreeNode, Integer> nodeCount = new HashMap<>();
		dfs(root, nodeCount, x);
		for (int count : nodeCount.values()) {
			if (count > n / 2) {
				return true;
			}
		}

		return false;
	}

	private int dfs(TreeNode root, Map<TreeNode, Integer> nodeCount, int x) {
		if (root == null) {
			return 0;
		}

		if (root.val == x) {
			dfs(root.left, nodeCount, x);
			dfs(root.right, nodeCount, x);
			return 0;
		}

		nodeCount.put(root, 1 + dfs(root.left, nodeCount, x) + dfs(root.right, nodeCount, x));
		return nodeCount.get(root);
	}
}
