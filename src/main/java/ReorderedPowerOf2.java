import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 10/21/2020
 */
@LeetCode(id = 869, name = "Reordered Power of 2", url = "https://leetcode.com/problems/reordered-power-of-2/")
public class ReorderedPowerOf2
{
	public boolean reorderedPowerOf2(int N)
	{
		Set<Integer> powersOfTwo = new HashSet<>();
		for (int i = 0; i < 31; i++)
		{
			powersOfTwo.add((int) Math.pow(2, i));
		}

		int[] digits = new int[10];
		while (N > 0)
		{
			digits[N % 10]++;
			N /= 10;
		}

		return dfs(0, digits, powersOfTwo);
	}

	private boolean dfs(int number, int[] digits, Set<Integer> powersOfTwo)
	{
		if (isEmpty(digits))
		{
			return powersOfTwo.contains(number);
		}

		boolean result = false;
		for (int i = 0; i < 10; i++)
		{
			if (number == 0 && i == 0)
			{
				continue;
			}

			if (digits[i] > 0)
			{
				digits[i]--;
				result = dfs(number * 10 + i, digits, powersOfTwo);
				if (result)
				{
					return true;
				}
				digits[i]++;
			}
		}

		return result;
	}

	private boolean isEmpty(int[] digits)
	{
		for (int i = 0; i < 10; i++)
		{
			if (digits[i] > 0)
			{
				return false;
			}
		}

		return true;
	}
}
