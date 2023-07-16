package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Collections;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 15-Mar-20
 */
@LeetCode(
		id = 412,
		name = "Fizz Buzz",
		url = "https://leetcode.com/problems/fizz-buzz/",
		difficulty = Difficulty.EASY
)
public class FizzBuzz
{
	public List<String> fizzBuzz(int n)
	{
		if (n < 1)
		{
			return Collections.emptyList();
		}

		return new java.util.AbstractList<String>()
		{
			@Override
			public String get(int i)
			{
				i++;
				if (i % 3 == 0 && i % 5 == 0)
				{
					return "FizzBuzz";
				}
				else if (i % 3 == 0)
				{
					return "Fizz";
				}
				else if (i % 5 == 0)
				{
					return "Buzz";
				}
				else
				{
					return String.valueOf(i);
				}
			}

			@Override
			public int size()
			{
				return n;
			}
		};

	}
}
