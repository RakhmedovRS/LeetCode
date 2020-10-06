import common.LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 10/6/2020
 */
@LeetCode(id = 895, name = "Maximum Frequency Stack", url = "https://leetcode.com/problems/maximum-frequency-stack/")
public class MaximumFrequencyStack
{
	class Entry
	{
		int count;
		LinkedList<Integer> freqList = new LinkedList<>();
	}

	class FreqStack
	{
		Map<Integer, Entry> map;
		PriorityQueue<Integer> maxHeap;
		int counter;

		public FreqStack()
		{
			counter = 0;
			map = new HashMap<>();
			maxHeap = new PriorityQueue<>((a, b) ->
			{
				if (map.get(a).count == map.get(b).count)
				{
					return map.get(b).freqList.getFirst() - map.get(a).freqList.getFirst();
				}

				return map.get(b).count - map.get(a).count;
			});
		}

		public void push(int x)
		{
			Entry entry;
			if (map.containsKey(x))
			{
				maxHeap.remove(x);
				entry = map.get(x);
				entry.count++;
				entry.freqList.addFirst(counter);
				maxHeap.add(x);
			}
			else
			{
				entry = new Entry();
				entry.count = 1;
				entry.freqList.addFirst(counter);
				map.put(x, entry);
				maxHeap.add(x);
			}

			counter++;
		}

		public int pop()
		{
			int val = maxHeap.remove();
			Entry entry = map.remove(val);
			entry.count--;
			entry.freqList.removeFirst();

			if (!entry.freqList.isEmpty())
			{
				map.put(val, entry);
				maxHeap.add(val);
			}

			return val;
		}
	}
}
