import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 14-Apr-20
 */
@LeetCode(id = 138, name = "Copy List with Random Pointer", url = "https://leetcode.com/problems/copy-list-with-random-pointer/")
public class CopyListWithRandomPointer
{
	static class Node
	{
		int val;
		Node next;
		Node random;

		public Node(int val)
		{
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head)
	{
		if (head == null)
		{
			return null;
		}

		Node current = head;
		Map<Node, Node> original = new HashMap<>();
		while (current != null)
		{
			original.put(current, current.random);
			current = current.next;
		}

		Node dummy = new Node(0);
		Map<Node, Node> copied = new HashMap<>();
		Node prev = dummy;
		current = head;
		while (current != null)
		{
			Node newN = new Node(current.val);
			copied.put(current, newN);
			prev.next = newN;
			prev = prev.next;
			current = current.next;
		}

		current = head;
		while (current != null)
		{
			Node newN = copied.get(current);
			newN.random = copied.get(current.random);

			current = current.next;
		}

		return dummy.next;
	}

	public static void main(String[] args)
	{
		Node node7 = new Node(7);
		Node node13 = new Node(13);
		Node node11 = new Node(11);
		Node node10 = new Node(10);
		Node node1 = new Node(1);
		node7.next = node13;
		node13.next = node11;
		node11.next = node10;
		node10.next = node1;

		node13.random = node7;
		node11.random = node1;
		node10.random = node11;
		node1.random = node7;

		new CopyListWithRandomPointer().copyRandomList(node7);
	}
}
