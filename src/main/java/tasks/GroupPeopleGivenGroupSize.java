package tasks;

import common.LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 09-Feb-20
 */
@LeetCode(id = 1282, name = "Group the People Given the Group Size They Belong To", url = "https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/")
public class GroupPeopleGivenGroupSize
{
	public List<List<Integer>> groupThePeople(int[] groupSizes)
	{
		Map<Integer, List<List<Integer>>> groups = new HashMap<>();
		for (int i = 0; i < groupSizes.length; i++)
		{
			List<List<Integer>> group = groups.getOrDefault(groupSizes[i], new LinkedList<>());
			if (group.isEmpty())
			{
				List<Integer> temp = new LinkedList<>();
				temp.add(i);
				group.add(temp);
			}
			else
			{
				boolean added = false;
				for (List<Integer> subGroup : group)
				{
					if (subGroup.size() != groupSizes[i])
					{
						subGroup.add(i);
						added = true;
						break;
					}
				}

				if (!added)
				{
					List<Integer> subGroup = new LinkedList<>();
					subGroup.add(i);
					group.add(subGroup);
				}
			}

			groups.putIfAbsent(groupSizes[i], group);
		}

		List<List<Integer>> result = new LinkedList<>();
		for (List<List<Integer>> group : groups.values())
		{
			result.addAll(group);
		}

		return result;
	}

	public static void main(String[] args)
	{
		System.out.println(new GroupPeopleGivenGroupSize().groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3}));
		System.out.println(new GroupPeopleGivenGroupSize().groupThePeople(new int[]{2, 1, 3, 3, 3, 2}));
	}
}
