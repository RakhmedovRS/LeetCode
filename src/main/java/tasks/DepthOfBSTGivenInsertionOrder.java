package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author RakhmedovRS
 * @created 6/17/2021
 */
@LeetCode(
		id = 1902,
		name = "Depth of BST Given Insertion Order",
		url = "https://leetcode.com/problems/depth-of-bst-given-insertion-order/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class DepthOfBSTGivenInsertionOrder {
	public int maxDepthBST(int[] order) {
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		treeMap.put(order[0], 1);
		int max = 1;
		for (int i = 1; i < order.length; i++) {
			Map.Entry<Integer, Integer> left = treeMap.ceilingEntry(order[i]);
			Map.Entry<Integer, Integer> right = treeMap.floorEntry(order[i]);

			int depth = 1 + Math.max(left == null ? 0 : left.getValue(), right == null ? 0 : right.getValue());
			max = Math.max(max, depth);
			treeMap.put(order[i], depth);
		}

		return max;
	}
}
