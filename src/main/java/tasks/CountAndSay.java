package tasks;

import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 27-Mar-20
 */
@LeetCode(id = 38, name = "Count and Say", url = "https://leetcode.com/problems/count-and-say/")
public class CountAndSay
{
	public String countAndSay(int A)
	{
		if (A <= 0)
		{
			return "";
		}

		Deque<Integer> deque = new LinkedList<>();
		deque.add(1);
		int size;
		Integer value;
		int count;
		for (int i = 1; i < A; i++)
		{
			size = deque.size();
			value = deque.peekLast();
			count = 0;
			while (size-- > 0)
			{
				if (deque.getLast().equals(value))
				{
					count++;
					deque.removeLast();
				}
				else
				{
					deque.addFirst(value);
					deque.addFirst(count);
					value = deque.removeLast();
					count = 1;
				}
			}

			if (count != 0)
			{
				deque.addFirst(value);
				deque.addFirst(count);
			}
		}

		StringBuilder result = new StringBuilder(deque.size());
		for (Integer val : deque)
		{
			result.append(val);
		}

		return result.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(new CountAndSay().countAndSay(1));
		System.out.println(new CountAndSay().countAndSay(2));
		System.out.println(new CountAndSay().countAndSay(3));
		System.out.println(new CountAndSay().countAndSay(5));
		System.out.println(new CountAndSay().countAndSay(6));
		System.out.println(new CountAndSay().countAndSay(7));
	}
}
