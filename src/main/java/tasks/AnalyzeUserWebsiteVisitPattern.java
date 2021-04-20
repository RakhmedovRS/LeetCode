package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 2/24/2021
 */
@LeetCode(
	id = 1152,
	name = "Analyze User Website Visit Pattern",
	url = "https://leetcode.com/problems/analyze-user-website-visit-pattern/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class AnalyzeUserWebsiteVisitPattern
{
	public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website)
	{
		Map<String, List<Map.Entry<String, Integer>>> usersHistory = new HashMap<>();
		for (int i = 0; i < username.length; i++)
		{
			usersHistory.putIfAbsent(username[i], new ArrayList<>());
			usersHistory.get(username[i]).add(new java.util.AbstractMap.SimpleEntry<>(website[i], timestamp[i]));
		}

		Map<String, Integer> triplesCount = new HashMap<>();
		int max = 0;
		int count;
		for (Map.Entry<String, List<Map.Entry<String, Integer>>> entry : usersHistory.entrySet())
		{
			List<Map.Entry<String, Integer>> list = entry.getValue();
			list.sort(Comparator.comparingInt(Map.Entry::getValue));

			Set<String> visited = new HashSet<>();
			for (int a = 0; a < list.size(); a++)
			{
				for (int b = a + 1; b < list.size(); b++)
				{
					for (int c = b + 1; c < list.size(); c++)
					{
						StringBuilder sb = new StringBuilder();
						sb.append(list.get(a).getKey());
						sb.append(" ");
						sb.append(list.get(b).getKey());
						sb.append(" ");
						sb.append(list.get(c).getKey());

						String triplet = sb.toString();
						if (visited.add(triplet))
						{
							count = triplesCount.getOrDefault(triplet, 0) + 1;
							triplesCount.put(triplet, count);
							max = Math.max(max, count);
						}
					}
				}
			}
		}

		String candidate = null;
		for (Map.Entry<String, Integer> entry : triplesCount.entrySet())
		{
			if (entry.getValue() == max && (candidate == null || entry.getKey().compareTo(candidate) < 0))
			{
				candidate = entry.getKey();
			}
		}

		return Arrays.asList(candidate.split(" "));
	}
}
