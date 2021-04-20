package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 1/10/2021
 */
@LeetCode(
	id = 1721,
	name = "Swapping Nodes in a Linked List",
	url = "https://leetcode.com/problems/swapping-nodes-in-a-linked-list/",
	difficulty = Difficulty.MEDIUM
)
public class SwappingNodesInLinkedList
{
	public ListNode swapNodes(ListNode head, int k)
	{
		ListNode originalHead = head;
		ListNode nodeA = head;
		for (int i = 1; i < k; i++)
		{
			head = head.next;
			nodeA = head;
		}

		ListNode reversedHead = reverse(originalHead);
		head = reversedHead;
		ListNode nodeB = head;
		for (int i = 1; i < k; i++)
		{
			head = head.next;
			nodeB = head;
		}

		int temp = nodeA.val;
		nodeA.val = nodeB.val;
		nodeB.val = temp;

		return reverse(reversedHead);
	}

	private ListNode reverse(ListNode head)
	{
		ListNode prev = null;
		ListNode next;
		while (head != null)
		{
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}

		return prev;
	}

	public static void main(String[] args)
	{
		SwappingNodesInLinkedList clazz = new SwappingNodesInLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.println(clazz.swapNodes(head, 2));

		head = new ListNode(1);
		System.out.println(clazz.swapNodes(head, 1));

		head = new ListNode(1);
		head.next = new ListNode(2);
		System.out.println(clazz.swapNodes(head, 1));

		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		System.out.println(clazz.swapNodes(head, 2));
	}
}
