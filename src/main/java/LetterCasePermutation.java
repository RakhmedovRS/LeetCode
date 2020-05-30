import common.LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 30-May-20
 */
@LeetCode(id = 784, name = "Letter Case Permutation", url = "https://leetcode.com/problems/letter-case-permutation/")
public class LetterCasePermutation
{
	public List<String> letterCasePermutation(String S)
	{
		LinkedList<String> permutations = new LinkedList<>();
		if (S == null || S.isEmpty())
		{
			return permutations;
		}
		permutations.add("");

		char[] chars = S.toCharArray();
		for (char ch : chars)
		{
			int size = permutations.size();
			while (size-- > 0)
			{
				String s = permutations.removeLast();
				if (Character.isDigit(ch))
				{
					permutations.addFirst(s + ch);
				}
				else
				{
					permutations.addFirst(s + Character.toLowerCase(ch));
					permutations.addFirst(s + Character.toUpperCase(ch));
				}
			}
		}

		return permutations;
	}

	public static void main(String[] args)
	{
		System.out.println(new LetterCasePermutation().letterCasePermutation("a1b2"));
	}
}
