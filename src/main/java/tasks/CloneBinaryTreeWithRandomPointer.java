package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12/17/2020
 */
@LeetCode(
	id = 1485,
	name = "Clone Binary Tree With Random Pointer",
	url = "https://leetcode.com/problems/clone-binary-tree-with-random-pointer/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class CloneBinaryTreeWithRandomPointer
{
	public class Node
	{
		int val;
		Node left;
		Node right;
		Node random;

		Node(){}

		Node(int val){ this.val = val; }

		Node(int val, Node left, Node right, Node random)
		{
			this.val = val;
			this.left = left;
			this.right = right;
			this.random = random;
		}
	}

	public class NodeCopy extends Node
	{
		public NodeCopy(int val)
		{
			super(val);
		}
	}

	public NodeCopy copyRandomBinaryTree(Node root)
	{
		if (root == null)
		{
			return null;
		}

		Map<Node, NodeCopy> copies = new HashMap<>();
		dfs(root, copies);

		return copies.get(root);
	}

	private void dfs(Node root, Map<Node, NodeCopy> copies)
	{
		if (root == null)
		{
			return;
		}

		NodeCopy current = copies.get(root);
		if (current == null)
		{
			current = new NodeCopy(root.val);
			copies.put(root, current);
		}

		NodeCopy leftChild;
		if (root.left == null)
		{
			leftChild = null;
		}
		else
		{
			leftChild = copies.get(root.left);
			if (leftChild == null)
			{
				leftChild = new NodeCopy(root.left.val);
				copies.put(root.left, leftChild);
			}
		}

		NodeCopy rightChild;
		if (root.right == null)
		{
			rightChild = null;
		}
		else
		{
			rightChild = copies.get(root.right);
			if (rightChild == null)
			{
				rightChild = new NodeCopy(root.right.val);
				copies.put(root.right, rightChild);
			}
		}

		NodeCopy random;
		if (root.random == null)
		{
			random = null;
		}
		else
		{
			random = copies.get(root.random);
			if (random == null)
			{
				random = new NodeCopy(root.random.val);
				copies.put(root.random, random);
			}
		}

		current.left = leftChild;
		current.right = rightChild;
		current.random = random;

		dfs(root.left, copies);
		dfs(root.right, copies);
	}
}
