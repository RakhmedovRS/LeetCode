import common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 20-Jul-20
 */
@LeetCode(id = 1054, name = "Distant Barcodes", url = "https://leetcode.com/problems/distant-barcodes/")
public class DistantBarcodes
{
	public int[] rearrangeBarcodes(int[] barcodes)
	{
		Map<Integer, Integer> numToCount = new HashMap<>();
		for (int barcode : barcodes)
		{
			numToCount.put(barcode, numToCount.getOrDefault(barcode, 0) + 1);
		}

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((b1, b2) -> numToCount.get(b2) - numToCount.get(b1));
		maxHeap.addAll(numToCount.keySet());

		int i = 0;
		int[] answer = new int[barcodes.length];
		while (!maxHeap.isEmpty())
		{
			if (maxHeap.size() > 1)
			{
				int a = maxHeap.remove();
				int b = maxHeap.remove();
				int countA = numToCount.remove(a);
				int countB = numToCount.remove(b);
				answer[i++] = a;
				answer[i++] = b;
				if (--countA > 0)
				{
					numToCount.put(a, countA);
					maxHeap.add(a);
				}
				if (--countB > 0)
				{
					numToCount.put(b, countB);
					maxHeap.add(b);
				}
			}
			else
			{
				int a = maxHeap.remove();
				int count = numToCount.remove(a);
				answer[i++] = a;
				if (--count > 0)
				{
					numToCount.put(a, count);
					maxHeap.add(a);
				}
			}
		}

		return answer;
	}
}
