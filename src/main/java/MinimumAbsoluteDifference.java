import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 25-Mar-20
 */
@LeetCode(id = 1200, name = "Minimum Absolute Difference", url = "https://leetcode.com/problems/minimum-absolute-difference/")
public class MinimumAbsoluteDifference
{
	public List<List<Integer>> minimumAbsDifference(int[] arr)
	{
		if (arr == null || arr.length <= 1)
		{
			return Collections.emptyList();
		}

		Arrays.sort(arr);
		int minDifference = Integer.MAX_VALUE;
		for (int i = 1; i < arr.length; i++)
		{
			minDifference = Math.min(minDifference, arr[i] - arr[i - 1]);
		}

		List<List<Integer>> pairs = new ArrayList<>();
		for (int i = 1; i < arr.length; i++)
		{
			if (arr[i] - arr[i - 1] == minDifference)
			{
				pairs.add(Arrays.asList(arr[i - 1], arr[i]));
			}
		}

		return pairs;
	}
}
