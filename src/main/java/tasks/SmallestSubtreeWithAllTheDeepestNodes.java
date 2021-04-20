package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.*;

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
		if (root == null)
		{
			return null;
		}

		Map<TreeNode, TreeNode> parents = new HashMap<>();
		List<TreeNode> leaves = new ArrayList<>();
		int[] level = new int[]{-1};
		dfs(root, root, parents, leaves, 0, level);

		Queue<TreeNode> queue = new LinkedList<>(leaves);
		Set<TreeNode> seen = new HashSet<>();
		TreeNode current;
		TreeNode parent;
		int size;
		while (queue.size() != 1)
		{
			size = queue.size();
			while (size-- > 0)
			{
				current = queue.remove();
				parent = parents.get(current);
				if (seen.add(parent))
				{
					queue.add(parent);
				}
			}
		}

		return queue.peek();
	}

	private void dfs(TreeNode parent, TreeNode root, Map<TreeNode, TreeNode> parents, List<TreeNode> leaves, int current, int[] level)
	{
		if (root == null)
		{
			return;
		}

		if (current >= level[0])
		{
			if (current > level[0])
			{
				leaves.clear();
			}
			leaves.add(root);
			level[0] = current;
		}

		parents.put(root, parent);

		dfs(root, root.left, parents, leaves, current + 1, level);
		dfs(root, root.right, parents, leaves, current + 1, level);
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
