package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 11/11/2023
 */
@LeetCode(
		id = 2933,
		name = "High-Access Employees",
		url = "https://leetcode.com/problems/high-access-employees/",
		difficulty = Difficulty.MEDIUM
)
public class HighAccessEmployees
{
	public List<String> findHighAccessEmployees(List<List<String>> access_times)
	{
		Map<String, List<Integer>> map = new HashMap<>();
		for (List<String> list : access_times)
		{
			String emp = list.get(0);
			String stime = list.get(1);
			Integer time = Integer.parseInt(stime.substring(0, 2), 10) * 60 + Integer.parseInt(stime.substring(2, 4));
			map.putIfAbsent(emp, new ArrayList<>());
			map.get(emp).add(time);
		}

		List<String> ans = new ArrayList<>();
		outer:
		for (Map.Entry<String, List<Integer>> entry : map.entrySet())
		{
			String emp = entry.getKey();
			List<Integer> t = entry.getValue();
			t.sort(null);

			LinkedList<Integer> list = new LinkedList<>();
			for (int time : t)
			{
				while (!list.isEmpty() && time - list.getFirst() >= 60)
				{
					list.removeFirst();
				}

				list.addLast(time);
				if (list.size() >= 3)
				{
					ans.add(emp);
					continue outer;
				}
			}


		}

		return ans;
	}
}
