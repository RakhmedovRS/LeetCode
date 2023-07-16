package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 4/14/2021
 */
@LeetCode(
		id = 86,
		name = "Partition List",
		url = "https://leetcode.com/problems/partition-list/",
		difficulty = Difficulty.MEDIUM
)
public class PartitionList
{
	public ListNode partition(ListNode head, int x)
	{
		ListNode lessHead = new ListNode();
		ListNode lessCurrent = lessHead;

		ListNode greaterHead = new ListNode();
		ListNode greaterCurrent = greaterHead;


		while (head != null)
		{
			if (head.val < x)
			{
				lessCurrent.next = head;
				head = head.next;
				lessCurrent = lessCurrent.next;
				lessCurrent.next = null;
			}
			else
			{
				greaterCurrent.next = head;
				head = head.next;
				greaterCurrent = greaterCurrent.next;
				greaterCurrent.next = null;
			}
		}

		lessCurrent.next = greaterHead.next;
		return lessHead.next;
	}
}
