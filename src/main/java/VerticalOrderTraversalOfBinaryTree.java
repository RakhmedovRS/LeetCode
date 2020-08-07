import common.LeetCode;
import common.TreeNode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 03-Apr-20
 */
@LeetCode(id = 987, name = "Vertical Order Traversal of a Binary Tree", url = "https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/")
public class VerticalOrderTraversalOfBinaryTree
{
	public List<List<Integer>> verticalTraversal(TreeNode root)
	{
		int[] minMax = new int[]{0, 0, 0};
		Map<Integer, Map<Integer, List<Integer>>> mapMap = new HashMap<>();
		dfs(root, minMax, 0, 1, mapMap);

		List<List<Integer>> answer = new ArrayList<>();
		for (int pos = minMax[0]; pos <= minMax[1]; pos++)
		{
			List<Integer> column = new ArrayList<>();
			for (int level = 1; level <= minMax[2]; level++)
			{
				if (mapMap.containsKey(level) && mapMap.get(level).containsKey(pos))
				{
					mapMap.get(level).get(pos).sort(null);
					column.addAll(mapMap.get(level).get(pos));
				}
			}

			if (!column.isEmpty())
			{
				answer.add(column);
			}
		}

		return answer;
	}

	private void dfs(TreeNode root, int[] minMax, int pos, int level, Map<Integer, Map<Integer, List<Integer>>> mapMap)
	{
		if (root == null)
		{
			return;
		}

		minMax[0] = Math.min(minMax[0], pos);
		minMax[1] = Math.max(minMax[1], pos);
		minMax[2] = Math.max(minMax[2], level);

		mapMap.putIfAbsent(level, new HashMap<>());
		mapMap.get(level).putIfAbsent(pos, new ArrayList<>());
		mapMap.get(level).get(pos).add(root.val);

		dfs(root.left, minMax, pos - 1, level + 1, mapMap);
		dfs(root.right, minMax, pos + 1, level + 1, mapMap);
	}
}
