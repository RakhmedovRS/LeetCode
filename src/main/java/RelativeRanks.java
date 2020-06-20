import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 20-Jun-20
 */
@LeetCode(id = 506, name = "Relative Ranks", url = "https://leetcode.com/problems/relative-ranks/")
public class RelativeRanks
{
	public String[] findRelativeRanks(int[] nums)
	{
		int pos = 0;
		String[] places = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
		int[][] numsAndPos = new int[nums.length][];
		for (int i = 0; i < nums.length; i++)
		{
			numsAndPos[i] = new int[]{nums[i], i};
		}

		Arrays.sort(numsAndPos, (arr1, arr2) ->
		{
			if (arr1[0] == arr2[0])
			{
				return arr1[1] - arr2[1];
			}
			return arr2[0] - arr1[0];
		});

		String[] result = new String[nums.length];

		int prev = numsAndPos[0][0];
		for (int[] numsAndPo : numsAndPos)
		{
			if (numsAndPo[0] != prev)
			{
				pos++;
				prev = numsAndPo[0];
			}
			result[numsAndPo[1]] = pos < 3 ? places[pos] : String.valueOf(pos + 1);
		}

		return result;
	}

	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(new RelativeRanks().findRelativeRanks(new int[]{1, 2, 3, 4, 5})));
		System.out.println(Arrays.toString(new RelativeRanks().findRelativeRanks(new int[]{10, 3, 8, 9, 4})));
		System.out.println(Arrays.toString(new RelativeRanks().findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
	}
}
