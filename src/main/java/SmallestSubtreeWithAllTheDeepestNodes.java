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
	id = 865,
	name = "Smallest Subtree with all the Deepest Nodes",
	url = "https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/",
	difficulty = Difficulty.MEDIUM
)
public class SmallestSubtreeWithAllTheDeepestNodes
{
	public TreeNode subtreeWithAllDeepest(TreeNode root)
	{
		TreeNode[] parents = new TreeNode[501];
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

	public static void main(String[] args)
	{
		TreeNode treeNode = new TreeNode(0);
		treeNode.left = new TreeNode(1);
		treeNode.right = new TreeNode(3);

		treeNode.left.right = new TreeNode(2);

		System.out.println(new SmallestSubtreeWithAllTheDeepestNodes().subtreeWithAllDeepest(treeNode));

		System.out.println();

		treeNode = new TreeNode(3);
		treeNode.left = new TreeNode(5);
		treeNode.right = new TreeNode(1);

		treeNode.left.left = new TreeNode(6);
		treeNode.left.right = new TreeNode(2);

		treeNode.right.left = new TreeNode(0);
		treeNode.right.right = new TreeNode(8);

		treeNode.left.right.left = new TreeNode(7);
		treeNode.left.right.right = new TreeNode(4);

		System.out.println(new SmallestSubtreeWithAllTheDeepestNodes().subtreeWithAllDeepest(treeNode));
	}
}
