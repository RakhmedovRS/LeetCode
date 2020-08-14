import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 14-Aug-20
 */
@LeetCode(id = 1036, name = "Escape a Large Maze", url = "https://leetcode.com/problems/escape-a-large-maze/")
public class EscapeLargeMaze
{
	public boolean isEscapePossible(int[][] blocked, int[] source, int[] target)
	{
		if (blocked == null || blocked.length == 0)
		{
			return true;
		}

		Map<Integer, Set<Integer>> blocks = new HashMap<>();
		for (int[] block : blocked)
		{
			blocks.putIfAbsent(block[0], new HashSet<>());
			blocks.get(block[0]).add(block[1]);
		}

		return isEscapePossible(blocks, source, target, new HashSet<>())
			&& isEscapePossible(blocks, target, source, new HashSet<>());
	}

	private boolean isEscapePossible(Map<Integer, Set<Integer>> blocks, int[] source, int[] target, Set<String> visited)
	{
		int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		Queue<int[]> queue = new LinkedList<>();
		queue.add(source);
		while (!queue.isEmpty())
		{
			int[] current = queue.remove();
			if (!visited.add(current[0] + "-" + current[1]))
			{
				continue;
			}

			int row;
			int column;
			for (int[] direction : directions)
			{
				row = current[0] + direction[0];
				column = current[1] + direction[1];
				if (row < 0 || row == (int) 1e9 || column < 0 || column == (int) 1e9 || visited.contains(row + "-" + column)
					|| (blocks.containsKey(row) && blocks.get(row).contains(column)))
				{
					continue;
				}

				if (row == target[0] && column == target[1])
				{
					return true;
				}

				queue.add(new int[]{row, column});
			}

			if (visited.size() == 20000)
			{
				return true;
			}
		}

		return false;
	}
}
