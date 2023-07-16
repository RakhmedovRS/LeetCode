package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 4/18/2021
 */
@LeetCode(
		id = 1834,
		name = "Single-Threaded CPU",
		url = "https://leetcode.com/problems/single-threaded-cpu/",
		difficulty = Difficulty.MEDIUM
)
public class SingleThreadedCPU
{
	public int[] getOrder(int[][] tasks)
	{
		PriorityQueue<Integer> ids = new PriorityQueue<>((id1, id2) ->
		{
			if (tasks[id1][0] == tasks[id2][0])
			{
				return id1 - id2;
			}
			return tasks[id1][0] - tasks[id2][0];
		});

		int currentTime = Integer.MAX_VALUE;
		for (int i = 0; i < tasks.length; i++)
		{
			ids.add(i);
			currentTime = Math.min(currentTime, tasks[i][0]);
		}

		PriorityQueue<Integer> cpuTasks = new PriorityQueue<>((id1, id2) ->
		{
			if (tasks[id1][1] == tasks[id2][1])
			{
				return id1 - id2;
			}
			return tasks[id1][1] - tasks[id2][1];
		});

		int[] answer = new int[tasks.length];
		for (int i = 0; i < tasks.length; i++)
		{
			while (!ids.isEmpty() && tasks[ids.peek()][0] <= currentTime)
			{
				cpuTasks.add(ids.remove());
			}

			if (cpuTasks.isEmpty())
			{
				int time = tasks[ids.peek()][0];
				while (!ids.isEmpty() && tasks[ids.peek()][0] == time)
				{
					cpuTasks.add(ids.remove());
				}
			}

			answer[i] = cpuTasks.peek();

			currentTime = Math.max(currentTime, tasks[cpuTasks.peek()][0]) + tasks[cpuTasks.peek()][1];
			cpuTasks.remove();
		}

		return answer;
	}

	public static void main(String[] args)
	{
		SingleThreadedCPU clazz = new SingleThreadedCPU();
		System.out.println(Arrays.toString(clazz.getOrder(new int[][]{{5, 6}, {9, 4}, {3, 9}, {3, 7}, {1, 1}, {6, 9}, {9, 1}})));
		System.out.println(Arrays.toString(clazz.getOrder(new int[][]{{100, 100}, {500, 100}, {1000, 100}, {10000, 100}, {100000, 100}})));
		System.out.println(Arrays.toString(clazz.getOrder(new int[][]{{5, 2}, {7, 2}, {9, 4}, {6, 3}, {5, 10}, {1, 1}})));
	}
}
