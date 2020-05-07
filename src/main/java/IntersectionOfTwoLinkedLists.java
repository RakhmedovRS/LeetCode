import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 07-Apr-20
 */
@LeetCode(id = 160, name = "Intersection of Two Linked Lists", url = "https://leetcode.com/problems/intersection-of-two-linked-lists/")
public class IntersectionOfTwoLinkedLists
{
	public ListNode getIntersectionNode(ListNode headA, ListNode headB)
	{
		if (headA == null || headB == null)
		{
			return null;
		}

		ListNode first = headA;
		ListNode second = headB;
		boolean headASwiched = false;
		boolean headBSwiched = false;
		while (headA != null && headB != null)
		{
			if (headA == headB)
			{
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
			if (headA == null && !headASwiched)
			{
				headA = second;
				headASwiched = true;
			}
			if (headB == null && !headBSwiched)
			{
				headB = first;
				headBSwiched = true;
			}
		}
		return null;
	}
}
