package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12-Aug-20
 */
@LeetCode(
		id = 968,
		name = "Binary Tree Cameras",
		url = "https://leetcode.com/problems/binary-tree-cameras/",
		difficulty = Difficulty.HARD
)
public class BinaryTreeCameras {
	public int minCameraCover(TreeNode root) {
		if (root == null) {
			return 0;
		}
		else if (root.left == null && root.right == null) {
			return 1;
		}

		Map<TreeNode, Integer[]> memo = new HashMap<>();

		return Math.min(dfs(root, 0, memo), 1 + dfs(root, 2, memo));
	}

	// 0 - uncovered, 1 - covered, 2 - camera
	private int dfs(TreeNode root, int state, Map<TreeNode, Integer[]> memo) {
		if (root == null) {
			return 0;
		}

		if (memo.containsKey(root) && memo.get(root)[state] != null) {
			return memo.get(root)[state];
		}

		memo.putIfAbsent(root, new Integer[3]);

		int result;

		//uncovered
		if (state == 0) {
			int camera = 1 + dfs(root.left, 1, memo) + dfs(root.right, 1, memo);
			int leftCamera = root.left == null ? Integer.MAX_VALUE : 1 + dfs(root.left, 2, memo) + dfs(root.right, 0, memo);
			int rightCamera = root.right == null ? Integer.MAX_VALUE : 1 + dfs(root.right, 2, memo) + dfs(root.left, 0, memo);
			result = Math.min(camera, Math.min(leftCamera, rightCamera));
		}
		//covered
		else if (state == 1) {
			result = Math.min(1 + dfs(root.left, 1, memo) + dfs(root.right, 1, memo),
					dfs(root.left, 0, memo) + dfs(root.right, 0, memo));
		}
		//camera
		else {
			result = dfs(root.left, 1, memo) + dfs(root.right, 1, memo);
		}

		memo.get(root)[state] = result;

		return result;
	}
}
