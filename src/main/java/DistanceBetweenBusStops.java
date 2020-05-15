import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 15-May-20
 */
@LeetCode(id = 1184, name = "Distance Between Bus Stops", url = "https://leetcode.com/problems/distance-between-bus-stops/")
public class DistanceBetweenBusStops
{
	public int distanceBetweenBusStops(int[] distance, int start, int destination)
	{
		if (start == destination)
		{
			return 0;
		}

		if (start > destination)
		{
			return distanceBetweenBusStops(distance, destination, start);
		}

		int forwardDistance = 0;
		int backwardDistance = 0;
		int s = start;
		while (s != destination)
		{
			forwardDistance += distance[s++];
			if (s == distance.length)
			{
				s = 0;
			}
		}

		s = start;
		while (s != destination)
		{
			s--;
			if (s < 0)
			{
				s = distance.length - 1;
			}
			backwardDistance += distance[s];
		}

		return Math.min(forwardDistance, backwardDistance);
	}
}
