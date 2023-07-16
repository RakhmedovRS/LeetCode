package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 04-Feb-21
 */
@LeetCode(
		id = 708,
		name = "Insert into a Sorted Circular Linked List",
		url = "https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class InsertIntoSortedCircularLinkedList
{
	class Node
	{
		public int val;
		public Node next;

		public Node()
		{
		}

		public Node(int _val)
		{
			val = _val;
		}

		public Node(int _val, Node _next)
		{
			val = _val;
			next = _next;
		}
	}

	public Node insert(Node head, int insertVal)
	{
		Node node = new Node(insertVal);
		if (head == null)
		{
			node.next = node;
			return node;
		}

		Node current;
		Node maxNode;
		if (head == head.next)
		{
			current = head;
			maxNode = head;
		}
		else
		{
			Node[] minMaxNodes = findMinMaxNodes(head);
			current = minMaxNodes[0];
			maxNode = minMaxNodes[1];
		}

		if (insertVal < current.val || insertVal > maxNode.val)
		{
			maxNode.next = node;
			node.next = current;
		}
		else
		{
			while (true)
			{
				if (current.val <= insertVal && insertVal <= current.next.val)
				{
					Node next = current.next;

					current.next = node;
					node.next = next;
					break;
				}

				current = current.next;
			}
		}

		return head;
	}

	private Node[] findMinMaxNodes(Node node)
	{
		Node prev = node;
		Node curr = node.next;
		Set<Node> seen = new HashSet<>();
		while (prev.val <= curr.val && seen.add(curr))
		{
			prev = curr;
			curr = curr.next;
		}

		return new Node[]{curr, prev};
	}

	public static void main(String[] args)
	{
		InsertIntoSortedCircularLinkedList clazz = new InsertIntoSortedCircularLinkedList();

		Node head = clazz.new Node(1);
		head.next = clazz.new Node(3);
		head.next.next = clazz.new Node(3);
		head.next.next.next = head;

		clazz.insert(head, 4);
	}
}
