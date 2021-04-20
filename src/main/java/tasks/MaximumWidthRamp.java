package tasks;

import common.LeetCode;

import java.util.TreeMap;

/**
 * @author RakhmedovRS
 * @created 17-Sep-20
 */
@LeetCode(id = 962, name = "Maximum Width Ramp", url = "https://leetcode.com/problems/maximum-width-ramp/")
public class MaximumWidthRamp
{
	public int maxWidthRamp(int[] A)
	{
		int max = 0;
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		for (int i = 0; i < A.length; i++)
		{
			if (i == 0 || A[i] < treeMap.firstKey())
			{
				treeMap.put(A[i], i);
			}
			else
			{
				max = Math.max(max, i - treeMap.floorEntry(A[i]).getValue());
			}
		}

		return max;
	}
}
