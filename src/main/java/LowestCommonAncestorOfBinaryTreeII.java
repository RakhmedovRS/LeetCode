import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 1/2/2021
 */
@LeetCode(
	id = 1644,
	name = "Lowest Common Ancestor of a Binary Tree II",
	url = "https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class LowestCommonAncestorOfBinaryTreeII
{
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
	{
		Map<TreeNode, TreeNode> parents = new HashMap<>();
		dfs(root, null, parents);

		Set<TreeNode> visited = new HashSet<>();
		while (p != null)
		{
			visited.add(p);
			p = parents.get(p);
		}

		while (q != null)
		{
			if (!visited.add(q))
			{
				return q;
			}

			q = parents.get(q);
		}

		return null;
	}

	private void dfs(TreeNode treeNode, TreeNode parent, Map<TreeNode, TreeNode> parents)
	{
		if (treeNode == null)
		{
			return;
		}

		parents.put(treeNode, parent);
		dfs(treeNode.left, treeNode, parents);
		dfs(treeNode.right, treeNode, parents);
	}
}
