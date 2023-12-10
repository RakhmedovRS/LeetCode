package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 11/13/2020
 */
@LeetCode(
		id = 1345,
		name = "Jump Game IV",
		url = "https://leetcode.com/problems/jump-game-iv/",
		difficulty = Difficulty.HARD
)
public class JumpGameIV {
	public int minJumps(int[] arr) {
		int n = arr.length;
		Map<Integer, List<Integer>> positions = new HashMap<>();
		for (int i = 0; i < n; i++) {
			positions.putIfAbsent(arr[i], new ArrayList<>());
			positions.get(arr[i]).add(i);
		}

		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		int size;
		int steps = 0;
		int current;
		int id;
		while (!queue.isEmpty()) {
			size = queue.size();
			while (size-- > 0) {
				current = queue.remove();
				if (visited[current]) {
					continue;
				}

				visited[current] = true;

				if (current == n - 1) {
					return steps;
				}

				if (current + 1 < n) {
					if (current + 1 == n - 1) {
						return steps + 1;
					}

					queue.add(current + 1);
				}

				if (current - 1 >= 0) {
					queue.add(current - 1);
				}

				List<Integer> ids = positions.get(arr[current]);
				for (int i = ids.size() - 1; i >= 0; i--) {
					id = ids.get(i);
					if (id != current) {
						if (id == n - 1) {
							return steps + 1;
						}
						queue.add(id);
					}
				}
			}
			steps++;
		}

		return n;
	}

	public static void main(String[] args) {
		JumpGameIV clazz = new JumpGameIV();
		System.out.println(clazz.minJumps(new int[]{6, 1, 9}));
		System.out.println(clazz.minJumps(new int[]{11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13}));
		System.out.println(clazz.minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
	}
}
