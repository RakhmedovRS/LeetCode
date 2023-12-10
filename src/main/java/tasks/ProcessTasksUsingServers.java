package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 5/30/2021
 */
@LeetCode(
		id = 1882,
		name = "Process Tasks Using Servers",
		url = "https://leetcode.com/problems/process-tasks-using-servers/",
		difficulty = Difficulty.MEDIUM
)
public class ProcessTasksUsingServers {
	class Server {
		int weight;
		int index;
		int nextFree;

		public Server(int weight, int index, int nextFree) {
			this.weight = weight;
			this.index = index;
			this.nextFree = nextFree;
		}

		public int getNextFree() {
			return nextFree;
		}
	}

	public int[] assignTasks(int[] servers, int[] tasks) {
		PriorityQueue<Server> free = new PriorityQueue<>((a, b) ->
		{
			if (a.weight == b.weight) {
				return a.index - b.index;
			}
			else {
				return a.weight - b.weight;
			}
		});

		PriorityQueue<Server> busy = new PriorityQueue<>(Comparator.comparingInt(Server::getNextFree));

		for (int i = 0; i < servers.length; i++) {
			free.add(new Server(servers[i], i, 0));
		}

		int[] answer = new int[tasks.length];
		int time = 0;
		for (int i = 0; i < tasks.length; ) {
			time = Math.max(time, i);

			while (!busy.isEmpty() && busy.peek().nextFree <= time) {
				Server server = busy.remove();
				free.add(server);
			}

			if (free.isEmpty()) {
				time = busy.peek().nextFree;
				continue;
			}

			Server server = free.remove();
			answer[i] = server.index;
			server.nextFree = time + tasks[i];
			busy.add(server);
			i++;
		}

		return answer;
	}
}
