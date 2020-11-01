import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 11/1/2020
 */
@LeetCode(id = 1290, name = "Convert Binary Number in a Linked List to Integer", url = "https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/")
public class ConvertBinaryNumberInLinkedListtoInteger
{
	public int getDecimalValue(ListNode head)
	{
		int number = 0;
		while (head != null)
		{
			number = (number << 1);
			number ^= head.val;
			head = head.next;
		}

		return number;
	}
}
