package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @version 1.0
 * @since 18.02.2021
 */
@LeetCode(
		id = 1762,
		name = "Buildings With an Ocean View",
		url = "https://leetcode.com/problems/buildings-with-an-ocean-view/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class BuildingsWithAnOceanView
{
	public int[] findBuildings(int[] heights)
	{
		int max = -1;
		LinkedList<Integer> linkedList = new LinkedList<>();
		for (int i = heights.length - 1; i >= 0; i--)
		{
			if (heights[i] > max)
			{
				linkedList.addFirst(i);
			}

			max = Math.max(max, heights[i]);
		}

		int[] answer = new int[linkedList.size()];
		for (int i = 0; i < answer.length; i++)
		{
			answer[i] = linkedList.removeFirst();
		}
		return answer;
	}
}
