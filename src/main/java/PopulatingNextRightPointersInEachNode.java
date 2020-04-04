import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 04-Apr-20
 */
@LeetCode(id = 116, name = "Populating Next Right Pointers in Each Node", url = "https://leetcode.com/problems/populating-next-right-pointers-in-each-node/")
public class PopulatingNextRightPointersInEachNode
{
	static class Node
	{
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node(){}

		public Node(int _val)
		{
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next)
		{
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

	public Node connect(Node root)
	{
		Node startLevel = root;
		while (startLevel != null)
		{
			Node current = startLevel;
			while (current != null)
			{
				if (current.left != null)
				{
					current.left.next = current.right;
				}

				if (current.right != null && current.next != null)
				{
					current.right.next = current.next.left;
				}

				current = current.next;
			}

			startLevel = startLevel.left;
		}

		return root;
	}

	public Node connect1(Node root)
	{
		Deque<Node> level = new LinkedList<>();
		level.addLast(root);
		while (!level.isEmpty())
		{
			int levelSize = level.size();
			while (levelSize > 0)
			{
				Node node = level.removeFirst();
				if (node != null)
				{
					if (levelSize - 1 > 0)
					{
						node.next = level.getFirst();
					}

					level.addLast(node.left);
					level.addLast(node.right);
				}

				levelSize--;
			}
		}

		return root;
	}

	public static void main(String[] args)
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		new PopulatingNextRightPointersInEachNode().connect(root);
	}
}
