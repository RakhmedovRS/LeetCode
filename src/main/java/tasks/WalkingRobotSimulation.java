package tasks;

import common.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 17-Jul-20
 */
@LeetCode(id = 874, name = "Walking Robot Simulation", url = "https://leetcode.com/problems/walking-robot-simulation/")
public class WalkingRobotSimulation {
	public int robotSim(int[] commands, int[][] obstacles) {
		int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		Map<Integer, Set<Integer>> xY = new HashMap<>();
		for (int[] obstacle : obstacles) {
			Set<Integer> ys = xY.getOrDefault(obstacle[0], new HashSet<>());
			ys.add(obstacle[1]);
			xY.put(obstacle[0], ys);
		}

		int x = 0;
		int y = 0;
		int direction = 0;
		int max = 0;
		for (int command : commands) {
			if (command > 0) {
				while (command > 0) {
					int[] dir = directions[direction];
					x += dir[0];
					y += dir[1];
					if (xY.containsKey(x) && xY.get(x).contains(y)) {
						x -= dir[0];
						y -= dir[1];
						break;
					}
					max = Math.max(max, x * x + y * y);
					command--;
				}
			}
			else if (command < 0) {
				direction += command == -1 ? 1 : 3;
				direction %= 4;
			}
		}

		return max;
	}
}
