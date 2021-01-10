import common.Difficulty;
import common.LeetCode;
import common.ListNode;

import java.util.ArrayList;
import java.util.List;

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
		List<ListNode> list = new ArrayList<>();
		ListNode next;
		while (head != null)
		{
			next = head.next;
			list.add(head);
			head.next = null;
			head = next;
		}

		if (k - 1 != list.size() - k)
		{
			ListNode temp1 = list.get(k - 1);
			ListNode temp2 = list.get(list.size() - k);

			list.set(k - 1, temp2);
			list.set(list.size() - k, temp1);
		}

		for (int i = 1; i < list.size(); i++)
		{
			list.get(i - 1).next = list.get(i);
		}

		return list.get(0);
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
