package tasks;

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
		Node temp = head;
		while (temp != null)
		{
			map.put(temp, new Node(temp.val));
			temp = temp.next;
		}

		temp = head;
		Node dummy = new Node(0);
		Node prev = dummy;
		while (temp != null)
		{
			prev.next = map.get(temp);
			if (temp.random != null)
			{
				map.get(temp).random = map.get(temp.random);
			}
			prev = prev.next;
			temp = temp.next;
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
