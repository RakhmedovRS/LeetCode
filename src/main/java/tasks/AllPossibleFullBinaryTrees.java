package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 15-Jun-20
 */
@LeetCode(
		id = 894,
		name = "All Possible Full Binary Trees",
		url = "https://leetcode.com/problems/all-possible-full-binary-trees/",
		difficulty = Difficulty.MEDIUM
)
public class AllPossibleFullBinaryTrees
{
	private Map<Integer, List<TreeNode>> cache = new HashMap<>();

	public List<TreeNode> allPossibleFBT(int N)
	{
		if (N % 2 == 0)
		{
			return Collections.emptyList();
		}

		if (N == 1)
		{
			return Arrays.asList(new TreeNode(0));
		}

		if (cache.containsKey(N))
		{
			return cache.get(N);
		}

		List<TreeNode> result = new ArrayList<>();
		for (int i = 1; i < N; i += 2)
		{
			List<TreeNode> leftNodes = allPossibleFBT(i);
			List<TreeNode> rightNodes = allPossibleFBT(N - i - 1);

			for (TreeNode left : leftNodes)
			{
				for (TreeNode right : rightNodes)
				{
					TreeNode node = new TreeNode(0, left, right);
					result.add(node);
				}
			}
		}

		cache.put(N, result);
		return result;
	}
}
