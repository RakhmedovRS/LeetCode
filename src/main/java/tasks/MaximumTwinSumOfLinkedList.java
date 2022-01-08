package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 1/8/2022
 */
@LeetCode(
	id = 2030,
	name = "Maximum Twin Sum of a Linked List",
	url = "https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/",
	difficulty = Difficulty.MEDIUM
)
public class MaximumTwinSumOfLinkedList
{
	public int pairSum(ListNode head)
	{
		List<Integer> list = new ArrayList<>();
		while (head != null)
		{
			list.add(head.val);
			head = head.next;
		}

		int max = 0;
		for (int i = 0; i < list.size() / 2; i++)
		{
			max = Math.max(max, list.get(i) + list.get(list.size() - 1 - i));
		}

		return max;
	}
}
