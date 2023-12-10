package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 8/31/2021
 */
@LeetCode(
		id = 663,
		name = "Equal Tree Partition",
		url = "https://leetcode.com/problems/equal-tree-partition/",
		difficulty = Difficulty.MEDIUM
)
public class EqualTreePartition {
	public boolean checkEqualTree(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = getSum(root, map);
		if (sum == 0) {
			return map.getOrDefault(sum, 0) > 1;
		}
		return sum % 2 == 0 && map.containsKey(sum / 2);
	}

	public int getSum(TreeNode root, Map<Integer, Integer> map) {
		if (root == null) {
			return 0;
		}
		int cur = root.val + getSum(root.left, map) + getSum(root.right, map);
		map.put(cur, map.getOrDefault(cur, 0) + 1);
		return cur;
	}
}
