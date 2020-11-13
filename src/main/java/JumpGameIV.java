import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 11/13/2020
 */
@LeetCode(id = 1345, name = "Jump Game IV", url = "https://leetcode.com/problems/jump-game-iv/")
public class JumpGameIV
{
	public int minJumps(int[] arr)
	{
		if (arr.length <= 1)
		{
			return 0;
		}

		Map<Integer, List<Integer>> numberToPositions = new HashMap<>();
		for (int i = 0; i < arr.length; i++)
		{
			numberToPositions.putIfAbsent(arr[i], new ArrayList<>());
			numberToPositions.get(arr[i]).add(i);
		}

		boolean[] visited = new boolean[arr.length];
		int steps = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		visited[0] = true;
		int size;
		int currentPos;
		while (!queue.isEmpty())
		{
			size = queue.size();
			while (size-- > 0)
			{
				currentPos = queue.remove();
				if (currentPos == arr.length - 1)
				{
					return steps;
				}

				List<Integer> nexts = numberToPositions.get(arr[currentPos]);
				if (currentPos - 1 >= 0)
				{
					nexts.add(currentPos - 1);
				}

				nexts.add(currentPos + 1);

				for (int next : nexts)
				{
					if (next != currentPos && !visited[next])
					{
						visited[next] = true;
						queue.add(next);
					}
				}

				nexts.clear();
			}

			steps++;
		}

		return steps;
	}
}
