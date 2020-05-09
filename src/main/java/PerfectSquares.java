import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 09-May-20
 */
@LeetCode(id = 279, name = "Perfect Squares", url = "https://leetcode.com/problems/perfect-squares/")
public class PerfectSquares
{
	public int numSquares(int n)
	{
		List<Integer> squares = new ArrayList<>();
		for (int i = 1; i * i <= n; i++)
		{
			squares.add(i * i);
		}

		return minSquares(squares, n, new HashMap<>());
	}

	private int minSquares(List<Integer> squares, int n, Map<Integer, Integer> cache)
	{
		if (n <= 0)
		{
			return n;
		}

		if (cache.containsKey(n))
		{
			return cache.get(n);
		}

		int minCount = Integer.MAX_VALUE;
		int count;
		for (int i = 0; i < squares.size(); i++)
		{
			count = minSquares(squares, n - squares.get(i), cache);
			if (count >= 0 && count < minCount)
			{
				minCount = 1 + count;
			}
		}

		cache.put(n, minCount == Integer.MAX_VALUE ? -1 : minCount);
		return minCount;
	}

	public static void main(String[] args)
	{
		System.out.println(new PerfectSquares().numSquares(13));
	}
}
