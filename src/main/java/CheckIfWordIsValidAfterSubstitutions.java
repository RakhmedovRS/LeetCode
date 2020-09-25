import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 9/25/2020
 */
@LeetCode(id = 1003, name = "Check If Word Is Valid After Substitutions", url = "https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/")
public class CheckIfWordIsValidAfterSubstitutions
{
	public boolean isValid(String s)
	{
		List<Character> chars = new ArrayList<>(s.length());
		for (char ch : s.toCharArray())
		{
			if (ch == 'c' && chars.size() >= 2 &&
				chars.get(chars.size() - 1) == 'b' &&
				chars.get(chars.size() - 2) == 'a')
			{
				chars.remove(chars.size() - 1);
				chars.remove(chars.size() - 1);
			}
			else
			{
				chars.add(ch);
			}
		}

		return chars.isEmpty();
	}
}
