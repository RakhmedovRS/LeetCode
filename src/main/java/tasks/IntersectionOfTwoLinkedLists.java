package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 07-Apr-20
 */
@LeetCode(
		id = 160,
		name = "Intersection of Two Linked Lists",
		url = "https://leetcode.com/problems/intersection-of-two-linked-lists/",
		difficulty = Difficulty.EASY
)
public class IntersectionOfTwoLinkedLists
{
	public ListNode getIntersectionNode(ListNode headA, ListNode headB)
	{
		if (headA == null || headB == null)
		{
			return null;
		}

		ListNode currentA = headA;
		ListNode currentB = headB;
		boolean currentAJumped = false;
		boolean currentBJumped = false;
		while (true)
		{
			if (currentA == currentB)
			{
				return currentA;
			}

			if (currentA.next == null)
			{
				if (currentAJumped)
				{
					break;
				}
				currentA = headB;
				currentAJumped = true;
			}
			else
			{
				currentA = currentA.next;
			}

			if (currentB.next == null)
			{
				if (currentBJumped)
				{
					break;
				}

				currentBJumped = true;
				currentB = headA;
			}
			else
			{
				currentB = currentB.next;
			}
		}

		return null;
	}
}
