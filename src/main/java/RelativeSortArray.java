import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 23-Jun-20
 */
@LeetCode(id = 1122, name = "Relative Sort Array", url = "https://leetcode.com/problems/relative-sort-array/")
public class RelativeSortArray
{
	public int[] relativeSortArray(int[] arr1, int[] arr2)
	{
		int[] answer = new int[arr1.length];
		int pos = 0;

		Set<Integer> values = new HashSet<>();
		for (int num : arr2)
		{
			values.add(num);
		}

		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> unused = new ArrayList<>();
		for (int num : arr1)
		{
			if (values.contains(num))
			{
				map.put(num, map.getOrDefault(num, 0) + 1);
			}
			else
			{
				unused.add(num);
			}
		}

		for (int num : arr2)
		{
			int count = map.remove(num);
			while (count-- > 0)
			{
				answer[pos++] = num;
			}
		}

		unused.sort(Comparator.naturalOrder());
		for (int num : unused)
		{
			answer[pos++] = num;
		}

		return answer;
	}
}
