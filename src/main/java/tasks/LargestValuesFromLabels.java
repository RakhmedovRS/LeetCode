package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 3/15/2021
 */
@LeetCode(
	id = 1090,
	name = "Largest Values From Labels",
	url = "https://leetcode.com/problems/largest-values-from-labels/",
	difficulty = Difficulty.MEDIUM
)
public class LargestValuesFromLabels
{
	public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit)
	{
		Map<Integer, PriorityQueue<Integer>> labelsToValues = new HashMap<>();
		for (int i = 0; i < values.length; i++)
		{
			labelsToValues.putIfAbsent(labels[i], new PriorityQueue<>(Comparator.reverseOrder()));
			labelsToValues.get(labels[i]).add(values[i]);
		}

		int sum = 0;
		PriorityQueue<Integer> sortedLabels = new PriorityQueue<>((a, b) -> labelsToValues.get(b).peek() - labelsToValues.get(a).peek());
		sortedLabels.addAll(labelsToValues.keySet());

		int[] labelsUsed = new int[20_001];
		int label;
		PriorityQueue<Integer> pq;
		while (num_wanted-- > 0 && !sortedLabels.isEmpty())
		{
			label = sortedLabels.remove();
			pq = labelsToValues.remove(label);
			sum += pq.remove();
			labelsUsed[label]++;

			if (!pq.isEmpty() && labelsUsed[label] < use_limit)
			{
				labelsToValues.put(label, pq);
				sortedLabels.add(label);
			}
		}

		return sum;
	}
}
