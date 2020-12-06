import common.Difficulty;
import common.LeetCode;


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
		Node prev;
		Node curr;
		Node next = root;
		while (next != null)
		{
			prev = null;
			curr = next;
			next = null;
			while (curr != null)
			{
				if (next == null)
				{
					next = curr.left == null ? curr.right : curr.left;
				}

				if (curr.left != null)
				{
					if (prev != null)
					{
						prev.next = curr.left;
					}

					prev = curr.left;
				}

				if (curr.right != null)
				{
					if (prev != null)
					{
						prev.next = curr.right;
					}

					prev = curr.right;
				}

				curr = curr.next;
			}
		}

		return root;
	}
}
