import common.LeetCode;
import common.Node;

/**
 * @author RakhmedovRS
 * @created 10-Jul-20
 */
@LeetCode(id = 480, name = "Flatten a Multilevel Doubly Linked List", url = "https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/")
public class FlattenMultilevelDoublyLinkedList
{
	public Node flatten(Node head)
	{
		return getHeadAndTail(head)[0];
	}

	private Node[] getHeadAndTail(Node node)
	{
		Node[] headAndTail = new Node[]{node, null};
		Node curr = node;
		while (curr != null)
		{
			if (curr.child != null)
			{
				Node next = curr.next;
				Node[] temp = getHeadAndTail(curr.child);
				curr.child = null;
				curr.next = temp[0];
				temp[0].prev = curr;

				temp[1].next = next;
				if (next != null)
				{
					next.prev = temp[1];
				}
				curr = next == null ? temp[1] : next;
			}

			if (curr.next == null)
			{
				headAndTail[1] = curr;
			}

			curr = curr.next;
		}

		return headAndTail;
	}
}
