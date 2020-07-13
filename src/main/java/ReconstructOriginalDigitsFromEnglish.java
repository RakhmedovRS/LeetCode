import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 13-Jul-20
 */
@LeetCode(id = 423, name = "Reconstruct Original Digits from English", url = "https://leetcode.com/problems/reconstruct-original-digits-from-english/")
public class ReconstructOriginalDigitsFromEnglish
{
	public String originalDigits(String s)
	{
		int[] nums = new int[10];
		int[] chars = new int[128];
		for (char ch : s.toCharArray())
		{
			chars[ch]++;
		}
		nums[0] = chars['z'];
		nums[2] = chars['w'];
		nums[4] = chars['u'];
		nums[6] = chars['x'];
		nums[8] = chars['g'];
		nums[1] = chars['o'] - nums[0] - nums[2] - nums[4];
		nums[3] = chars['r'] - nums[0] - nums[4];
		nums[5] = chars['f'] - nums[4];
		nums[7] = chars['s'] - nums[6];
		nums[9] = chars['i'] - nums[5] - nums[6] - nums[8];
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < 10; ++i)
		{
			if (nums[i] > 0)
			{
				char[] arr = new char[nums[i]];
				Arrays.fill(arr, (char) (i + '0'));
				ret.append(String.valueOf(arr));
			}
		}
		return ret.toString();
	}
}
