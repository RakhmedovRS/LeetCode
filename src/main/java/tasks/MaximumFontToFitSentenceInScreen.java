package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/3/2021
 */
@LeetCode(
	id = 1618,
	name = "Maximum Font to Fit a Sentence in a Screen",
	url = "https://leetcode.com/problems/maximum-font-to-fit-a-sentence-in-a-screen/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class MaximumFontToFitSentenceInScreen
{
	interface FontInfo
	{
		// Return the width of char ch when fontSize is used.
		int getWidth(int fontSize, char ch);

		// Return Height of any char when fontSize is used.
		int getHeight(int fontSize);
	}

	public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo)
	{
		int[] memo = new int[26];
		for (char ch : text.toCharArray())
		{
			memo[ch - 'a']++;
		}

		int left = 0;
		int middle;
		int right = fonts.length - 1;
		int candidate = -1;
		int width;
		int height;
		while (left <= right)
		{
			middle = (left + right) / 2;
			width = calculateTotalWidth(memo, getWidths(fonts[middle], fontInfo));
			height = fontInfo.getHeight(fonts[middle]);
			if (height <= h && width <= w)
			{
				candidate = fonts[middle];
				left = middle + 1;
			}
			else
			{
				right = middle - 1;
			}
		}

		return candidate;
	}

	private int[] getWidths(int fontSize, FontInfo fontInfo)
	{
		int[] w = new int[26];
		for (char ch = 'a'; ch <= 'z'; ch++)
		{
			w[ch - 'a'] = fontInfo.getWidth(fontSize, ch);
		}

		return w;
	}

	private int calculateTotalWidth(int[] memo, int[] widths)
	{
		int res = 0;
		for (int i = 0; i < 26; i++)
		{
			res += memo[i] * widths[i];
		}

		return res;
	}

	public static void main(String[] args)
	{
		MaximumFontToFitSentenceInScreen clazz = new MaximumFontToFitSentenceInScreen();

		FontInfo fontInfo = new FontInfo()
		{
			@Override
			public int getWidth(int fontSize, char ch)
			{
				return fontSize;
			}

			@Override
			public int getHeight(int fontSize)
			{
				return fontSize;
			}
		};

		System.out.println(clazz.maxFont("helloworld", 80, 20, new int[]{6, 8, 10, 12, 14, 16, 18, 24, 36}, fontInfo));
	}
}
