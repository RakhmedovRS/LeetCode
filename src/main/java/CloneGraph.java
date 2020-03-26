import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 26-Mar-20
 */
@LeetCode(id = 133, name = "Clone Graph", url = "https://leetcode.com/problems/clone-graph/")
public class CloneGraph
{
	class Node
	{
		public int val;
		public List<Node> neighbors;

		public Node()
		{
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val)
		{
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors)
		{
			val = _val;
			neighbors = _neighbors;
		}
	}

	public Node cloneGraph(Node node)
	{
		if (node == null)
		{
			return null;
		}

		Map<Node, Node> visited = new HashMap<>();

		return cloneGraph(node, visited);
	}

	public Node cloneGraph(Node node, Map<Node, Node> visited)
	{
		if (node == null)
		{
			return null;
		}

		Node newNode = visited.get(node);
		if (newNode != null)
		{
			return newNode;
		}

		newNode = new Node(node.val);
		visited.put(node, newNode);

		for (Node neighbor : node.neighbors)
		{
			newNode.neighbors.add(cloneGraph(neighbor, visited));
		}

		return newNode;
	}
}
