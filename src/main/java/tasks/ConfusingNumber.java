package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 11/29/2020
 */
@LeetCode(
		id = 1056,
		name = "Confusing Number",
		url = "https://leetcode.com/problems/confusing-number/",
		difficulty = Difficulty.EASY,
		premium = true
)
public class ConfusingNumber
{
	public boolean confusingNumber(int N)
	{
		if (N == 0)
		{
			return false;
		}

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		map.put(1, 1);
		map.put(6, 9);
		map.put(8, 8);
		map.put(9, 6);

		String original = String.valueOf(N);
		StringBuilder flipped = new StringBuilder(original.length());
		while (N > 0)
		{
			if (!map.containsKey(N % 10))
			{
				return false;
			}

			flipped.append(map.get(N % 10));

			N /= 10;
		}

		return !original.equals(flipped.toString());
	}

	public static void main(String[] args)
	{
		System.out.println(new ConfusingNumber().confusingNumber(0));
		System.out.println(new ConfusingNumber().confusingNumber(916));
		System.out.println(new ConfusingNumber().confusingNumber(919));
	}
}
