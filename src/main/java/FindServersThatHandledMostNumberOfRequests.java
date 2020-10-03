import common.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author RakhmedovRS
 * @created 10/3/2020
 */
@LeetCode(id = 1606, name = "Find Servers That Handled Most Number of Requests", url = "https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/")
public class FindServersThatHandledMostNumberOfRequests
{
	public List<Integer> busiestServers(int k, int[] arrival, int[] load)
	{
		List<Integer> answer = new ArrayList<>();
		int[] servers = new int[k];
		int[] loads = new int[k];
		int max = 0;
		TreeSet<Integer> freeServers = new TreeSet<>();
		PriorityQueue<Integer> busyServers = new PriorityQueue<>((a, b) -> servers[a] - servers[b]);
		for (int i = 0; i < k; i++)
		{
			freeServers.add(i);
		}

		Integer index;
		for (int i = 0; i < arrival.length; i++)
		{
			while (!busyServers.isEmpty() && servers[busyServers.peek()] <= arrival[i])
			{
				freeServers.add(busyServers.remove());
			}

			if (freeServers.isEmpty())
			{
				continue;
			}

			index = freeServers.ceiling(i % k);
			index = index == null ? freeServers.first() : index;
			servers[index] = arrival[i] + load[i];
			loads[index]++;
			busyServers.add(index);
			freeServers.remove(index);
			max = Math.max(max, loads[index]);
		}

		for (int i = 0; i < loads.length; i++)
		{
			if (loads[i] == max)
			{
				answer.add(i);
			}
		}

		return answer;
	}

	public static void main(String[] args)
	{
		System.out.println(new FindServersThatHandledMostNumberOfRequests().busiestServers(3, new int[]{1, 2, 3, 4, 5}, new int[]{5, 2, 3, 3, 3}));
	}
}
