package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 5/13/2021
 */
@LeetCode(
		id = 816,
		name = "Ambiguous Coordinates",
		url = "https://leetcode.com/problems/ambiguous-coordinates/",
		difficulty = Difficulty.MEDIUM
)
public class AmbiguousCoordinates
{
	public List<String> ambiguousCoordinates(String s)
	{
		List<String> answer = new ArrayList<>();
		for (int i = 2; i < s.length() - 1; i++)
		{
			for (String left : generatePossibleNumbers(1, i, s))
			{
				for (String right : generatePossibleNumbers(i, s.length() - 1, s))
				{
					answer.add("(" + left + ", " + right + ")");
				}
			}
		}

		return answer;
	}

	private List<String> generatePossibleNumbers(int left, int right, String s)
	{
		List<String> numbers = new ArrayList<>();
		for (int divisor = 1; divisor <= right - left; divisor++)
		{
			String leftSub = s.substring(left, left + divisor);
			String rightSub = s.substring(left + divisor, right);

			if ((!leftSub.startsWith("0") || leftSub.equals("0")) && !rightSub.endsWith("0"))
			{
				numbers.add(leftSub + (divisor < right - left ? "." : "") + rightSub);
			}
		}

		return numbers;
	}

	public static void main(String[] args)
	{
		AmbiguousCoordinates clazz = new AmbiguousCoordinates();
		System.out.println(clazz.ambiguousCoordinates("(0123)"));
		System.out.println(clazz.ambiguousCoordinates("(123)"));
	}
}
