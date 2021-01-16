import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 1/16/2021
 */
@LeetCode(
	id = 800,
	name = "Similar RGB Color",
	url = "https://leetcode.com/problems/similar-rgb-color/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class SimilarRGBColor
{
	public String similarRGB(String color)
	{
		int minDiff = Integer.MAX_VALUE;
		String answer = "";

		String rR = color.substring(1, 3);
		String rG = color.substring(3, 5);
		String rB = color.substring(5, 7);

		List<String> rgb = Arrays.asList("00", "11", "22", "33", "44", "55", "66", "77", "88", "99", "aa", "bb", "cc", "dd", "ee", "ff");

		int diff;
		for (String r : rgb)
		{
			for (String g : rgb)
			{
				for (String b : rgb)
				{
					diff = diff(rR,r) + diff(rG, g) + diff(rB, b);
					if (minDiff > Math.abs(diff))
					{
						minDiff = Math.abs(diff);
						answer = r+g+b;
					}
				}
			}
		}

		return "#" + answer;
	}

	private int diff(String X, String Y)
	{
		return -(int)(Math.pow((Integer.parseInt(X, 16) - Integer.parseInt(Y, 16)), 2));
	}

	public static void main(String[] args)
	{
		SimilarRGBColor clazz = new SimilarRGBColor();
		System.out.println(clazz.diff("09", "11"));
	}
}
