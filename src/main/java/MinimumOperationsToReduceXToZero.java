import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/15/2020
 */
@LeetCode(
	id = 1658,
	name = "Minimum Operations to Reduce X to Zero",
	url = "https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/",
	difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToReduceXToZero
{
	public int minOperations(int[] nums, int x)
	{
		int sum = 0;
		int i = 0;
		int minSteps = Integer.MAX_VALUE;
		int steps = 0;
		while (i < nums.length && sum + nums[i] <= x)
		{
			sum += nums[i++];
			steps++;
		}

		if (sum == x)
		{
			minSteps = steps;
		}

		i = i == 0 ? nums.length - 1 : i - 1;

		int j = nums.length - 1;
		while (j > i)
		{
			while (sum < x && j > i)
			{
				sum += nums[j--];
				steps++;
			}

			while (sum >= x)
			{
				if (sum == x)
				{
					minSteps = Math.min(minSteps, steps);
				}
				sum -= nums[i--];
				steps--;
				if (i == -1)
				{
					i = nums.length - 1;
				}
			}
		}

		return minSteps == Integer.MAX_VALUE ? -1 : minSteps;
	}

	public static void main(String[] args)
	{
		System.out.println(new MinimumOperationsToReduceXToZero().minOperations(new int[]{5, 2, 3, 1, 1}, 5)); //1
		System.out.println(new MinimumOperationsToReduceXToZero().minOperations(new int[]{1, 1}, 3)); //-1
		System.out.println(new MinimumOperationsToReduceXToZero().minOperations(new int[]{5, 6, 7, 8, 9}, 4)); //-1
		System.out.println(new MinimumOperationsToReduceXToZero().minOperations(new int[]{1, 1, 3, 2, 5}, 5)); //1
		System.out.println(new MinimumOperationsToReduceXToZero().minOperations(new int[]{1, 1, 4, 2, 3}, 5)); //2
		System.out.println(new MinimumOperationsToReduceXToZero().minOperations(new int[]{
			8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309}, 134365)); //16
		System.out.println(new MinimumOperationsToReduceXToZero().minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10)); //5
	}
}
