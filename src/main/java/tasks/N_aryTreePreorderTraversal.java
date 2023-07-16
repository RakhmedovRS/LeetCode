package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 10-Feb-20
 */
@LeetCode(
		id = 589,
		name = "N-ary Tree Preorder Traversal",
		url = "https://leetcode.com/problems/n-ary-tree-preorder-traversal/",
		difficulty = Difficulty.EASY
)
public class N_aryTreePreorderTraversal
{
	class Node
	{
		public int val;
		public List<Node> children;

		public Node()
		{
		}

		public Node(int val)
		{
			this.val = val;
		}

		public Node(int val, List<Node> children)
		{
			this.val = val;
			this.children = children;
		}
	}

	public List<Integer> preorder(Node root)
	{
		if (root == null)
		{
			return Collections.emptyList();
		}

		List<Integer> list = new ArrayList<>();
		list.add(root.val);
		for (Node child : root.children)
		{
			list.addAll(preorder(child));
		}

		return list;
	}
}
