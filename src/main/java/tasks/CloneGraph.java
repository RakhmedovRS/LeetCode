package tasks;

import common.Difficulty;
import common.LeetCode;
import common.Node;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 26-Mar-20
 */
@LeetCode(
		id = 133,
		name = "Clone Graph",
		url = "https://leetcode.com/problems/clone-graph/",
		difficulty = Difficulty.MEDIUM
)
public class CloneGraph
{
	public Node cloneGraph(Node node)
	{
		if (node == null)
		{
			return null;
		}

		Map<Node, Node> nodes = createCopies(node);
		createEdges(node, nodes);
		return nodes.get(node);
	}

	private Map<Node, Node> createCopies(Node node)
	{
		Map<Node, Node> nodes = new HashMap<>();
		Set<Node> visited = new HashSet<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		Node current;
		while (!queue.isEmpty())
		{
			current = queue.remove();
			if (!visited.add(current))
			{
				continue;
			}

			Node newNode = new Node();
			newNode.val = current.val;
			nodes.put(current, newNode);
			queue.addAll(current.neighbors);
		}

		return nodes;
	}

	private void createEdges(Node node, Map<Node, Node> nodes)
	{
		Set<Node> visited = new HashSet<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		Node current;
		Node clone;
		while (!queue.isEmpty())
		{
			current = queue.remove();
			if (!visited.add(current))
			{
				continue;
			}

			clone = nodes.get(current);
			for (Node neighbor : current.neighbors)
			{
				clone.neighbors.add(nodes.get(neighbor));
			}

			queue.addAll(current.neighbors);
		}
	}
}
