import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 19-Jul-20
 */
@LeetCode(id = 1519, name = "Number of Nodes in the Sub-Tree With the Same Label", url = "https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/")
public class NumberOfNodesInTheSubTreeWithTheSameLabel
{
	class Node
	{
		int index;
		char value;
		List<Node> child = new ArrayList<>();

		public Node(int index, char value)
		{
			this.index = index;
			this.value = value;
		}
	}

	public int[] countSubTrees(int n, int[][] edges, String labels)
	{
		int[] answer = new int[n];
		Map<Integer, Node> nodes = new HashMap<>();
		for (int[] edge : edges)
		{
			Node node = nodes.get(edge[0]);
			if (node == null)
			{
				node = new Node(edge[0], labels.charAt(edge[0]));
				nodes.put(edge[0], node);
			}

			Node child = nodes.get(edge[1]);
			if (child == null)
			{
				child = new Node(edge[1], labels.charAt(edge[1]));
				nodes.put(edge[1], child);
			}

			node.child.add(child);
			child.child.add(node);
		}

		dfs(nodes.get(0), answer, new HashSet<>());

		return answer;
	}

	private int[] dfs(Node node, int[] answer, Set<Integer> visited)
	{
		if (node == null || !visited.add(node.index))
		{
			return new int[0];
		}

		int[] memo = new int[26];
		memo[node.value - 'a']++;

		for (Node child : node.child)
		{
			int[] count = dfs(child, answer, visited);
			for (int i = 0; i < count.length; i++)
			{
				memo[i] += count[i];
			}
		}

		answer[node.index] = memo[node.value - 'a'];
		return memo;
	}

	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(new NumberOfNodesInTheSubTreeWithTheSameLabel().countSubTrees(4, new int[][]{
			{0, 2},
			{0, 3},
			{1, 2}
		}, "aeed")));

		System.out.println(Arrays.toString(new NumberOfNodesInTheSubTreeWithTheSameLabel().countSubTrees(7, new int[][]{
			{0, 1},
			{0, 2},
			{1, 4},
			{1, 5},
			{2, 3},
			{2, 6}
		}, "abaedcd")));

		System.out.println(Arrays.toString(new Contest().countSubTrees(5, new int[][]{
			{0, 1},
			{0, 2},
			{1, 3},
			{0, 4}}, "aabab")));
	}
}
