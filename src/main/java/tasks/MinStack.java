package tasks;

import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 26-Mar-20
 */
@LeetCode(id = 155, name = "Min Stack", url = "https://leetcode.com/problems/min-stack/")
public class MinStack
{
	private LinkedList<Integer> values;
	private LinkedList<Integer> min;

	public MinStack()
	{
		values = new LinkedList<>();
		min = new LinkedList<>();
	}

	public void push(int x)
	{
		if (min.isEmpty() || x <= min.getFirst())
		{
			min.addFirst(x);
		}
		values.addFirst(x);
	}

	public void pop()
	{
		if (!values.isEmpty())
		{
			int x = values.removeFirst();
			if (min.getFirst() == x)
			{
				min.removeFirst();
			}
		}
	}

	public int top()
	{
		return values.isEmpty() ? -1 : values.getFirst();
	}

	public int getMin()
	{
		return min.isEmpty() ? -1 : min.getFirst();
	}
}
