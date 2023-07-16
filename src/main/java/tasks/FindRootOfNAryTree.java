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
		id = 1506,
		name = "Find Root of N-Ary Tree",
		url = "https://leetcode.com/problems/find-root-of-n-ary-tree/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class FindRootOfNAryTree
{
	class Node
	{
		public int val;
		public List<Node> children;

		public Node()
		{
			children = new ArrayList<Node>();
		}

		public Node(int _val)
		{
			val = _val;
			children = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _children)
		{
			val = _val;
			children = _children;
		}
	}

	public Node findRoot(List<Node> tree)
	{
		boolean[] children = new boolean[5 * (int) Math.pow(10, 4) + 1];
		for (Node node : tree)
		{
			for (Node child : node.children)
			{
				children[child.val] = true;
			}
		}

		for (Node node : tree)
		{
			if (!children[node.val])
			{
				return node;
			}
		}

		return null;
	}
}
