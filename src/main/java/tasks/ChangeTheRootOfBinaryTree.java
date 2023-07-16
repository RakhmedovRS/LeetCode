package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 02-Feb-21
 */
@LeetCode(
		id = 1666,
		name = "Change the Root of a Binary Tree",
		url = "https://leetcode.com/problems/change-the-root-of-a-binary-tree/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class ChangeTheRootOfBinaryTree
{
	class Node
	{
		public int val;
		public Node left;
		public Node right;
		public Node parent;

		public Node(int val)
		{
			this.val = val;
		}
	}

	public Node flipBinaryTree(Node root, Node leaf)
	{
		dfs(leaf, null);
		return leaf;
	}

	private void dfs(Node node, Node prev)
	{
		if (node.parent == null)
		{
			if (prev == node.left)
			{
				node.left = null;
			}
			else
			{
				node.right = null;
			}

			node.parent = prev;
			return;
		}

		if (prev == node.right)
		{
			node.right = node.left;
		}

		Node next = node.parent;
		node.left = node.parent;
		node.parent = prev;
		dfs(next, node);
	}

	public static void main(String[] args)
	{
		ChangeTheRootOfBinaryTree clazz = new ChangeTheRootOfBinaryTree();

		Node root = clazz.new Node(3);

		root.left = clazz.new Node(5);
		root.left.parent = root;

		root.right = clazz.new Node(1);
		root.right.parent = root;

		root.left.left = clazz.new Node(6);
		root.left.left.parent = root.left;

		root.left.right = clazz.new Node(2);
		root.left.right.parent = root.left;

		root.left.right.left = clazz.new Node(7);
		root.left.right.left.parent = root.left.right;

		root.left.right.right = clazz.new Node(4);
		root.left.right.right.parent = root.left.right;

		root.right.left = clazz.new Node(0);
		root.right.left.parent = root.right;

		root.right.right = clazz.new Node(8);
		root.right.right.parent = root.right;

		clazz.flipBinaryTree(root, root.left.right.left);
	}
}
