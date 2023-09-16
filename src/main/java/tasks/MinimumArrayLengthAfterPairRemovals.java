package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Ruslan Rakhmedov
 * @created 9/16/2023
 */
@LeetCode(
		id = 2856,
		name = "Minimum Array Length After Pair Removals",
		url = "https://leetcode.com/problems/minimum-array-length-after-pair-removals/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumArrayLengthAfterPairRemovals
{
	public int minLengthAfterRemovals(List<Integer> nums)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums)
		{
			map.put(n, map.getOrDefault(n, 0) + 1);
		}

		TreeSet<Integer> pq = new TreeSet<>((a, b) ->
		{
			if (map.containsKey(a) && map.containsKey(b) && map.get(a).equals(map.get(b)))
			{
				return a - b;
			}
			else if (map.containsKey(a) && map.containsKey(b))
			{
				return map.get(b) - map.get(a);
			}

			if (map.containsKey(a))
			{
				return -1;
			}

			return 1;
		});

		pq.addAll(map.keySet());

		int count = nums.size();
		int skip = 0;
		while (pq.size() > 1)
		{
			int curr = pq.first();
			pq.remove(curr);
			if (!map.containsKey(curr))
			{
				continue;
			}

			count--;

			if (map.get(curr) == 1)
			{
				map.remove(curr);
			}
			else
			{
				map.put(curr, map.get(curr) - 1);
			}

			Integer left = pq.floor(curr - 1);
			Integer right = pq.ceiling(curr + 1);
			if (left != null && right != null)
			{
				count--;
				int lC = map.get(left);
				int rC = map.get(right);
				if (lC >= rC)
				{
					pq.remove(left);
					if (map.get(left) == 1)
					{
						map.remove(left);
					}
					else
					{
						map.put(left, map.get(left) - 1);
						pq.add(left);
					}
				}
				else
				{
					pq.remove(right);
					if (map.get(right) == 1)
					{
						map.remove(right);
					}
					else
					{
						map.put(right, map.get(right) - 1);
						pq.add(right);
					}
				}
			}
			else if (left != null)
			{
				count--;
				pq.remove(left);
				if (map.get(left) == 1)
				{
					map.remove(left);
				}
				else
				{
					map.put(left, map.get(left) - 1);
					pq.add(left);
				}
			}
			else if (right != null)
			{
				count--;
				pq.remove(right);
				if (map.get(right) == 1)
				{
					map.remove(right);
				}
				else
				{
					map.put(right, map.get(right) - 1);
					pq.add(right);
				}
			}
			else
			{
				skip++;
			}

			if (map.containsKey(curr))
			{
				pq.add(curr);
			}
		}

		return count + skip;
	}
}
