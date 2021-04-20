package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 13-Aug-20
 */
@LeetCode(id = 1311, name = "Get Watched Videos by Your Friends", url = "https://leetcode.com/problems/get-watched-videos-by-your-friends/")
public class GetWatchedVideosByYourFriends
{
	public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level)
	{
		Map<String, Integer> freqMap = new HashMap<>();
		Set<Integer> visited = new HashSet<>();
		visited.add(id);
		Queue<Integer> queue = new LinkedList<>();
		for (int friendId : friends[id])
		{
			queue.add(friendId);
		}
		int currentLevel = 1;
		int size;
		while (!queue.isEmpty() && currentLevel <= level)
		{
			size = queue.size();
			while (size-- > 0)
			{
				int currentId = queue.remove();
				if (!visited.add(currentId))
				{
					continue;
				}
				int[] current = friends[currentId];
				if (currentLevel == level)
				{
					for (String video : watchedVideos.get(currentId))
					{
						freqMap.put(video, freqMap.getOrDefault(video, 0) + 1);
					}
				}

				if (currentLevel + 1 <= level)
				{
					for (int nextId : current)
					{
						if (!visited.contains(nextId))
						{
							queue.add(nextId);
						}
					}
				}
			}

			currentLevel++;
		}

		PriorityQueue<String> minHeap = new PriorityQueue<>((video1, video2) ->
		{
			if (freqMap.get(video1).equals(freqMap.get(video2)))
			{
				return video1.compareTo(video2);
			}

			return freqMap.get(video1) - freqMap.get(video2);
		});
		minHeap.addAll(freqMap.keySet());

		List<String> answer = new ArrayList<>(minHeap.size());
		while (!minHeap.isEmpty())
		{
			answer.add(minHeap.remove());
		}

		return answer;
	}
}
