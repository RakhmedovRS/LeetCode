import common.LeetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 29-Jun-20
 */
@LeetCode(id = 841, name = "Keys and Rooms", url = "https://leetcode.com/problems/keys-and-rooms/")
public class KeysAndRooms
{
	public boolean canVisitAllRooms(List<List<Integer>> rooms)
	{
		Set<Integer> visited = new HashSet<>();
		traverse(rooms, 0, visited);
		return visited.size() == rooms.size();
	}

	private void traverse(List<List<Integer>> rooms, int position, Set<Integer> visited)
	{
		if (!visited.add(position))
		{
			return;
		}

		for (int nextPosition : rooms.get(position))
		{
			traverse(rooms, nextPosition, visited);
		}
	}
}
