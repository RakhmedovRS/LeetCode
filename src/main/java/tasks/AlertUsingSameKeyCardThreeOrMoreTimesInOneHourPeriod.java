package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 10/3/2020
 */
@LeetCode(id = 1604, name = "Alert Using Same Key-Card Three or More Times in a One Hour Period", url = "https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/")
public class AlertUsingSameKeyCardThreeOrMoreTimesInOneHourPeriod
{
	public List<String> alertNames(String[] keyNames, String[] keyTime)
	{
		TreeSet<String> names = new TreeSet<>();
		Map<String, List<Integer>> map = new HashMap<>();
		String[] parts;
		int hour;
		int minutes;
		for (int i = 0; i < keyNames.length; i++)
		{
			parts = keyTime[i].split(":");
			hour = Integer.parseInt(parts[0]);
			minutes = Integer.parseInt(parts[1]);
			map.putIfAbsent(keyNames[i], new ArrayList<>());
			map.get(keyNames[i]).add(hour * 60 + minutes);
		}

		List<Integer> time;
		for (Map.Entry<String, List<Integer>> entry : map.entrySet())
		{
			int left = 0;
			int right = 0;
			time = entry.getValue();
			Collections.sort(time);
			while (right < time.size())
			{
				while (left < right && Math.abs(time.get(right) - time.get(left)) > 60)
				{
					left++;
				}

				right++;
				if (right - left > 2)
				{
					names.add(entry.getKey());
					break;
				}
			}
		}

		return new ArrayList<>(names);
	}
}
