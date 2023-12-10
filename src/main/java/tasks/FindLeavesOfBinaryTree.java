package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 12/10/2020
 */
@LeetCode(
		id = 366,
		name = "Find Leaves of Binary Tree",
		url = "https://leetcode.com/problems/find-leaves-of-binary-tree/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class FindLeavesOfBinaryTree {
	public List<List<Integer>> findLeaves(TreeNode root) {
		Map<Integer, List<Integer>> layers = new HashMap<>();
		dfs(root, layers);

		LinkedList<List<Integer>> answer = new LinkedList<>();
		for (int i = 0; layers.containsKey(i); i++) {
			answer.add(layers.get(i));
		}

		return answer;
	}

	private int dfs(TreeNode root, Map<Integer, List<Integer>> layers) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			layers.putIfAbsent(0, new ArrayList<>());
			layers.get(0).add(root.val);
			return 0;
		}

		int left = dfs(root.left, layers);
		int right = dfs(root.right, layers);
		int layer = Math.max(left, right) + 1;

		layers.putIfAbsent(layer, new ArrayList<>());
		layers.get(layer).add(root.val);
		return layer;
	}
}
