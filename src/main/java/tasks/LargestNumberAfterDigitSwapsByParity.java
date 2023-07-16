package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 4/10/2022
 */
@LeetCode(
		id = 2231,
		name = "Largest Number After Digit Swaps by Parity",
		url = "https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/",
		difficulty = Difficulty.EASY
)
public class LargestNumberAfterDigitSwapsByParity
{
	public int largestInteger(int num)
	{
		PriorityQueue<Integer> even = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> odd = new PriorityQueue<>(Comparator.reverseOrder());
		char[] chars = String.valueOf(num).toCharArray();
		for (int i = 0; i < chars.length; i++)
		{
			if ((chars[i] - '0') % 2 == 0)
			{
				even.add(chars[i] - '0');
			}
			else
			{
				odd.add(chars[i] - '0');
			}
		}

		int res = 0;
		for (int i = 0; i < chars.length; i++)
		{
			res *= 10;
			if ((chars[i] - '0') % 2 == 0)
			{
				res += even.remove();
			}
			else
			{
				res += odd.remove();
			}
		}

		return res;
	}
}
