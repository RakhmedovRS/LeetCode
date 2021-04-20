package tasks;

import common.LeetCode;
import common.TreeBuilder;
import common.TreeNode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 26-Jul-20
 */
@LeetCode(id = 1530, name = "Number of Good Leaf Nodes Pairs", url = "https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/")
public class NumberOfGoodLeafNodesPairs
{
	public int countPairs(TreeNode root, int distance)
	{
		Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);
		List<TreeNode> leaves = new ArrayList<>();
		while (!nodeQueue.isEmpty())
		{
			TreeNode node = nodeQueue.remove();
			if (node.left == null && node.right == null)
			{
				leaves.add(node);
			}
			else
			{
				List<TreeNode> outcome = graph.getOrDefault(node, new ArrayList<>());
				if (node.left != null)
				{
					outcome.add(node.left);
					nodeQueue.add(node.left);
					List<TreeNode> income = new ArrayList<>();
					income.add(node);
					graph.put(node.left, income);
				}
				if (node.right != null)
				{
					outcome.add(node.right);
					nodeQueue.add(node.right);
					List<TreeNode> income = new ArrayList<>();
					income.add(node);
					graph.put(node.right, income);
				}

				graph.put(node, outcome);
			}
		}

		int count = 0;
		Set<TreeNode> visited;
		Queue<TreeNode> queue;
		int k;
		int size;
		for (TreeNode leaf : leaves)
		{
			queue = new LinkedList<>(graph.getOrDefault(leaf, Collections.emptyList()));
			visited = new HashSet<>();
			visited.add(leaf);
			k = distance - 1;
			while (!queue.isEmpty() && k >= 0)
			{
				size = queue.size();
				while (size-- > 0)
				{
					TreeNode current = queue.remove();
					if (!visited.add(current))
					{
						continue;
					}

					if (current.left == null && current.right == null && current != leaf)
					{
						count++;
						continue;
					}

					queue.addAll(graph.getOrDefault(current, Collections.emptyList()));
				}
				k--;
			}
		}

		return count / 2;
	}

	public static void main(String[] args)
	{
		System.out.println(new NumberOfGoodLeafNodesPairs().countPairs(new TreeBuilder().deserializeBinaryTree("100"), 1));
		System.out.println(new NumberOfGoodLeafNodesPairs().countPairs(new TreeBuilder().deserializeBinaryTree("1,2,3,null,4"), 3));
		System.out.println(new NumberOfGoodLeafNodesPairs().countPairs(new TreeBuilder().deserializeBinaryTree("11,99,88,77,null,null,66,55,null,null,44,33,null,null,22"), 4));
	}
}
