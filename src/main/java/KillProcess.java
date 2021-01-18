import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 1/18/2021
 */
@LeetCode(
	id = 582,
	name = "Kill Process",
	url = "https://leetcode.com/problems/kill-process/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class KillProcess
{
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill)
	{
		List<Integer> answer = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		int parentId;
		int id;
		for (int i = 0; i < pid.size(); i++)
		{
			parentId = ppid.get(i);
			id = pid.get(i);

			map.putIfAbsent(parentId, new ArrayList<>());
			map.get(parentId).add(id);
		}

		killProcess(kill, map, answer);

		return answer;
	}

	private void killProcess(int pid, Map<Integer, List<Integer>> map, List<Integer> answer)
	{
		answer.add(pid);
		for (int childPid : map.getOrDefault(pid, Collections.emptyList()))
		{
			killProcess(childPid, map, answer);
		}
	}
}
