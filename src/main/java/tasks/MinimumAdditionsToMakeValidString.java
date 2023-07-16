package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author Ruslan Rakhmedov
 * @created 4/23/2023
 */
@LeetCode(
		id = 2645,
		name = "Minimum Additions to Make Valid String",
		url = "https://leetcode.com/problems/minimum-additions-to-make-valid-string/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumAdditionsToMakeValidString
{
	public int addMinimum(String word)
	{
		int add = 0;
		LinkedList<Character> chars = new LinkedList<>();
		for (char ch : word.toCharArray())
		{
			chars.addLast(ch);
		}

		while (!chars.isEmpty())
		{
			char ch = chars.removeFirst();
			if (ch == 'a')
			{
				if (chars.isEmpty())
				{
					add += 2;
				}
				else
				{
					if (chars.getFirst() == 'b')
					{
						chars.removeFirst();
						if (chars.isEmpty())
						{
							add++;
						}
						else
						{
							if (chars.getFirst() == 'c')
							{
								chars.removeFirst();
							}
							else
							{
								add++;
							}
						}
					}
					else if (chars.getFirst() == 'c')
					{
						chars.removeFirst();
						add++;
					}
					else
					{
						add += 2;
					}
				}
			}

			if (ch == 'b')
			{
				if (chars.isEmpty())
				{
					add += 2;
				}
				else
				{
					add++;
					if (chars.getFirst() == 'c')
					{
						chars.removeFirst();
					}
					else
					{
						add++;
					}
				}
			}

			if (ch == 'c')
			{
				add += 2;
			}
		}

		return add;
	}
}
