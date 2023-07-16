package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 12/25/2022
 */
@LeetCode(
		id = 2512,
		name = "Reward Top K Students",
		url = "https://leetcode.com/problems/reward-top-k-students/",
		difficulty = Difficulty.MEDIUM
)
public class RewardTopKStudents
{
	public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k)
	{
		Set<String> positive = new HashSet<>(Arrays.asList(positive_feedback));
		Set<String> negative = new HashSet<>(Arrays.asList(negative_feedback));
		Map<Integer, Long> map = new HashMap<>();
		for (int i = 0; i < report.length; i++)
		{
			int student = student_id[i];
			map.putIfAbsent(student, 0L);

			for (String s : report[i].split(" "))
			{
				if (positive.contains(s))
				{
					map.put(student, map.get(student) + 3);
				}

				if (negative.contains(s))
				{
					map.put(student, map.get(student) - 1);
				}
			}
		}

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> {
			if (map.getOrDefault(a, 0L).equals(map.getOrDefault(b, 0L)))
			{
				return b - a;
			}

			return Long.compare(map.get(a), map.get(b));
		});

		for (int student : map.keySet())
		{
			priorityQueue.add(student);
			if (priorityQueue.size() > k)
			{
				priorityQueue.remove();
			}
		}

		LinkedList<Integer> answer = new LinkedList<>();
		while (!priorityQueue.isEmpty())
		{
			answer.addFirst(priorityQueue.remove());
		}

		return answer;
	}
}
