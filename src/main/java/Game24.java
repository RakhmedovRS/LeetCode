import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 22-Sep-20
 */
@LeetCode(id = 679, name = "24 Game", url = "https://leetcode.com/problems/24-game/")
public class Game24
{
	public boolean judgePoint24(int[] nums)
	{
		List<Double> doubles = new ArrayList<>();
		for (int num : nums)
		{
			doubles.add(1D * num);
		}

		return dfs(doubles);
	}

	private boolean dfs(List<Double> doubles)
	{
		if (doubles.isEmpty())
		{
			return false;
		}

		if (doubles.size() == 1)
		{
			return Math.abs(doubles.get(0) - 24) < 0.001;
		}

		for (int i = 0; i < doubles.size(); i++)
		{
			for (int j = 0; j < doubles.size(); j++)
			{
				if (i == j)
				{
					continue;
				}

				List<Double> next = new ArrayList<>();
				for (int pos = 0; pos < doubles.size(); pos++)
				{
					if (pos != i && pos != j)
					{
						next.add(doubles.get(pos));
					}
				}

				for (int pos = 0; pos < 4; pos++)
				{
					if (pos < 2 && j > i)
					{
						continue;
					}
					if (pos == 0)
					{
						next.add(doubles.get(i) + doubles.get(j));
					}
					else if (pos == 1)
					{
						next.add(doubles.get(i) * doubles.get(j));
					}
					else if (pos == 2)
					{
						next.add(doubles.get(i) - doubles.get(j));
					}
					else
					{
						if (doubles.get(j) == 0)
						{
							continue;
						}

						next.add(doubles.get(i) / doubles.get(j));
					}

					if (dfs(next))
					{
						return true;
					}

					next.remove(next.size() - 1);
				}
			}
		}

		return false;
	}
}
