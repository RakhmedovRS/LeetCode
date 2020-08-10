import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10-Aug-20
 */
@LeetCode(id = 1343, name = "Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold", url = "https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/")
public class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold
{
	public int numOfSubarrays(int[] arr, int k, int threshold)
	{
		int left = 0;
		int right = k - 1;
		int sum = 0;
		for (int i = 0; i < k; i++)
		{
			sum += arr[i];
		}

		int count = 0;
		while (right < arr.length)
		{
			if (sum / k >= threshold)
			{
				count++;
			}
			sum -= arr[left++];
			right++;
			if (right < arr.length)
			{
				sum += arr[right];
			}
		}

		return count;
	}
}
