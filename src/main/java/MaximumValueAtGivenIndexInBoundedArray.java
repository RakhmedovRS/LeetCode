import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 3/21/2021
 */
@LeetCode(
	id = 1802,
	name = "Maximum Value at a Given Index in a Bounded Array",
	url = "https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/",
	difficulty = Difficulty.MEDIUM
)
public class MaximumValueAtGivenIndexInBoundedArray
{
	public int maxValue(int n, int index, int maxSum)
	{
		int round = 0;
		int result = 1;
		maxSum -= n;
		while (maxSum >= 0)
		{
			maxSum -= 1 + Math.min(round, index) + Math.min(round, n - 1 - index);
			round++;
			if (maxSum < 0)
			{
				return result;
			}
			result++;

			if (round >= index && round >= n - 1 - index)
			{
				result += maxSum / n;
				break;
			}
		}

		return result;
	}

	public static void main(String[] args)
	{
		MaximumValueAtGivenIndexInBoundedArray clazz = new MaximumValueAtGivenIndexInBoundedArray();
		System.out.println(clazz.maxValue(1, 0, 780055968));
		System.out.println(clazz.maxValue(2, 0, 585718607));
		System.out.println(clazz.maxValue(4, 0, 4));
		System.out.println(clazz.maxValue(3, 2, 18));
		System.out.println(clazz.maxValue(4, 2, 6));
		System.out.println(clazz.maxValue(6, 1, 10));
	}
}
