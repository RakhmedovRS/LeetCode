import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 9/29/2020
 */
@LeetCode(id = 1405, name = "Longest Happy String", url = "https://leetcode.com/problems/longest-happy-string/")
public class LongestHappyString
{
	public String longestDiverseString(int a, int b, int c)
	{
		int[] count = new int[3];
		count[0] = a;
		count[1] = b;
		count[2] = c;
		PriorityQueue<Character> maxHeap = new PriorityQueue<>((i1, i2) -> count[i2 - 'a'] - count[i1 - 'a']);
		if (a > 0)
		{
			maxHeap.add('a');
		}
		if (b > 0)
		{
			maxHeap.add('b');
		}
		if (c > 0)
		{
			maxHeap.add('c');
		}
		StringBuilder sb = new StringBuilder();
		Character firstChar;
		Character secondChar;
		while (!maxHeap.isEmpty())
		{
			if (sb.length() < 2)
			{
				firstChar = maxHeap.remove();
				sb.append(firstChar);
				count[firstChar - 'a']--;
				if (count[firstChar - 'a'] > 0)
				{
					maxHeap.add(firstChar);
				}
			}
			else
			{
				firstChar = maxHeap.remove();
				if (sb.charAt(sb.length() - 1) == firstChar && sb.charAt(sb.length() - 2) == firstChar)
				{
					if (maxHeap.isEmpty())
					{
						return sb.toString();
					}
					secondChar = maxHeap.remove();
					sb.append(secondChar);
					count[secondChar - 'a']--;
					if (count[secondChar - 'a'] > 0)
					{
						maxHeap.add(secondChar);
					}
					maxHeap.add(firstChar);
				}
				else
				{
					sb.append(firstChar);
					count[firstChar - 'a']--;
					if (count[firstChar - 'a'] > 0)
					{
						maxHeap.add(firstChar);
					}
				}
			}
		}

		return sb.toString();
	}
}
