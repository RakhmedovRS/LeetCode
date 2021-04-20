package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @author RakhmedovRS
 * @created 12/3/2020
 */
@LeetCode(
	id = 716,
	name = "Max Stack",
	url = "https://leetcode.com/problems/max-stack/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class MaxStack
{
	LinkedList<Integer> stack;
	TreeMap<Integer, Integer> treeMap;

	public MaxStack()
	{
		stack = new LinkedList<>();
		treeMap = new TreeMap<>(Comparator.reverseOrder());
	}

	public void push(int x)
	{
		stack.addFirst(x);
		treeMap.put(x, treeMap.getOrDefault(x, 0) + 1);
	}

	public int pop()
	{
		int top = stack.removeFirst();
		int count = treeMap.remove(top);
		if (count > 1)
		{
			treeMap.put(top, count - 1);
		}

		return top;
	}

	public int top()
	{
		return stack.peek();
	}

	public int peekMax()
	{
		return treeMap.firstKey();
	}

	public int popMax()
	{
		int top = treeMap.firstKey();
		int count = treeMap.remove(top);
		stack.removeFirstOccurrence(top);

		if (count > 1)
		{
			treeMap.put(top, count - 1);
		}

		return top;
	}
}
