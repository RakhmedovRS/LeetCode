package contest;

import common.ListNode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author RakhmedovRS
 * @created 9/27/2020
 */
public class Contest
{

	public ListNode mergeKLists(ListNode[] lists)
	{
		if (lists == null || lists.length == 0)
		{
			return null;
		}

		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(head -> head.val));
		for (ListNode node : lists)
		{
			if (node != null)
			{
				minHeap.add(node);
			}
		}

		ListNode current;
		ListNode next;
		while (!minHeap.isEmpty())
		{
			current = minHeap.remove();

			if(current == null)
			{
				continue;
			}

			next = current.next;
			current.next = null;
			prev.next = current;
			prev = current;
			if (next != null)
			{
				minHeap.add(next);
			}
		}

		return dummy.next;
	}

	public static void main(String[] args) throws Exception
	{
		Contest clazz = new Contest();
		System.out.println(clazz.mergeKLists(new ListNode[]{}));
	}

	private static String readBigTestCase() throws FileNotFoundException
	{
		return new BufferedReader(new FileReader(Thread.currentThread().getContextClassLoader().getResource("TestCase.txt").getFile())).lines().collect(Collectors.joining());
	}
}
