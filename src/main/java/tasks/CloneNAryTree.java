package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12/4/2020
 */
@LeetCode(
		id = 1490,
		name = "Clone N-ary Tree",
		url = "https://leetcode.com/problems/clone-n-ary-tree/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class CloneNAryTree {
	class Node {
		public int val;
		public List<Node> children;

		public Node() {
			children = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			children = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	public Node cloneTree(Node root) {
		Map<Node, Node> nodeMap = new HashMap<>();
		dfs(root, nodeMap);
		return nodeMap.get(root);
	}

	private void dfs(Node root, Map<Node, Node> nodeMap) {
		if (root == null) {
			return;
		}
		Node node = new Node();
		node.val = root.val;

		for (Node child : root.children) {
			dfs(child, nodeMap);
			node.children.add(nodeMap.get(child));
		}

		nodeMap.put(root, node);
	}
}
