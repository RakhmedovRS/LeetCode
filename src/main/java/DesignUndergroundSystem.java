import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 05-Jun-20
 */
@LeetCode(id = 1396, name = "Design Underground System", url = "https://leetcode.com/problems/design-underground-system/")
public class DesignUndergroundSystem
{
	class UndergroundSystem
	{
		private class Trip
		{
			String startStation;
			int enterTime;

			public boolean isCheckedIn()
			{
				return startStation == null;
			}
		}

		Map<Integer, Trip> customers;
		Map<String, int[]> averages;

		public UndergroundSystem()
		{
			customers = new HashMap<>();
			averages = new HashMap<>();
		}

		public void checkIn(int id, String stationName, int t)
		{
			Trip trip = customers.getOrDefault(id, new Trip());
			if (!trip.isCheckedIn())
			{
				return;
			}

			trip.startStation = stationName;
			trip.enterTime = t;
			customers.put(id, trip);
		}

		public void checkOut(int id, String stationName, int t)
		{
			Trip trip = customers.remove(id);
			if (trip == null || trip.startStation.equals(stationName))
			{
				return;
			}

			String route = trip.startStation + "_" + stationName;

			int[] average = averages.getOrDefault(route, new int[]{0, 0});
			average[0] += t - trip.enterTime;
			average[1]++;
			averages.put(route, average);
		}

		public double getAverageTime(String startStation, String endStation)
		{
			int[] average = averages.getOrDefault(startStation + "_" + endStation, new int[]{0, 1});
			return 1D * average[0] / average[1];
		}
	}
}
