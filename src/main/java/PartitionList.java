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
		ListNode dummyOne = new ListNode();
		ListNode dummyTwo = new ListNode();

		ListNode lessCurrent = dummyOne;
		ListNode greaterCurrent = dummyTwo;
		ListNode next;

		while (head != null)
		{
			next = head.next;

			if (head.val < x)
			{
				lessCurrent.next = head;
				lessCurrent = lessCurrent.next;
			}
			else
			{
				greaterCurrent.next = head;
				greaterCurrent = greaterCurrent.next;
			}

			head.next = null;
			head = next;
		}

		if (dummyOne.next == null)
		{
			return dummyTwo.next;
		}

		lessCurrent.next = dummyTwo.next;

		return dummyOne.next;
	}
}
