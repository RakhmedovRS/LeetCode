package tasks;

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
public class KillProcess {
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		Set<Integer> killed = new HashSet<>();
		Map<Integer, List<Integer>> parents = new HashMap<>();
		for (int i = 0; i < pid.size(); i++) {
			parents.putIfAbsent(pid.get(i), new ArrayList<>());
			if (ppid.get(i) != 0) {
				parents.putIfAbsent(ppid.get(i), new ArrayList<>());
				parents.get(ppid.get(i)).add(pid.get(i));
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(kill);
		int current;
		while (!queue.isEmpty()) {
			current = queue.remove();
			if (!killed.add(current)) {
				continue;
			}

			queue.addAll(parents.get(current));
		}

		return new ArrayList<>(killed);
	}
}
