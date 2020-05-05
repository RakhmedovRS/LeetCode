import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 10-Feb-20
 */
@LeetCode(id = 589, name = "N-ary Tree Preorder Traversal", url = "https://leetcode.com/problems/n-ary-tree-preorder-traversal/")
public class N_aryTreePreorderTraversal
{
	class Node
	{
		public int val;
		public List<Node> children;

		public Node(){}

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

	public List<Integer> preorder(Node root) {
		List<Integer> result = new LinkedList<>();
		preorder(root, result);
		return result;
	}

	private void preorder(Node root, List<Integer> result)
	{
		if (root == null)
		{
			return;
		}

		Deque<Node> deque = new LinkedList<>();
		deque.addFirst(root);
		while (!deque.isEmpty())
		{
			Node node = deque.remove();
			if (node != null)
			{
				result.add(node.val);
				if (node.children != null)
				{
					for (int i = node.children.size() - 1; i >= 0; i--)
					{
						Node children = node.children.get(i);
						if (children != null)
						{
							deque.addFirst(children);
						}
					}
				}
			}
		}
	}
}
