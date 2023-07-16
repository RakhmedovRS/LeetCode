package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 04-Sep-20
 */
@LeetCode(
		id = 899,
		name = "Orderly Queue",
		url = "https://leetcode.com/problems/orderly-queue/",
		difficulty = Difficulty.HARD
)
public class OrderlyQueue
{
	public String orderlyQueue(String S, int K)
	{
		char[] chars = S.toCharArray();
		if (K > 1)
		{
			int[] memo = new int[26];
			for (char ch : chars)
			{
				memo[ch - 'a']++;
			}
			int i = 0;
			for (int pos = 0; pos < 26; pos++)
			{
				while (memo[pos]-- > 0)
				{
					chars[i++] = (char) (pos + 'a');
				}
			}

			return String.copyValueOf(chars);
		}
		else
		{
			String temp = S;
			for (int i = 1; i < S.length(); i++)
			{
				if (S.charAt(i) > temp.charAt(0))
				{
					continue;
				}
				String tempC = S.substring(i) + S.substring(0, i);
				if (tempC.compareTo(temp) < 0)
				{
					temp = tempC;
				}
			}
			return temp;
		}
	}

	public static void main(String[] args)
	{
		System.out.println(new OrderlyQueue().orderlyQueue("nhtq", 1)); //"htqn"
		System.out.println(new OrderlyQueue().orderlyQueue("cba", 1));
		System.out.println(new OrderlyQueue().orderlyQueue("baaca", 3));
	}
}
