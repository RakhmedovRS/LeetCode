import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 12/7/2020
 */
@LeetCode(
	id = 1197,
	name = "Minimum Knight Moves",
	url = "https://leetcode.com/problems/minimum-knight-moves/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class MinimumKnightMoves
{
	public int minKnightMoves(int x, int y)
	{
		if (x == 0 && y == 0)
		{
			return 0;
		}

		Queue<int[]> positions = new LinkedList<>();
		positions.add(new int[]{0, 0});
		Map<Integer, Set<Integer>> visited = new HashMap<>();
		visited.put(0, new HashSet<>());
		visited.get(0).add(0);

		int size;
		int steps = 0;
		int[] current;
		int nextX;
		int nextY;
		int[][] moves = new int[][]
			{
				{-2, -1},
				{-2, 1},
				{-1, -2},
				{-1, 2},
				{1, -2},
				{1, 2},
				{2, -1},
				{2, 1}
			};
		while (!positions.isEmpty())
		{
			size = positions.size();
			while (size-- > 0)
			{
				current = positions.remove();
				for (int[] move : moves)
				{
					nextX = current[0] + move[0];
					nextY = current[1] + move[1];

					if (nextX == x && nextY == y)
					{
						return steps + 1;
					}

					visited.putIfAbsent(nextX, new HashSet<>());
					if (!visited.get(nextX).add(nextY))
					{
						continue;
					}

					positions.add(new int[]{nextX, nextY});
				}
			}
			steps++;
		}

		return steps;
	}
}
