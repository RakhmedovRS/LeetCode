package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 11/16/2020
 */
@LeetCode(
	id = 1354,
	name = "Construct Target Array With Multiple Sums",
	url = "https://leetcode.com/problems/construct-target-array-with-multiple-sums/",
	difficulty = Difficulty.HARD
)
public class ConstructTargetArrayWithMultipleSums
{
	public boolean isPossible(int[] target)
	{
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		long sum = 0;
		for (int val : target)
		{
			maxHeap.add(val);
			sum += val;
		}

		long curr;
		long prev;
		while (sum > 1 && maxHeap.peek() > sum / 2)
		{
			curr = maxHeap.remove();
			sum -= curr;
			if (curr == 1 || sum == 1)
			{
				return true;
			}

			if (curr < sum || sum == 0 || curr % sum == 0)
			{
				return false;
			}

			prev = curr % sum;
			sum += prev;
			maxHeap.add((int) prev);
		}

		return sum == target.length;
	}
}
