import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 29-Jun-20
 */
@LeetCode(
	id = 841,
	name = "Keys and Rooms",
	url = "https://leetcode.com/problems/keys-and-rooms/",
	difficulty = Difficulty.MEDIUM
)
public class KeysAndRooms
{
	public boolean canVisitAllRooms(List<List<Integer>> rooms)
	{
		int requiredToVisit = rooms.size();
		boolean[] visited = new boolean[requiredToVisit];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		requiredToVisit--;
		visited[0] = true;

		int currentRoom;
		while (!queue.isEmpty())
		{
			currentRoom = queue.remove();
			for (int nextRoom : rooms.get(currentRoom))
			{
				if (!visited[nextRoom])
				{
					queue.add(nextRoom);
					requiredToVisit--;
					visited[nextRoom] = true;
				}
			}
		}

		return requiredToVisit == 0;
	}
}
