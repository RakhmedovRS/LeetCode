package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 8/17/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
		id = 2375,
		name = "Construct Smallest Number From DI String",
		url = "https://leetcode.com/problems/construct-smallest-number-from-di-string/",
		difficulty = Difficulty.MEDIUM
)
public class ConstructSmallestNumberFromDIString
{
	public String smallestNumber(String pattern)
	{
		return smallestNumber(0, pattern.toCharArray(), new boolean[10], new StringBuilder());
	}

	private String smallestNumber(int pos, char[] DI, boolean[] used, StringBuilder sb)
	{
		if (pos > DI.length)
		{
			return sb.toString();
		}

		for (int i = 1; i < 10; i++)
		{
			if (pos == 0)
			{
				used[i] = true;
				sb.append(i);
				String res = smallestNumber(pos + 1, DI, used, sb);
				if (!"".equals(res))
				{
					return res;
				}

				used[i] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
			else if (!used[i])
			{
				if ((DI[pos - 1] == 'I' && i > (sb.charAt(sb.length() - 1) - '0'))
						|| (DI[pos - 1] == 'D' && i < (sb.charAt(sb.length() - 1) - '0')))
				{
					used[i] = true;
					sb.append(i);
					String res = smallestNumber(pos + 1, DI, used, sb);
					if (!"".equals(res))
					{
						return res;
					}

					used[i] = false;
					sb.deleteCharAt(sb.length() - 1);
				}
			}

		}

		return "";
	}
}
