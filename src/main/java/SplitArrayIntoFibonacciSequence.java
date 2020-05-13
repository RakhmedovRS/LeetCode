import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 13-May-20
 */
@LeetCode(id = 849, name = "Split Array into Fibonacci Sequence", url = "https://leetcode.com/problems/split-array-into-fibonacci-sequence/")
public class SplitArrayIntoFibonacciSequence
{
	public List<Integer> splitIntoFibonacci(String S)
	{
		List<Integer> result = new ArrayList<>();
		splitIntoFibonacci(S, 0, result);
		return result;
	}

	private boolean splitIntoFibonacci(String S, int startPos, List<Integer> result)
	{
		if (startPos == S.length())
		{
			return result.size() > 2;
		}

		for (int i = startPos + 1; i <= S.length(); i++)
		{
			if (S.charAt(startPos) == '0' && i - startPos > 1)
			{
				return false;
			}

			long number = Long.parseLong(S.substring(startPos, i));
			if (number > Integer.MAX_VALUE)
			{
				return false;
			}

			if (result.size() >= 2 && result.get(result.size() - 2) + result.get(result.size() - 1) != number)
			{
				continue;
			}
			result.add((int)number);

			if (splitIntoFibonacci(S, i, result))
			{
				return true;
			}
			result.remove(result.size() - 1);
		}

		return false;
	}
}
