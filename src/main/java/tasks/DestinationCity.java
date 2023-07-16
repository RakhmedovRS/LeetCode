package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 17-May-20
 */
@LeetCode(id = 1436, name = "Destination City", url = "https://leetcode.com/problems/destination-city/")
public class DestinationCity
{
	public String destCity(List<List<String>> paths)
	{
		Map<String, List<String>> graph = new HashMap<>();
		for (List<String> path : paths)
		{
			String position = path.get(0);
			String destination = path.get(1);
			List<String> destinations = graph.getOrDefault(position, new ArrayList<>());
			destinations.add(destination);
			graph.put(position, destinations);
			if (!graph.containsKey(destination))
			{
				graph.put(destination, new ArrayList<>());
			}
		}

		for (Map.Entry<String, List<String>> entry : graph.entrySet())
		{
			if (entry.getValue().isEmpty())
			{
				return entry.getKey();
			}
		}

		return "";
	}

	public static void main(String[] args)
	{
		System.out.println(new DestinationCity().destCity(Arrays.asList(
				Arrays.asList("London", "New York"),
				Arrays.asList("New York", "Lima"),
				Arrays.asList("Lima", "Sao Paulo")
		)));
	}
}
