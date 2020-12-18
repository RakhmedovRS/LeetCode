import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 12/18/2020
 */
@LeetCode(
	id = 1273,
	name = "Delete Tree Nodes",
	url = "https://leetcode.com/problems/delete-tree-nodes/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class DeleteTreeNodes
{
	class Node
	{
		int value;
		List<Node> children;

		public Node(int value)
		{
			this.value = value;
			this.children = new ArrayList<>();
		}
	}

	public int deleteTreeNodes(int nodes, int[] parent, int[] value)
	{
		Node[] nodeArray = new Node[parent.length];
		for (int i = 0; i < parent.length; i++)
		{
			nodeArray[i] = new Node(value[i]);
		}

		for (int i = 0; i < parent.length; i++)
		{
			if (parent[i] != -1)
			{
				nodeArray[parent[i]].children.add(nodeArray[i]);
			}
		}

		if (clearTree(nodeArray[0]) == 0)
		{
			nodeArray[0] = null;
		}

		return countNodes(nodeArray[0]);
	}

	private int clearTree(Node node)
	{
		if (node == null)
		{
			return 0;
		}

		int sum = node.value;
		int temp;
		for (int i = 0; i < node.children.size(); i++)
		{
			temp = clearTree(node.children.get(i));
			if (temp == 0)
			{
				node.children.set(i, null);
			}
			else
			{
				sum += temp;
			}
		}

		return sum;
	}

	private int countNodes(Node node)
	{
		if (node == null)
		{
			return 0;
		}

		int count = 0;
		for (Node next : node.children)
		{
			count += countNodes(next);
		}

		return count + 1;
	}

	public static void main(String[] args)
	{
		System.out.println(new DeleteTreeNodes().deleteTreeNodes(7, new int[]{-1, 6, 6, 5, 6, 0, 0}, new int[]{1, -1, -1, 0, -2, -2, 4}));
		System.out.println(new DeleteTreeNodes().deleteTreeNodes(7, new int[]{-1, 0, 0, 1, 2, 2, 2}, new int[]{1, -2, 4, 0, -2, -1, -1}));
	}
}
