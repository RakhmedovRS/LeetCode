import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 13-Apr-20
 */
@LeetCode(id = 394, name = "Decode String", url = "")
public class DecodeString
{
	public String decodeString(String encodedString)
	{
		if (encodedString == null || encodedString.length() == 0)
		{
			return "";
		}

		Deque<String> values = new LinkedList<>();
		Deque<Integer> count = new LinkedList<>();
		for (int i = 0; i < encodedString.length(); i++)
		{
			char ch = encodedString.charAt(i);
			if (ch == ']')
			{
				StringBuilder value = new StringBuilder();
				while (!values.isEmpty() && !"[".equals(values.getFirst()))
				{
					value.insert(0, values.removeFirst());
				}
				values.removeFirst();

				int number = count.removeFirst();
				StringBuilder newValue = new StringBuilder();
				while (number-- > 0)
				{
					newValue.append(value);
				}
				values.addFirst(newValue.toString());
			}
			else if (ch >= '0' && ch <= '9')
			{
				int number = 0;
				while (encodedString.charAt(i) >= '0' && encodedString.charAt(i) <= '9')
				{
					number = number == 0 ? 0 : number * 10;
					number += (encodedString.charAt(i++) - '0');
				}
				i--;
				count.addFirst(number);
			}
			else
			{
				values.addFirst(String.valueOf(ch));
			}
		}

		StringBuilder result = new StringBuilder();
		while (!values.isEmpty())
		{
			result.append(values.removeLast());
		}
		return result.toString();
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
