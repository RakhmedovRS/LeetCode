import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 04-Apr-20
 */
@LeetCode(id = 117, name = "Populating Next Right Pointers in Each Node II", url = "https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/")
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
		Node startLevel = root;
		while (startLevel != null)
		{
			Node current = startLevel;
			Node prev = null;
			Node nextStart = null;
			while (current != null)
			{
				if (nextStart == null)
				{
					nextStart = current.left == null ? current.right : current.left;
				}

				if (current.left != null)
				{
					if (prev != null)
					{
						prev.next = current.left;
					}
					prev = current.left;
				}

				if (current.right != null)
				{
					if (prev != null)
					{
						prev.next = current.right;
					}
					prev = current.right;
				}

				current = current.next;
			}

			startLevel = nextStart;
		}

		return root;
	}
}
