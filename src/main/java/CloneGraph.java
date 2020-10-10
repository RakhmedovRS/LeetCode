import common.LeetCode;
import common.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 26-Mar-20
 */
@LeetCode(id = 133, name = "Clone Graph", url = "https://leetcode.com/problems/clone-graph/")
public class CloneGraph
{
	public Node cloneGraph(Node node)
	{
		Map<Node, Node> map = new HashMap<>();
		return cloneGraph(node, map);
	}

	private Node cloneGraph(Node node, Map<Node, Node> map)
	{
		if (node == null)
		{
			return null;
		}

		if (map.containsKey(node))
		{
			return map.get(node);
		}

		Node copy = new Node(node.val);
		map.put(node, copy);
		for (Node neighbor : node.neighbors)
		{
			copy.neighbors.add(cloneGraph(neighbor, map));
		}

		return copy;
	}
}
