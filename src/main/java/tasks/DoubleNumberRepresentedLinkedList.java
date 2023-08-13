package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author Ruslan Rakhmedov
 * @created 8/12/2023
 */
@LeetCode(
		id = 2816,
		name = "Double a Number Represented as a Linked List",
		url = "https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description/",
		difficulty = Difficulty.MEDIUM
)
public class DoubleNumberRepresentedLinkedList
{
	public ListNode doubleIt(ListNode head)
	{
		StringBuilder sb = new StringBuilder();
		while (head != null)
		{
			sb.append(head.val);
			head = head.next;
		}


		sb = new StringBuilder(multiply(sb.toString(), "2"));
		ListNode dummy = new ListNode();
		ListNode current = dummy;
		for (char ch : sb.toString().toCharArray())
		{
			current.next = new ListNode(ch - '0');
			current = current.next;
		}

		return dummy.next;
	}

	public String multiply(String num1, String num2)
	{
		int[] result = new int[num1.length() + num2.length()];
		int res;
		int pos = 0;
		for (int a = num1.length() - 1; a >= 0; a--)
		{
			int innerPos = pos;
			for (int b = num2.length() - 1; b >= 0; b--)
			{
				res = (num1.charAt(a) - '0') * (num2.charAt(b) - '0');
				result[innerPos] += res % 10;
				result[innerPos + 1] += res / 10;
				innerPos++;
			}
			pos++;
		}

		for (int i = 0; i < result.length - 1; i++)
		{
			if (result[i] > 9)
			{
				result[i + 1] += result[i] / 10;
				result[i] %= 10;
			}
		}

		int i = result.length - 1;
		while (i > 0 && result[i] == 0)
		{
			i--;
		}

		StringBuilder stringBuilder = new StringBuilder(result.length - i);
		for (; i >= 0; i--)
		{
			stringBuilder.append(result[i]);
		}
		return stringBuilder.toString();
	}
}
