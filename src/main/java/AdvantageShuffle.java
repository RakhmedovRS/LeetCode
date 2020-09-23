import common.LeetCode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author RakhmedovRS
 * @created 23-Sep-20
 */
@LeetCode(id = 870, name = "Advantage Shuffle", url = "https://leetcode.com/problems/advantage-shuffle/")
public class AdvantageShuffle
{
	public int[] advantageCount(int[] A, int[] B)
	{
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int num : A)
		{
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		Map.Entry<Integer, Integer> entry;
		boolean[] set = new boolean[A.length];
		for (int i = 0; i < B.length; i++)
		{
			entry = map.ceilingEntry(B[i] + 1);
			if (entry != null)
			{
				A[i] = entry.getKey();
				set[i] = true;
				map.remove(entry.getKey());
				if (entry.getValue() - 1 > 0)
				{
					map.put(entry.getKey(), entry.getValue() - 1);
				}
			}
		}

		for (int i = 0; i < set.length; i++)
		{
			if (!set[i])
			{
				entry = map.firstEntry();
				A[i] = entry.getKey();
				map.remove(entry.getKey());
				if (entry.getValue() - 1 > 0)
				{
					map.put(entry.getKey(), entry.getValue() - 1);
				}
			}
		}

		return A;
	}
}
