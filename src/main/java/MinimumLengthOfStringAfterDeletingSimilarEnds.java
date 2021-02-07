
import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 2/7/2021
 */
@LeetCode(
	id = 1750,
	name = "Minimum Length of String After Deleting Similar Ends",
	url = "https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/",
	difficulty = Difficulty.MEDIUM
)
public class MinimumLengthOfStringAfterDeletingSimilarEnds
{
	public int minimumLength(String s)
	{
		LinkedList<Character> chars = new LinkedList<>();
		for (char ch : s.toCharArray())
		{
			chars.add(ch);
		}

		boolean deleted = true;
		char ch;
		while (deleted && chars.size() > 1)
		{
			deleted = false;
			ch = chars.getLast();
			while (!chars.isEmpty() && chars.getFirst() == ch)
			{
				deleted = true;
				chars.removeFirst();
			}

			while (deleted && !chars.isEmpty() && chars.getLast() == ch)
			{
				chars.removeLast();
			}
		}

		return chars.size();
	}

	public static void main(String[] args)
	{
		MinimumLengthOfStringAfterDeletingSimilarEnds clazz = new MinimumLengthOfStringAfterDeletingSimilarEnds();
		//          1                 2       3         4  5 6 7 6 5 4  3  2  1
		//bbbbbbbbbbbbbbbbbbbbbbbbbbb a bbbbbbbbbbbbbbb cc b c b c b cc bb a bbb
		System.out.println(clazz.minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
		System.out.println(clazz.minimumLength("cabaabac"));
	}
}
