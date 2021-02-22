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
			for (int candidate = 0; candidate < n; candidate++)
			{
				if (isCelebrity(candidate, n))
				{
					return candidate;
				}
			}

			return -1;
		}

		private boolean isCelebrity(int candidate, int n)
		{
			for (int i = 0; i < n; i++)
			{
				if (candidate != i)
				{
					if (knows(candidate, i) || !knows(i, candidate))
					{
						return false;
					}
				}
			}

			return true;
		}
	}
}
