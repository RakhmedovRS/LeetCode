import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 17-Jul-20
 */
@LeetCode(id = 967, name = "Numbers With Same Consecutive Differences", url = "https://leetcode.com/problems/numbers-with-same-consecutive-differences/")
public class NumbersWithSameConsecutiveDifferences
{
	public int[] numsSameConsecDiff(int N, int K)
	{
		List<Integer> integerList = new ArrayList<>();
		for (int i = 0; i < 10; i++)
		{
			dfs(i, 1, N, K, integerList);
		}

		int[] answer = new int[integerList.size()];
		for (int i = 0; i < integerList.size(); i++)
		{
			answer[i] = integerList.get(i);
		}

		return answer;
	}

	private void dfs(int current, int step, int N, int diff, List<Integer> integerList)
	{
		if (N == step)
		{
			integerList.add(current);
			return;
		}

		if ((int) Math.pow(10, step) > current * 10)
		{
			return;
		}

		int last = current % 10;
		if (last + diff < 10)
		{
			dfs(current * 10 + last + diff, step + 1, N, diff, integerList);
		}

		if (last - diff >= 0 && diff != 0)
		{
			dfs(current * 10 + last - diff, step + 1, N, diff, integerList);
		}
	}
}
