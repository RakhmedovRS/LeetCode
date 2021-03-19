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
		Set<Integer> visitedRooms = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		visitedRooms.add(0);

		int currentRoom;
		while (!queue.isEmpty())
		{
			currentRoom = queue.remove();
			for (int nextRoom : rooms.get(currentRoom))
			{
				if (visitedRooms.add(nextRoom))
				{
					queue.add(nextRoom);
				}
			}
		}

		return visitedRooms.size() == rooms.size();
	}
}
