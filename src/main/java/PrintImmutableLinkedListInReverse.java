import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 12/4/2020
 */
@LeetCode(
	id = 1265,
	name = "Print Immutable Linked List in Reverse",
	url = "https://leetcode.com/problems/print-immutable-linked-list-in-reverse/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class PrintImmutableLinkedListInReverse
{
	interface ImmutableListNode
	{
		void printValue();

		ImmutableListNode getNext();
	}

	public void printLinkedListInReverse(ImmutableListNode head)
	{
		LinkedList<ImmutableListNode> nodes = new LinkedList<>();
		while (head != null)
		{
			nodes.add(head);
			head = head.getNext();
		}

		while (!nodes.isEmpty())
		{
			nodes.removeLast().printValue();
		}
	}
}
