import common.LeetCode;
import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 18-Sep-20
 */
@LeetCode(id = 817, name = "Linked List Components", url = "https://leetcode.com/problems/linked-list-components/")
public class LinkedListComponents
{
	public int numComponents(ListNode head, int[] G)
	{
		Set<Integer> set = new HashSet<>();
		for (int num : G)
		{
			set.add(num);
		}

		int pairs = 0;
		while (head != null)
		{
			if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val)))
			{
				pairs++;
			}
			head = head.next;
		}

		return pairs;
	}
}
