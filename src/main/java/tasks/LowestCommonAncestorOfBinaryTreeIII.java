package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 1/2/2021
 */
@LeetCode(
		id = 1650,
		name = "Lowest Common Ancestor of a Binary Tree III",
		url = "https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class LowestCommonAncestorOfBinaryTreeIII {
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node parent;
	}

	public Node lowestCommonAncestor(Node p, Node q) {
		Set<Node> visited = new HashSet<>();
		while (p != null) {
			visited.add(p);
			p = p.parent;
		}

		while (q != null) {
			if (!visited.add(q)) {
				return q;
			}

			q = q.parent;
		}

		return null;
	}
}
