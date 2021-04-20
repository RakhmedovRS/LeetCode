package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 04-Apr-20
 */
@LeetCode(id = 151, name = "Reverse Words in a String", url = "https://leetcode.com/problems/reverse-words-in-a-string/")
public class ReverseWordsInString
{
	public String reverseWords(String s)
	{
		if (s == null || s.length() == 0)
		{
			return s;
		}

		List<String> words = new ArrayList<>();
		for (String word : s.split(" "))
		{
			if (!word.isEmpty())
			{
				words.add(word);
			}
		}

		int left = 0;
		int right = words.size() - 1;
		while (left < right)
		{
			String temp = words.get(left);
			words.set(left, words.get(right));
			words.set(right, temp);
			left++;
			right--;
		}

		return String.join(" ", words);
	}

	public static void main(String[] args)
	{
		System.out.println(new ReverseWordsInString().reverseWords(""));
		System.out.println(new ReverseWordsInString().reverseWords(" "));
		System.out.println(new ReverseWordsInString().reverseWords("the sky is blue"));
		System.out.println(new ReverseWordsInString().reverseWords("  hello world!  "));
	}
}
