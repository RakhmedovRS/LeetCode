package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 8/23/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
		id = 2381,
		name = "Shifting Letters II",
		url = "https://leetcode.com/problems/shifting-letters-ii/",
		difficulty = Difficulty.MEDIUM
)
public class ShiftingLettersII
{
	public String shiftingLetters(String s, int[][] shifts)
	{
		char[] chars = s.toCharArray();
		int[] shiftArr = new int[chars.length];
		for (int[] shift : shifts)
		{
			int start = shift[0];
			int end = shift[1];
			int dir = shift[2] == 1 ? 1 : -1;

			shiftArr[start] += dir;
			if (end + 1 < shiftArr.length)
			{
				shiftArr[end + 1] += dir * -1;
			}
		}

		for (int i = 1; i < shiftArr.length; i++)
		{
			shiftArr[i] += shiftArr[i - 1];
		}


		for (int i = 0; i < shiftArr.length; i++)
		{
			shiftArr[i] %= 26;
			char ch = chars[i];
			while (shiftArr[i] != 0)
			{
				if (shiftArr[i] < 0)
				{
					if (ch == 'a')
					{
						ch = 'z';
					}
					else
					{
						ch--;
					}
					shiftArr[i]++;
				}
				else
				{
					if (ch == 'z')
					{
						ch = 'a';
					}
					else
					{
						ch++;
					}
					shiftArr[i]--;
				}
			}

			chars[i] = ch;
		}

		return String.valueOf(chars);
	}
}
