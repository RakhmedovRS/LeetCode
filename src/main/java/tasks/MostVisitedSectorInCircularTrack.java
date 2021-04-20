package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 23-Aug-20
 */
@LeetCode(id = 1560, name = "Most Visited Sector in a Circular Track", url = "https://leetcode.com/problems/most-visited-sector-in-a-circular-track/")
public class MostVisitedSectorInCircularTrack
{
	public List<Integer> mostVisited(int n, int[] rounds)
	{
		if (rounds.length == 0)
		{
			return new ArrayList<>();
		}
		else if (rounds.length == 1)
		{
			return Arrays.asList(rounds[0]);
		}

		List<Integer> answer = new ArrayList<>();
		int[] visits = new int[n + 1];

		int maxCount = 0;
		int pos = rounds[0];
		for (int i = 1; i < rounds.length; i++)
		{
			while (pos != rounds[i])
			{
				visits[pos]++;
				maxCount = Math.max(maxCount, visits[pos]);
				pos = (pos + 1) % (n + 1);
			}

			if (i == rounds.length - 1)
			{
				visits[pos]++;
				maxCount = Math.max(maxCount, visits[pos]);
			}
		}

		for (int i = 0; i < visits.length; i++)
		{
			if (visits[i] == maxCount)
			{
				answer.add(i);
			}
		}

		return answer;
	}

	public static void main(String[] args)
	{
		System.out.println(new MostVisitedSectorInCircularTrack().mostVisited(7, new int[]{1, 3, 5, 7}));
		System.out.println(new MostVisitedSectorInCircularTrack().mostVisited(2, new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2}));
		System.out.println(new MostVisitedSectorInCircularTrack().mostVisited(4, new int[]{1, 3, 1, 2}));
	}
}
