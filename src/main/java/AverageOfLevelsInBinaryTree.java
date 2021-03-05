import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 19-Mar-20
 */
@LeetCode(
	id = 637,
	name = "Average of Levels in Binary Tree",
	url = "https://leetcode.com/problems/average-of-levels-in-binary-tree/",
	difficulty = Difficulty.EASY
)
public class AverageOfLevelsInBinaryTree
{
	public List<Double> averageOfLevels(TreeNode root)
	{
		List<Double> answer = new ArrayList<>();
		Map<Integer, long[]> map = new HashMap<>();
		dfs(0, root, map);

		long[] current;
		for (int i = 0; i < map.size(); i++)
		{
			current = map.get(i);
			answer.add((current[0] * 1d) / current[1]);
		}
		return answer;
	}

	private void dfs(int level, TreeNode node, Map<Integer, long[]> map)
	{
		if (node == null)
		{
			return;
		}

		long[] arr = map.getOrDefault(level, new long[2]);
		arr[0] += node.val;
		arr[1]++;

		map.put(level, arr);

		dfs(level + 1, node.left, map);
		dfs(level + 1, node.right, map);
	}
}
