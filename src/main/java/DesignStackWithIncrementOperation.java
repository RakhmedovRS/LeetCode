import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 29-Jun-20
 */
@LeetCode(id = 1381, name = "Design a Stack With Increment Operation", url = "https://leetcode.com/problems/design-a-stack-with-increment-operation/")
public class DesignStackWithIncrementOperation
{
	class CustomStack
	{
		int[] values;
		int pointer;

		public CustomStack(int maxSize)
		{
			values = new int[maxSize];
			pointer = maxSize - 1;
		}

		public void push(int x)
		{
			if (pointer >= 0)
			{
				values[pointer--] = x;
			}
		}

		public int pop()
		{
			if (pointer == values.length - 1)
			{
				return -1;
			}

			return values[++pointer];
		}

		public void increment(int k, int val)
		{
			for (int i = values.length - 1; i >= 0 && k > 0; i--, k--)
			{
				values[i] += val;
			}
		}
	}
}
