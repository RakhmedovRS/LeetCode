import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 03-May-20
 */
@LeetCode(id = 383, name = "Ransom Note", url = "https://leetcode.com/problems/ransom-note/")
public class RansomNote
{
	public boolean canConstruct(String ransomNote, String magazine)
	{
		if (ransomNote == null || magazine == null)
		{
			return false;
		}

		int[] cache = new int[26];
		for (char ch : ransomNote.toCharArray())
		{
			cache[ch - 'a']--;
		}

		for (char ch : magazine.toCharArray())
		{
			cache[ch - 'a']++;
		}

		for (int value : cache)
		{
			if (value < 0)
			{
				return false;
			}
		}

		return true;
	}
}
