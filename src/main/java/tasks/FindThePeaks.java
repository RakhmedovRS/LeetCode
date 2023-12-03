package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 12/2/2023
 */
@LeetCode(
		id = 2951,
		name = "Find the Peaks",
		url = "https://leetcode.com/problems/find-the-peaks/",
		difficulty = Difficulty.EASY
)
public class FindThePeaks
{
	public List<Integer> findPeaks(int[] mountain) {
		List<Integer> ans = new ArrayList<>();
		for (int i = 1; i < mountain.length - 1; i++)
		{
			if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1])
			{
				ans.add(i);
			}
		}

		return ans;
	}
}
