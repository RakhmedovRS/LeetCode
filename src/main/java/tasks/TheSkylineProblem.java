package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 11/30/2020
 */
@LeetCode(
		id = 218,
		name = "The Skyline Problem",
		url = "https://leetcode.com/problems/the-skyline-problem/",
		difficulty = Difficulty.HARD
)
public class TheSkylineProblem
{
	public List<List<Integer>> getSkyline(int[][] buildings)
	{
		List<List<Integer>> answer = new ArrayList<>();
		List<int[]> points = new ArrayList<>();
		int startPos;
		int endPos;
		int height;
		for (int[] building : buildings)
		{
			startPos = building[0];
			endPos = building[1];
			height = building[2];

			points.add(new int[]{startPos, height, 1});
			points.add(new int[]{endPos, height, 0});
		}

		points.sort(Comparator.comparingInt(point -> point[0]));

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		maxHeap.add(0);
		int current = 0;
		for (int i = 0; i < points.size(); )
		{
			int add = 0;
			while (i + add < points.size() && points.get(i + add)[0] == points.get(i)[0])
			{
				if (points.get(i + add)[2] == 1)
				{
					maxHeap.add(points.get(i + add)[1]);
				}
				else
				{
					maxHeap.remove(points.get(i + add)[1]);
				}
				add++;
			}

			if (current != maxHeap.peek())
			{
				current = maxHeap.peek();
				answer.add(Arrays.asList(points.get(i)[0], current));
			}

			i += add;
		}

		return answer;
	}

	public static void main(String[] args)
	{
		System.out.println(new TheSkylineProblem().getSkyline(new int[][]
				{
						{0, 2, 3},
						{2, 5, 3}
				}));

		System.out.println(new TheSkylineProblem().getSkyline(new int[0][]));

		System.out.println(new TheSkylineProblem().getSkyline(new int[][]
				{
						{0, Integer.MAX_VALUE, Integer.MAX_VALUE},
				}));

		System.out.println(new TheSkylineProblem().getSkyline(new int[][]
				{
						{2, 9, 10},
						{3, 7, 15},
						{5, 12, 12},
						{15, 20, 10},
						{19, 24, 8}
				}));
	}
}
