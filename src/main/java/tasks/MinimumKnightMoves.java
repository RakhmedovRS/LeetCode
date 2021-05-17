package tasks;

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
		Map<Integer, Set<Integer>> visited = new HashMap<>();
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0, 0});

		int steps = 0;
		int size;
		int[] current;
		int row;
		int column;
		int nextRow;
		int nextColumn;

		int[][] moves = new int[][]{{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
		while (!queue.isEmpty())
		{
			size = queue.size();
			while (size-- > 0)
			{
				current = queue.remove();
				row = current[0];
				column = current[1];

				if (row == x && column == y)
				{
					return steps;
				}

				for (int[] move : moves)
				{
					nextRow = row + move[0];
					nextColumn = column + move[1];

					if (visited.getOrDefault(nextRow, Collections.emptySet()).contains(nextColumn))
					{
						continue;
					}

					visited.putIfAbsent(nextRow, new HashSet<>());
					visited.get(nextRow).add(nextColumn);

					queue.add(new int[]{nextRow, nextColumn});
				}
			}

			steps++;
		}

		return -1;
	}
}
