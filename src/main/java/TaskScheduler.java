import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 11-Apr-20
 */
@LeetCode(id = 621, name = "Task Scheduler", url = "https://leetcode.com/problems/task-scheduler/")
public class TaskScheduler
{
	public int leastInterval(char[] tasks, int n)
	{
		if (tasks == null || tasks.length == 0)
		{
			return 0;
		}

		Map<Character, Integer> memo = new HashMap<>();
		for (char ch : tasks)
		{
			memo.put(ch, memo.getOrDefault(ch, 0) + 1);
		}

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		maxHeap.addAll(memo.values());
		int counter = 0;
		while (!maxHeap.isEmpty())
		{
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i <= n; i++)
			{
				if (!maxHeap.isEmpty())
				{
					temp.add(maxHeap.remove());
				}
			}

			for (int i : temp)
			{
				if (--i > 0)
				{
					maxHeap.add(i);
				}
			}
			counter += maxHeap.isEmpty() ? temp.size() : n + 1;
		}
		return counter;
	}

	public static void main(String[] args)
	{
		System.out.println(new TaskScheduler().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
	}
}
