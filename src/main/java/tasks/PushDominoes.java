package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 04-Sep-20
 */
@LeetCode(
	id = 838,
	name = "Push Dominoes",
	url = "https://leetcode.com/problems/push-dominoes/",
	difficulty = Difficulty.MEDIUM
)
public class PushDominoes
{
	public String pushDominoes(String dominoes)
	{
		char[] chars = dominoes.toCharArray();
		int[] memo = new int[dominoes.length()];
		Queue<Integer> positions = new LinkedList<>();
		for (int i = 0; i < chars.length; i++)
		{
			if (chars[i] == 'L' || chars[i] == 'R')
			{
				memo[i] = 0;
				positions.add(i);
			}
			else
			{
				memo[i] = -1;
			}
		}

		int size;
		int step = 1;
		while (!positions.isEmpty())
		{
			size = positions.size();
			while (size-- > 0)
			{
				int position = positions.remove();
				if (position < 0 || position == chars.length)
				{
					continue;
				}

				if (chars[position] == 'L')
				{
					if (position > 0)
					{
						if (chars[position - 1] == '.')
						{
							chars[position - 1] = 'L';
							memo[position - 1] = step;
							positions.add(position - 1);
						}
						else if (chars[position - 1] == 'R' && memo[position - 1] == step)
						{
							chars[position - 1] = '.';
						}
					}
				}
				else if (chars[position] == 'R')
				{
					if (position + 1 < chars.length)
					{
						if (chars[position + 1] == '.')
						{
							chars[position + 1] = 'R';
							memo[position + 1] = step;
							positions.add(position + 1);
						}
						else if (chars[position + 1] == 'L' && memo[position + 1] == step)
						{
							chars[position + 1] = '.';
						}
					}
				}
			}
			step++;
		}

		return String.valueOf(chars);
	}
}
