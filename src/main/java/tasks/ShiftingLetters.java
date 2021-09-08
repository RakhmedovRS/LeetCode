package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 17-May-20
 */
@LeetCode(
	id = 848,
	name = "Shifting Letters",
	url = "https://leetcode.com/problems/shifting-letters/",
	difficulty = Difficulty.MEDIUM
)
public class ShiftingLetters
{
	public String shiftingLetters(String S, int[] shifts)
	{
		char[] values = S.toCharArray();

		for (int i = shifts.length - 2; i >= 0; i--)
		{
			shifts[i] += shifts[i + 1];
			shifts[i] %= 26;
		}

		for (int i = 0; i < shifts.length; i++)
		{
			values[i] = (char) (((values[i] - 'a') + shifts[i]) % 26 + 'a');
		}

		return String.valueOf(values);
	}

	public static void main(String[] args)
	{
		System.out.println(new ShiftingLetters().shiftingLetters("abc", new int[]{3, 5, 9}));
	}
}
