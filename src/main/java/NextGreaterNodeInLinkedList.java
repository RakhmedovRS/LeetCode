import common.LeetCode;
import common.ListNode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 11-May-20
 */
@LeetCode(id = 1019, name = "Next Greater Node In Linked List", url = "https://leetcode.com/problems/next-greater-node-in-linked-list/")
public class NextGreaterNodeInLinkedList
{
	public int[] nextLargerNodes(ListNode head)
	{
		List<Integer> values = new ArrayList<>();
		while (head != null)
		{
			values.add(head.val);
			head = head.next;
		}

		int[] answer = new int[values.size()];
		Deque<Integer> stack = new LinkedList<>();
		Map<Integer, Integer> nextGreater = new HashMap<>();
		for (int i = 0; i < values.size(); i++)
		{
			int val = values.get(i);
			while (!stack.isEmpty() && values.get(stack.peek()) < val)
			{
				nextGreater.put(stack.pop(), i);
			}
			stack.push(i);
		}

		for (int i = 0; i < values.size(); i++)
		{
			Integer index = nextGreater.get(i);
			if (index == null)
			{
				answer[i] = 0;
			}
			else
			{
				answer[i] = values.get(index);
			}
		}

		return answer;
	}

	public static void main(String[] args)
	{
		ListNode start = new ListNode(2);
		start.next = new ListNode(1);
		start.next.next = new ListNode(5);

		System.out.println(Arrays.toString(new NextGreaterNodeInLinkedList().nextLargerNodes(start)));
	}
}
