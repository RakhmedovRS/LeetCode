import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/24/2020
 */
@LeetCode(
	id = 526,
	name = "Beautiful Arrangement",
	url = "https://leetcode.com/problems/beautiful-arrangement/",
	difficulty = Difficulty.MEDIUM
)
public class BeautifulArrangement
{
	public int countArrangement(int n)
	{
		boolean[] used = new boolean[16];
		return dfs(1, used, n);
	}

	private int dfs(int pos, boolean[] used, int n)
	{
		if (pos > n)
		{
			return 1;
		}

		int count = 0;
		for (int i = 1; i <= n; i++)
		{
			if (!used[i] && (i % pos  ==0 || pos % i ==0))
			{
				used[i] = true;
				count += dfs(pos + 1, used, n);
				used[i] = false;
			}
		}
		return count;
	}
}
