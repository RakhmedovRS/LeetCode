import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 04-Apr-20
 */
@LeetCode(
	id = 117, 
	name = "Populating Next Right Pointers in Each Node II", 
	url = "https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/",
	difficulty = Difficulty.MEDIUM
)
public class PopulatingNextRightPointersInEachNodeII
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
		if (root == null)
		{
			return null;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Node prev = null;
		Node curr;
		int size;
		while (!queue.isEmpty())
		{
			size = queue.size();
			while (size-- > 0)
			{
				curr = queue.remove();
				if (prev != null)
				{
					prev.next = curr;
				}

				if (curr.left != null)
				{
					queue.add(curr.left);
				}

				if (curr.right != null)
				{
					queue.add(curr.right);
				}

				prev = curr;
			}
			prev = null;
		}

		return root;
	}
}
