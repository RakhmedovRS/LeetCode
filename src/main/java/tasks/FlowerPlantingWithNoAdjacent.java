package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 01-Sep-20
 */
@LeetCode(id = 1042, name = "Flower Planting With No Adjacent", url = "https://leetcode.com/problems/flower-planting-with-no-adjacent/")
public class FlowerPlantingWithNoAdjacent
{
	public int[] gardenNoAdj(int N, int[][] paths)
	{
		int[] answer = new int[N];
		Arrays.fill(answer, -1);
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] path : paths)
		{
			graph.putIfAbsent(path[0], new ArrayList<>());
			graph.putIfAbsent(path[1], new ArrayList<>());
			graph.get(path[0]).add(path[1]);
			graph.get(path[1]).add(path[0]);
		}

		for (int i = 1; i <= N; i++)
		{
			boolean[] colors = new boolean[]{false, false, false, false};
			for (Integer next : graph.getOrDefault(i, Collections.emptyList()))
			{
				if (answer[next - 1] != -1)
				{
					colors[answer[next - 1] - 1] = true;
				}
			}

			for (int j = 0; j < colors.length; j++)
			{
				if (!colors[j])
				{
					answer[i - 1] = j + 1;
				}
			}
		}

		return answer;
	}
}
