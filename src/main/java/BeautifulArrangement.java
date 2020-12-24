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
	public int countArrangement(int N)
	{
		int[] count = {0};
		boolean[] used = new boolean[N + 1];
		dfs(1, used, N, count);
		return count[0];
	}

	private void dfs(int pos, boolean[] used, int N, int[] count)
	{
		if (pos > N)
		{
			count[0]++;
			return;
		}

		for (int val = 1; val <= N; val++)
		{
			if (!used[val] && (val % pos == 0 || pos % val == 0))
			{
				used[val] = true;
				dfs(pos + 1, used, N, count);
				used[val] = false;
			}
		}
	}
}
