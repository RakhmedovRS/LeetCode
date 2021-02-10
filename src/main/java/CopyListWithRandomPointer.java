import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 14-Apr-20
 */
@LeetCode(
	id = 138,
	name = "Copy List with Random Pointer",
	url = "https://leetcode.com/problems/copy-list-with-random-pointer/",
	difficulty = Difficulty.MEDIUM
)
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
		Map<Node, Node> map = new HashMap<>();
		Node original = head;
		Node copy;
		Node random;
		Node next;
		while (original != null)
		{
			if (!map.containsKey(original))
			{
				map.put(original, new Node(original.val));
			}

			if (original.random != null && !map.containsKey(original.random))
			{
				map.put(original.random, new Node(original.random.val));
			}

			if (original.next != null && !map.containsKey(original.next))
			{
				map.put(original.next, new Node(original.next.val));
			}

			copy = map.get(original);
			random = map.get(original.random);
			next = map.get(original.next);

			copy.random = random;
			copy.next = next;

			original = original.next;
		}

		return map.get(head);
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
