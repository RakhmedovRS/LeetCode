package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 26-May-20
 */
@LeetCode(id = 1013, name = "Partition Array Into Three Parts With Equal Sum", url = "https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/")
public class PartitionArrayIntoThreePartsWithEqualSum
{
	public boolean canThreePartsEqualSum(int[] A)
	{
		if (A == null || A.length < 3)
		{
			return false;
		}

		int sum = Arrays.stream(A).sum();
		if (sum % 3 != 0)
		{
			return false;
		}
		int target = sum / 3;
		int buckets = 0;
		int currentSum = 0;
		for (int value : A)
		{
			currentSum += value;
			if (currentSum == target)
			{
				buckets++;
				currentSum = 0;
			}
		}

		return buckets >= 3 && currentSum == 0;
	}
}
