package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 13-Apr-20
 */
@LeetCode(
		id = 394,
		name = "Decode String",
		url = "https://leetcode.com/problems/decode-string/",
		difficulty = Difficulty.MEDIUM
)
public class DecodeString
{
	public String decodeString(String encodedString)
	{
		LinkedList<Integer> repeats = new LinkedList<>();
		LinkedList<StringBuilder> builders = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		char ch;
		int repeat = 0;
		for (int i = 0; i < encodedString.length(); i++)
		{
			ch = encodedString.charAt(i);
			if (Character.isDigit(ch))
			{
				repeat *= 10;
				repeat += ch - '0';
			}
			else if (ch == '[')
			{
				repeats.addLast(repeat);
				builders.addLast(sb);
				repeat = 0;
				sb = new StringBuilder();
			}
			else if (ch == ']')
			{
				StringBuilder temp = sb;
				sb = builders.removeLast();
				repeat = repeats.removeLast();
				while (repeat-- > 0)
				{
					sb.append(temp);
				}

				repeat = 0;
			}
			else
			{
				sb.append(ch);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(new DecodeString().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
		System.out.println(new DecodeString().decodeString("100[leetcode]"));
		System.out.println(new DecodeString().decodeString("3[a2[c]]"));
		System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
		System.out.println(new DecodeString().decodeString("2[abc]3[cd]ef"));
	}
}
