import common.LeetCode;

import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 30-Jul-20
 */
@LeetCode(id = 539, name = "Minimum Time Difference", url = "Minimum Time Difference")
public class MinimumTimeDifference
{
	public int findMinDifference(List<String> timePoints)
	{
		int[] times = new int[timePoints.size()];

		for (int i = 0; i < timePoints.size(); i++)
		{
			int hours = (timePoints.get(i).charAt(0) - '0') * 10 + (timePoints.get(i).charAt(1) - '0');
			int minutes = (timePoints.get(i).charAt(3) - '0') * 10 + (timePoints.get(i).charAt(4) - '0');
			times[i] = 60 * hours + minutes;
		}

		Arrays.sort(times);
		int minDiff = (24 * 60 - times[times.length - 1]) + times[0];
		minDiff = minDiff < 0 ? 24 * 60 : minDiff;
		for (int i = 1; i < times.length; i++)
		{
			minDiff = Math.min(minDiff, times[i] - times[i - 1]);
		}

		return minDiff;
	}
}
