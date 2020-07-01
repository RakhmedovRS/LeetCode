import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 01-Jul-20
 */
@LeetCode(id = 1461, name = "Check If a String Contains All Binary Codes of Size K", url = "https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/")
public class CheckIfStringContainsAllBinaryCodesOfSizeK
{
	public boolean hasAllCodes(String s, int k)
	{
		int left = 0;
		int right = k;
		Set<String> numbers = new HashSet<>();
		while (right <= s.length())
		{
			numbers.add(s.substring(left++, right++));
		}

		return numbers.size() == Math.pow(2, k);
	}
}
