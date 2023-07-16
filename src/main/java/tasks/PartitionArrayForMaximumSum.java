package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12-Sep-20
 */
@LeetCode(id = 1043, name = "Partition Array for Maximum Sum", url = "https://leetcode.com/problems/partition-array-for-maximum-sum/")
public class PartitionArrayForMaximumSum
{
	public int maxSumAfterPartitioning(int[] numbers, int length)
	{
		return dfs(numbers, 0, length, new Integer[numbers.length][length + 1]);
	}

	private int dfs(int[] numbers, int pos, int length, Integer[][] memo)
	{
		if (pos >= numbers.length)
		{
			return 0;
		}

		if (memo[pos][length] != null)
		{
			return memo[pos][length];
		}

		memo[pos][length] = 0;

		for (int i = pos, len = length; i < numbers.length && len > 0; i++, len--)
		{
			memo[pos][length] = Math.max(memo[pos][length], calcSubArraySum(numbers, pos, i) + dfs(numbers, i + 1, length, memo));
		}

		return memo[pos][length];
	}

	private int calcSubArraySum(int[] numbers, int startPos, int endPos)
	{
		int max = 0;
		for (int i = startPos; i <= endPos; i++)
		{
			max = Math.max(max, numbers[i]);
		}

		return max * (1 + endPos - startPos);
	}

	public static void main(String[] args)
	{

		System.out.println(new PartitionArrayForMaximumSum().maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
		System.out.println(new PartitionArrayForMaximumSum().maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4));
		System.out.println(new PartitionArrayForMaximumSum().maxSumAfterPartitioning(new int[]{
				20779, 436849, 274670, 543359, 569973, 280711, 252931, 424084, 361618, 430777,
				136519, 749292, 933277, 477067, 502755, 695743, 413274, 168693, 368216, 677201,
				198089, 927218, 633399, 427645, 317246, 403380, 908594, 854847, 157024, 719715,
				336407, 933488, 599856, 948361, 765131, 335089, 522119, 403981, 866323, 519161,
				109154, 349141, 764950, 558613, 692211}, 26));
	}
}
