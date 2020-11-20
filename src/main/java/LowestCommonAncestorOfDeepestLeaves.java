import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 11/20/2020
 */
@LeetCode(
	id = 1123,
	name = "Lowest Common Ancestor of Deepest Leaves",
	url = "https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/",
	difficulty = Difficulty.MEDIUM
)
public class LowestCommonAncestorOfDeepestLeaves
{
	public TreeNode lcaDeepestLeaves(TreeNode root)
	{
		TreeNode[] parents = new TreeNode[1001];
		int[] max = new int[1];
		LinkedList<TreeNode> deepestLeafs = new LinkedList<>();
		dfs(null, root, 0, parents, max, deepestLeafs);
		TreeNode node;
		while (deepestLeafs.size() > 1)
		{
			Set<TreeNode> p = new HashSet<>();
			while (!deepestLeafs.isEmpty())
			{
				node = deepestLeafs.removeFirst();
				p.add(parents[node.val]);
			}

			deepestLeafs.addAll(p);
		}

		return deepestLeafs.getFirst();
	}

	private void dfs(TreeNode prev, TreeNode node, int currentDepth, TreeNode[] parents, int[] max, List<TreeNode> deepestLeafs)
	{
		if (node == null)
		{
			return;
		}

		parents[node.val] = prev;

		if (node.left == null && node.right == null)
		{
			if (currentDepth > max[0])
			{
				max[0] = currentDepth;
				deepestLeafs.clear();
				deepestLeafs.add(node);
			}
			else if (currentDepth == max[0])
			{
				deepestLeafs.add(node);
			}
			return;
		}

		dfs(node, node.left, currentDepth + 1, parents, max, deepestLeafs);
		dfs(node, node.right, currentDepth + 1, parents, max, deepestLeafs);
	}
}
