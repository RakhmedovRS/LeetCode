package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 26-Mar-20
 */
@LeetCode(
		id = 155,
		name = "Min Stack",
		url = "https://leetcode.com/problems/min-stack/",
		difficulty = Difficulty.EASY
)
class MinStack
{

	LinkedList<Integer> stack;
	LinkedList<Integer> mStack;

	public MinStack()
	{
		stack = new LinkedList<>();
		mStack = new LinkedList<>();
	}

	public void push(int val)
	{
		if (!mStack.isEmpty())
		{
			mStack.addLast(Math.min(mStack.getLast(), val));
		}
		else
		{
			mStack.addLast(val);
		}
		stack.addLast(val);
	}

	public void pop()
	{
		stack.removeLast();
		mStack.removeLast();
	}

	public int top()
	{
		return stack.getLast();
	}

	public int getMin()
	{
		return mStack.getLast();
	}
}
