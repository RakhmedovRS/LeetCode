package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 05-Jun-20
 */
@LeetCode(
	id = 1396,
	name = "Design Underground System",
	url = "https://leetcode.com/problems/design-underground-system/",
	difficulty = Difficulty.MEDIUM
)
public class DesignUndergroundSystem
{
	class UndergroundSystem
	{

		Map<String, int[]> routesMap;
		Map<Integer, Map.Entry<String, Integer>> checkedIn;

		public UndergroundSystem()
		{
			routesMap = new HashMap<>();
			checkedIn = new HashMap<>();
		}

		public void checkIn(int id, String stationName, int t)
		{
			checkedIn.put(id, new java.util.AbstractMap.SimpleEntry<>(stationName, t));
		}

		public void checkOut(int id, String stationName, int t)
		{
			Map.Entry<String, Integer> entry = checkedIn.remove(id);
			String route = entry.getKey() + "|" + stationName;
			int[] statistics = routesMap.getOrDefault(route, new int[2]);
			statistics[0] += t - entry.getValue();
			statistics[1]++;
			routesMap.put(route, statistics);
		}

		public double getAverageTime(String startStation, String endStation)
		{
			String route = startStation + "|" + endStation;
			int[] statistics = routesMap.get(route);
			return 1D * statistics[0] / statistics[1];
		}
	}
}
