import common.LeetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author RakhmedovRS
 * @created 07-Apr-20
 */
@LeetCode(id = 17, name = "Letter Combinations of a Phone Number", url = "https://leetcode.com/problems/letter-combinations-of-a-phone-number/")
public class LetterCombinationsOfPhoneNumber
{
	private Map<Character, List<Character>> getDictionary()
	{
		Map<Character, List<Character>> dictionary = new HashMap<>();
		dictionary.put('2', Arrays.asList('a', 'b', 'c'));
		dictionary.put('3', Arrays.asList('d', 'e', 'f'));
		dictionary.put('4', Arrays.asList('g', 'h', 'i'));
		dictionary.put('5', Arrays.asList('j', 'k', 'l'));
		dictionary.put('6', Arrays.asList('m', 'n', 'o'));
		dictionary.put('7', Arrays.asList('p', 'q', 'r', 's'));
		dictionary.put('8', Arrays.asList('t', 'u', 'v'));
		dictionary.put('9', Arrays.asList('w', 'x', 'y', 'z'));
		return dictionary;
	}

	public List<String> letterCombinations(String digits)
	{
		if (digits == null || digits.length() == 0)
		{
			return new ArrayList<>();
		}
		Map<Character, List<Character>> dictionary = getDictionary();
		LinkedList<StringBuilder> temp = new LinkedList<>();
		temp.addFirst(new StringBuilder());
		for (int pos = 0; pos < digits.length(); pos++)
		{
			List<Character> list = dictionary.get(digits.charAt(pos));
			int size = temp.size();
			while (size-- > 0)
			{
				StringBuilder sample = temp.removeFirst();
				for (Character ch : list)
				{
					temp.add(new StringBuilder(sample).append(ch));
				}
			}
		}


		return temp.stream().map(StringBuilder::toString).collect(Collectors.toList());
	}
}
