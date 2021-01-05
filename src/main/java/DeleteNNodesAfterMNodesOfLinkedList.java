import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 1/5/2021
 */
@LeetCode(
	id = 1474,
	name = "Delete N Nodes After M Nodes of a Linked List",
	url = "https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class DeleteNNodesAfterMNodesOfLinkedList
{
	public ListNode deleteNodes(ListNode head, int m, int n)
	{
		if (head == null)
		{
			return null;
		}

		ListNode temp = head;
		int counter = 1;
		while (temp != null && counter < m)
		{
			temp = temp.next;
			counter++;
		}

		ListNode prev = temp;
		if (prev == null)
		{
			return head;
		}

		counter = 0;
		while (temp != null && counter <= n)
		{
			temp = temp.next;
			counter++;
		}

		prev.next = deleteNodes(temp, m, n);

		return head;
	}

	public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		ListNode prev = head;
		for (int i = 2; i <= 7; i++)
		{
			prev.next = new ListNode(i);
			prev = prev.next;
		}

		DeleteNNodesAfterMNodesOfLinkedList clazz = new DeleteNNodesAfterMNodesOfLinkedList();
		System.out.println(head);
		System.out.println(clazz.deleteNodes(head, 2,1));
	}
}
