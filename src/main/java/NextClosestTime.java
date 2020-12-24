import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/24/2020
 */
@LeetCode(
	id = 681,
	name = "Next Closest Time",
	url = "https://leetcode.com/problems/next-closest-time/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class NextClosestTime
{
	public String nextClosestTime(String time)
	{
		boolean[] digits = new boolean[10];
		for (char ch : time.toCharArray())
		{
			if (Character.isDigit(ch))
			{
				digits[ch - '0'] = true;
			}
		}

		java.time.LocalTime[] next = new java.time.LocalTime[]{null, null};
		dfs(new char[]{' ', ' ', ':', ' ', ' '}, 0, digits, java.time.LocalTime.parse(time), next);
		if (next[0] == null && next[1] == null)
		{
			return time;
		}
		else if (next[1] == null)
		{
			return next[0].toString();
		}
		else
		{
			return next[1].toString();
		}
	}

	private void dfs(char[] chars, int pos, boolean[] digits, java.time.LocalTime localTime, java.time.LocalTime[] next)
	{
		if (pos == 2)
		{
			dfs(chars, pos + 1, digits, localTime, next);
			return;
		}

		if (pos == 5)
		{
			java.time.LocalTime lt = java.time.LocalTime.parse(String.valueOf(chars));
			if (localTime.equals(lt))
			{
				return;
			}

			long diff = lt.toNanoOfDay() - localTime.toNanoOfDay();
			if (diff > 0)
			{
				if (next[1] == null)
				{
					next[1] = lt;
				}
				else
				{
					if (diff < localTime.toNanoOfDay() - next[1].toNanoOfDay())
					{
						next[1] = lt;
					}
				}
			}
			else
			{
				if (next[0] == null)
				{
					next[0] = lt;
				}
				else
				{
					if (diff > localTime.toNanoOfDay() - next[0].toNanoOfDay())
					{
						next[0] = lt;
					}
				}
			}

			return;
		}

		for (int i = 0; i < 10; i++)
		{
			if (digits[i])
			{
				if (pos == 0 && i > 2)
				{
					break;
				}

				if (pos == 1 && chars[0] == '2' && i > 3)
				{
					break;
				}

				if (pos == 3 && i > 5)
				{
					break;
				}

				chars[pos] = (char) (i + '0');
				dfs(chars, pos + 1, digits, localTime, next);
			}
		}
	}
}
