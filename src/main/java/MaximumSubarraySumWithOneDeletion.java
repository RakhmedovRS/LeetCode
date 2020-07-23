import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 23-Jul-20
 */
@LeetCode(id = 1186, name = "Maximum Subarray Sum with One Deletion", url = "https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/")
public class MaximumSubarraySumWithOneDeletion
{
	public int maximumSum(int[] arr)
	{
		int max = arr[0];
		int[] del = new int[arr.length];
		int[] keep = new int[arr.length];
		del[0] = keep[0] = arr[0];
		for (int i = 1; i < arr.length; i++)
		{
			keep[i] = Math.max(keep[i - 1], 0) + arr[i];
			del[i] = Math.max(keep[i - 1], del[i - 1] + arr[i]);
			max = Math.max(max, Math.max(keep[i], del[i]));
		}

		return max;
	}
}
