import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/9/2020
 */
@LeetCode(
	id = 277,
	name = "Find the Celebrity",
	url = "https://leetcode.com/problems/find-the-celebrity/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class FindTheCelebrity
{
	class Relation
	{
		boolean knows(int a, int b)
		{
			return true;
		}
	}

	public class Solution extends Relation
	{
		public int findCelebrity(int n)
		{
			int candidate = 0;
			for (int i = 0; i < n; i++)
			{
				if (knows(candidate, i))
				{
					candidate = i;
				}
			}

			if (isCelebrity(candidate, n))
			{
				return candidate;
			}
			return -1;
		}

		private boolean isCelebrity(int i, int n)
		{
			for (int j = 0; j < n; j++)
			{
				if (i == j)
				{
					continue;
				}

				if (knows(i, j) || !knows(j, i))
				{
					return false;
				}
			}

			return true;
		}
	}
}
