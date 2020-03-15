import common.LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 15-Mar-20
 */
@LeetCode(id = 412, name = "Fizz Buzz", url = "https://leetcode.com/problems/fizz-buzz/")
public class FizzBuzz
{
	public List<String> fizzBuzz(int n)
	{
		List<String> result = new LinkedList<>();
		for (int i = 1; i <= n; i++)
		{
			if (i % 15 == 0)
			{
				result.add("FizzBuzz");
			}
			else if (i % 5 == 0)
			{
				result.add("Buzz");
			}
			else if (i % 3 == 0)
			{
				result.add("Fizz");
			}
			else
			{
				result.add(String.valueOf(i));
			}
		}

		return result;
	}
}
